# Kafka Producer

This is a simple Kafka Producer application built with Spring Boot.

## Prerequisites

- Java 17
- Apache Kafka
- Maven
- Docker

## Getting Started

 - **Setup Kafka using Docker:**
    Create a `docker-compose.yml` file in the root directory of your project with the following content:
    ```yaml
    version: '3.8'
    services:
      zookeeper:
        image: confluentinc/cp-zookeeper:7.4.1
        container_name: zookeeper
        environment:
          ZOOKEEPER_CLIENT_PORT: 2181
          ZOOKEEPER_TICK_TIME: 2000
        ports:
          - "2181:2181"

      kafka:
        image: confluentinc/cp-kafka:7.4.1
        container_name: kafka
        ports:
          - "9092:9092"
        environment:
          KAFKA_BROKER_ID: 1
          KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
          KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092
          KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
        depends_on:
          - zookeeper
    ```

    Then, run the following command to start Kafka and Zookeeper:
    ```sh
    docker-compose up -d
    ```

### Installation

1. Clone the producer repository:
```sh
git clone https://github.com/MayankShivhare999/kafka-producer.git
```
2. Navigate to the project directory:
```sh
cd kafka-producer
```

3. Build the project:
```sh
mvn clean install
```

4. To run the producer application, use the following command:
```sh
mvn spring-boot:run
```

5. Clone the consumer repository:
```sh
git clone https://github.com/MayankShivhare999/kafka-consumer.git
```

6. Navigate to the project directory:
```sh
cd kafka-consumer
```

7. Build the project:
```sh
mvn clean install
```

8. To run the consumer application, use the following command:
```sh
mvn spring-boot:run
```


