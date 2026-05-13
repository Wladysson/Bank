# core-banking-payments

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/core-banking-payments-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- Security WebAuthn ([guide](https://quarkus.io/guides/security-webauthn)): Secure your applications with WebAuthn
- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- Hibernate ORM ([guide](https://quarkus.io/guides/hibernate-orm)): Define your persistent model with Hibernate ORM and Jakarta Persistence
- Kafka Streams Processor ([guide](https://docs.quarkiverse.io/quarkus-kafka-streams-processor/dev/index.html)): Easily build resilient Kafka Streams topologies based on the Processor API
- Messaging - Kafka Connector ([guide](https://quarkus.io/guides/kafka-getting-started)): Connect to Kafka with Reactive Messaging
- Security JPA ([guide](https://quarkus.io/guides/security-getting-started)): Secure your applications with username/password stored in a database via Jakarta Persistence
- SmallRye JWT Build ([guide](https://quarkus.io/guides/security-jwt-build)): Create JSON Web Token with SmallRye JWT Build API
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC
- Micrometer metrics ([guide](https://quarkus.io/guides/micrometer)): Instrument the runtime and your application with dimensional metrics using Micrometer.
- Quarkus CXF WS-Security ([guide](https://quarkiverse.github.io/quarkiverse-docs/quarkus-cxf/dev/reference/extensions/quarkus-cxf-rt-ws-security.html)): Consume and produce web services with Web Services Security (WS-Security, WSS)

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)



### Messaging codestart

Use Quarkus Messaging

[Related Apache Kafka guide section...](https://quarkus.io/guides/kafka-reactive-getting-started)


### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

# Payments Service

Serviço responsável pelo processamento de pagamentos da plataforma, cobrindo liquidação de boletos, pagamentos via QR Code, pagamentos em lote, cobranças recorrentes, integração com gateways, cashback, pagamentos NFC e fluxos de estorno e chargeback.

## Funcionalidades

- Liquidação de boletos por linha digitável ou código de barras
- Processamento de pagamentos via QR Code
- Gestão de pagamentos em lote para empresas
- Cobranças recorrentes para assinaturas e mensalidades
- Integração com gateways de pagamento
- Aplicação de cashback e recompensas
- Processamento de pagamentos NFC / contactless
- Estorno, reembolso e chargeback
- Validação de pagamento, limites e fraude
- Controle de idempotência, retries e auditoria

## Estrutura do Projeto

```text
payments-service/
│
├── application/
│   ├── usecase/
│   │   ├── payment/
│   │   │   ├── ProcessPaymentUseCase.java
│   │   │   ├── ProcessPaymentCommand.java
│   │   │   ├── RefundPaymentUseCase.java
│   │   │   ├── ChargebackUseCase.java
│   │   │   ├── GetPaymentStatusUseCase.java
│   │   │   └── ValidatePaymentUseCase.java
│   │   │
│   │   ├── boleto/
│   │   │   ├── ProcessBoletoPaymentUseCase.java
│   │   │   ├── ValidateBoletoUseCase.java
│   │   │   └── ParseLinhaDigitavelUseCase.java
│   │   │
│   │   ├── qrcode/
│   │   │   ├── ProcessQRCodePaymentUseCase.java
│   │   │   ├── DecodeQRCodeUseCase.java
│   │   │   └── ValidateQRCodeUseCase.java
│   │   │
│   │   ├── batch/
│   │   │   ├── ProcessBatchPaymentsUseCase.java
│   │   │   ├── ValidateBatchUseCase.java
│   │   │   └── BatchStatusUseCase.java
│   │   │
│   │   ├── recurring/
│   │   │   ├── CreateSubscriptionUseCase.java
│   │   │   ├── ExecuteRecurringPaymentUseCase.java
│   │   │   ├── CancelSubscriptionUseCase.java
│   │   │   └── ListSubscriptionsUseCase.java
│   │   │
│   │   ├── nfc/
│   │   │   └── ProcessNfcPaymentUseCase.java
│   │   │
│   │   ├── gateway/
│   │   │   └── RoutePaymentToGatewayUseCase.java
│   │   │
│   │   └── cashback/
│   │       └── ApplyCashbackUseCase.java
│   │
│   ├── service/
│   │   ├── PaymentOrchestratorService.java
│   │   ├── PaymentStateMachine.java
│   │   ├── IdempotencyService.java
│   │   ├── FraudCheckService.java
│   │   ├── LimitCheckService.java
│   │   ├── FeeService.java
│   │   ├── RetryService.java
│   │   ├── SagaOrchestratorService.java
│   │   ├── PaymentRoutingService.java
│   │   ├── NotificationService.java
│   │   └── AuditService.java
│   │
│   ├── dto/
│   │   ├── request/
│   │   │   ├── PaymentRequest.java
│   │   │   ├── BoletoPaymentRequest.java
│   │   │   ├── QRCodePaymentRequest.java
│   │   │   ├── BatchPaymentRequest.java
│   │   │   ├── SubscriptionRequest.java
│   │   │   └── RefundRequest.java
│   │   │
│   │   ├── response/
│   │   │   ├── PaymentResponse.java
│   │   │   ├── PaymentStatusResponse.java
│   │   │   ├── BatchResponse.java
│   │   │   └── SubscriptionResponse.java
│   │   │
│   │   └── internal/
│   │       └── LedgerPostingRequest.java
│   │
│   └── mapper/
│       ├── PaymentMapper.java
│       └── BoletoMapper.java
│
├── domain/
│   ├── model/
│   │   ├── Payment.java
│   │   ├── PaymentId.java
│   │   ├── PaymentStatus.java
│   │   ├── PaymentMethod.java
│   │   ├── PaymentType.java
│   │   ├── Money.java
│   │   ├── Boleto.java
│   │   ├── QRCode.java
│   │   ├── Subscription.java
│   │   ├── Refund.java
│   │   ├── Chargeback.java
│   │   ├── BatchPayment.java
│   │   ├── PaymentAttempt.java
│   │   └── PaymentMetadata.java
│   │
│   ├── event/
│   │   ├── PaymentCreatedEvent.java
│   │   ├── PaymentAuthorizedEvent.java
│   │   ├── PaymentCapturedEvent.java
│   │   ├── PaymentFailedEvent.java
│   │   ├── PaymentRefundedEvent.java
│   │   ├── ChargebackOpenedEvent.java
│   │   ├── ChargebackClosedEvent.java
│   │   ├── CashbackGrantedEvent.java
│   │   ├── PaymentPendingEvent.java
│   │   ├── PaymentRetryEvent.java
│   │   └── PaymentReconciledEvent.java
│   │
│   ├── repository/
│   │   ├── PaymentRepository.java
│   │   ├── SubscriptionRepository.java
│   │   └── BatchRepository.java
│   │
│   ├── service/
│   │   ├── PaymentDomainService.java
│   │   ├── FeeCalculationService.java
│   │   └── ValidationDomainService.java
│   │
│   └── exception/
│       ├── PaymentDomainException.java
│       └── InsufficientFundsException.java
│
├── infrastructure/
│   ├── persistence/
│   │   ├── entity/
│   │   │   ├── PaymentEntity.java
│   │   │   ├── SubscriptionEntity.java
│   │   │   └── BatchEntity.java
│   │   │
│   │   ├── repository/
│   │   │   ├── PaymentRepositoryImpl.java
│   │   │   ├── SubscriptionRepositoryImpl.java
│   │   │   └── BatchRepositoryImpl.java
│   │   │
│   │   └── mapper/
│   │       └── PaymentEntityMapper.java
│
│   ├── integration/
│   │   ├── ledger/
│   │   │   ├── LedgerClient.java
│   │   │   └── LedgerFallback.java
│   │   │
│   │   ├── gateway/
│   │   │   ├── PaymentGateway.java
│   │   │   ├── GatewaySelector.java
│   │   │   ├── adapters/
│   │   │   │   ├── CieloAdapter.java
│   │   │   │   ├── StoneAdapter.java
│   │   │   │   └── StripeAdapter.java
│   │   │
│   │   ├── qr/
│   │   │   └── QRDecoder.java
│   │   │
│   │   └── nfc/
│   │       └── NFCProcessor.java
│
│   ├── messaging/
│   │   ├── producer/
│   │   │   ├── PaymentEventProducer.java
│   │   │   └── DeadLetterProducer.java
│   │   │
│   │   ├── consumer/
│   │   │   ├── PaymentCallbackConsumer.java
│   │   │   └── ReconciliationConsumer.java
│   │   │
│   │   └── outbox/
│   │       ├── OutboxEntity.java
│   │       ├── OutboxRepository.java
│   │       └── OutboxProcessor.java
│
│   ├── scheduler/
│   │   ├── RecurringPaymentJob.java
│   │   ├── BatchProcessingJob.java
│   │   └── PaymentTimeoutJob.java
│
│   ├── idempotency/
│   │   └── IdempotencyEntity.java
│
│   ├── config/
│   │   ├── RestClientConfig.java
│   │   ├── SecurityConfig.java
│   │   └── ObjectMapperConfig.java
│
│   └── resilience/
│       ├── CircuitBreakerConfig.java
│       ├── RetryConfig.java
│       └── TimeoutConfig.java
│
├── interfaces/
│   ├── rest/
│   │   ├── resource/
│   │   │   ├── v1/
│   │   │   │   ├── PaymentResource.java
│   │   │   │   ├── BoletoResource.java
│   │   │   │   ├── QRCodeResource.java
│   │   │   │   ├── BatchResource.java
│   │   │   │   ├── SubscriptionResource.java
│   │   │   │   ├── RefundResource.java
│   │   │   │   └── WebhookResource.java
│   │
│   │   ├── filter/
│   │   │   ├── IdempotencyFilter.java
│   │   │   ├── LoggingFilter.java
│   │   │   ├── CorrelationIdFilter.java
│   │   │   └── RateLimitFilter.java
│   │
│   │   └── exception/
│   │       ├── GlobalExceptionMapper.java
│   │       ├── ErrorResponse.java
│   │       ├── ErrorCode.java
│   │       └── ExceptionUtils.java
│
│   ├── graphql/
│   │   └── PaymentGraphQLResource.java
│
│   └── health/
│       ├── ReadinessCheck.java
│       └── LivenessCheck.java
```

## Organização em Camadas

- `application`: casos de uso, orquestração, DTOs e mapeamentos
- `domain`: modelos de pagamento, eventos, regras de negócio e contratos
- `infrastructure`: persistência, integrações externas, mensageria, jobs e resiliência
- `interfaces`: APIs REST, GraphQL, filtros e health checks

## Integrações

- Gateways externos de pagamento
- Ledger para escrituração financeira
- Kafka para eventos, callbacks e reconciliação
- QR decoder, NFC processor e webhooks de retorno
