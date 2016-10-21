/*
 * Copyright 2015 Willian Oki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.github.woki.payments.adyen.action;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Locale;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
public class ActionUtilEncryptionTest {
    private static final String PUBKEY_TEXT = "10001|9B27E6AE115FB582C795C40F19BF77C2DD6875C4E410E39AFD3A861408A3D9A97057AFFC8D7C3FE3B3314ACEC2F8C3036CB6D6212005107529E253218240DC95173E45B9856C6266BBBB05797400674C028E1F86134F6BBE752C47ADD1A35BEAB972E8F2EFBCB9057C70EDE365BF9E8C9B75E58C2ED4AE34DFF2FAFB5DC1886AE1D90B13D48F6182CA0E37881D9277AED7F745D544EBDB066E129D2B74F5B294526679956E9CFA9A83624C67621796F95CB011B133A7D2DC18934D7505A31E5EABB7E05E21FFD33F9885A30BD494ED0F174FA0630BB1A60F270E30B8F8BCC18C0FA085D938AE12D7EC2D64254615F602A07D229517F46DC31CF354B7E6E12783";
    private static SecureRandom SEC_RANDOM;

    @BeforeClass
    public static void beforeClass() {
        Security.addProvider(new BouncyCastleProvider());
        SEC_RANDOM = new SecureRandom();
    }

    @Test
    public void testEncryption() throws Exception {
        String[] keyComponents = PUBKEY_TEXT.split("\\|");
        KeyFactory keyFactory;
        PublicKey pubKey;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(new BigInteger(keyComponents[1].toLowerCase(Locale.getDefault()), 16), new BigInteger(keyComponents[0].toLowerCase(Locale.getDefault()), 16));
        Cipher aesCipher = null, rsaCipher;
        try {
            pubKey = keyFactory.generatePublic(pubKeySpec);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("Problem reading public key: " + PUBKEY_TEXT, e);
        }

        try {
            aesCipher = Cipher.getInstance("AES/CCM/NoPadding", "BC");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Problem instantiation AES Cipher Algorithm", e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException("Problem instantiation AES Cipher Padding", e);
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        try {
            rsaCipher = Cipher.getInstance("RSA/None/PKCS1Padding");
            rsaCipher.init(Cipher.ENCRYPT_MODE, pubKey);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Problem instantiation RSA Cipher Algorithm", e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException("Problem instantiation RSA Cipher Padding", e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException("Invalid public key: " + PUBKEY_TEXT, e);
        }

        String result = encrypt(SEC_RANDOM, aesCipher, rsaCipher, "4444444444444444");
        System.out.println(result);
    }

    private static String encrypt(SecureRandom srandom, Cipher aesCipher, Cipher rsaCipher, String plainText) {
        String VERSION = "1_1_1";
        String SEPARATOR = "$";
        String PREFIX = "encrypter";

        SecretKey aesKey = generateAESKey(256);
        byte[] iv = generateIV(srandom, 12);
        byte[] encrypted;
        try {
            aesCipher.init(Cipher.ENCRYPT_MODE, aesKey, new IvParameterSpec(iv));
            // getBytes is UTF-8 on Android by default
            encrypted = aesCipher.doFinal(plainText.getBytes());
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException("Incorrect AES Block Size", e);
        } catch (BadPaddingException e) {
            throw new RuntimeException("Incorrect AES Padding", e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException("Invalid AES Key", e);
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException("Invalid AES Parameters", e);
        }

        byte[] result = new byte[iv.length + encrypted.length];
        // copy IV to result
        System.arraycopy(iv, 0, result, 0, iv.length);
        // copy encrypted to result
        System.arraycopy(encrypted, 0, result, iv.length, encrypted.length);

        byte[] encryptedAESKey;
        try {
            encryptedAESKey = rsaCipher.doFinal(aesKey.getEncoded());
            return String.format("%s%s%s%s%s%s", PREFIX, VERSION, SEPARATOR, Base64.encodeBase64String(encryptedAESKey), SEPARATOR, Base64.encodeBase64String(result));
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException("Incorrect RSA Block Size", e);
        } catch (BadPaddingException e) {
            throw new RuntimeException("Incorrect RSA Padding", e);
        }
    }

    private static SecretKey generateAESKey(int keySize) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(keySize);
            return kgen.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Unable to get AES algorithm", e);
        }

    }

    private static synchronized byte[] generateIV(SecureRandom srandom, int ivSize) {
        byte[] iv = new byte[ivSize];//generate random IV AES is always 16bytes, but in CCM mode this represents the NONCE
        srandom.nextBytes(iv);
        return iv;
    }
}
