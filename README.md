#Java client for Adyen Payment System

[Adyen](http://www.adyen.com)
> is the leading technology provider powering payments for global commerce in the 21st century.
> With a seamless solution for mobile, online and in-store transactions, our technology enables merchants to accept almost any
> type of payment, anywhere in the world.

Adyen Payment System, **APS**, lies at the heart of its payment platform and it's the service a merchant integrates with for
payment processing.

**adyen-java-client** aims to be a cohesive and opinionated way for consuming APS' JSON messaging based services.

##Usage

In order to run the tests you just have to `mvn test`. Notice that you have to edit and save the **application.properties**
according to your *Merchant account name* and *credentials*. For instance:
```properties
aps.merchant.account=Acme
aps.merchant.username=foo
aps.merchant.password=&$#bar))>
```

###Client instantiation
```java
   Client client = Client
      .services(TEST_SERVICES)
      .credentials(username, password)
      .build();
```

###Authorisation
```java
   PaymentRequest request = PaymentRequestBuilder
      .merchantAccount(merchantAccount)
      .amount(new Amount(Currency.getInstance("EUR"), 1000L))
      .card(CardBuilder.number("4111111111111111").cvc("737").expiry(2016, 6).holder("Johnny Tester Visa").build())
      .reference(reference(ReferenceType.UUID))
      .shopper("willian.oki@gmail.com", "127.0.0.1", "Test/DAPI/Authorisation/Willian Oki", ShopperInteraction.Ecommerce)
      .build();
   PaymentResponse response = client.authorise(request);
```

###Capture
```java
   ModificationRequest captureRequest = ModificationRequestBuilder
      .merchantAccount(merchantAccount)
      .modificationAmount(new Amount(Currency.getInstance("EUR"), 1000L))
      .originalReference(paymentResponse.getPspReference())
      .reference(reference(ReferenceType.UUID))
      .build();
   ModificationResponse captureResponse = client.capture(captureRequest);
```

###Cancel/Refund
```java
   ModificationRequest cancelRequest = ModificationRequestBuilder
      .merchantAccount(merchantAccount)
      .originalReference(paymentResponse.getPspReference())
      .reference(reference(ReferenceType.UUID))
      .build();
   ModificationResponse cancelResponse = client.cancel(cancelRequest);
```
```java
   ModificationRequest refundRequest = ModificationRequestBuilder
      .merchantAccount(merchantAccount)
      .modificationAmount(new Amount(Currency.getInstance("EUR"), 1000L))
      .originalReference(paymentResponse.getPspReference())
      .reference(reference(ReferenceType.UUID))
      .build();
   ModificationResponse refundResponse = client.refund(refundRequest);
```
```java
   ModificationRequest cancelOrRefundRequest = ModificationRequestBuilder
       .merchantAccount(merchantAccount)
       .originalReference(paymentResponse.getPspReference())
       .reference(reference(ReferenceType.UUID))
       .build();
   ModificationResponse cancelOrRefundResponse = client.cancelOrRefund(cancelOrRefundRequest);
```

###Other
