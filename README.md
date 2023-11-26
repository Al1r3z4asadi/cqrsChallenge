# CQRS-EVENTSOURCING CHALLENGE



## Overview

This project is a Java and Spring application that embraces CQRS (Command Query Responsibility Segregation) and Event Sourcing architecture. It uses PostgreSQL for the write database and MongoDB for the read database. The system employs Debezium and the Outbox Pattern for efficient data synchronization between the databases, and Kafka as the messaging system for seamless communication.

## Features

- **CQRS and Event Sourcing:** The application follows the CQRS pattern to separate read and write operations, enhancing scalability and flexibility. Event Sourcing is employed to persist and retrieve changes as a sequence of events.

- **PostgreSQL (Write Database):** PostgreSQL serves as the write database, providing a reliable and performant storage solution for command operations.

- **MongoDB (Read Database):** MongoDB is used as the read database, optimizing for rapid data reads and flexibility in handling various data formats.

- **Debezium for Change Data Capture (CDC):** Debezium captures and propagates changes from the PostgreSQL database to the messaging system, allowing for real-time synchronization.

- **Outbox Pattern:** The Outbox Pattern is implemented to ensure atomicity in write operations and maintain consistency between the write and read databases.

- **Kafka Messaging:** Kafka acts as the messaging backbone, enabling asynchronous communication between microservices and ensuring a decoupled and scalable architecture.

## Getting Started

### Prerequisites

- Java [17]
- Spring Boot [3.2.0]
- PostgreSQL 
- MongoDB 
- Debezium 
- Kafka 
- Gradle

### Installation

1. Clone the repository: `git clone git@github.com:Al1r3z4asadi/cqrsChallenge.git`
2. Configure application properties for PostgreSQL and MongoDB in `application.properties` or `application.yml`.
3. Set up Debezium configuration for PostgreSQL CDC.
4. Configure Kafka properties for messaging.

### Usage

1. Build the project: `./gradlew clean build`
2. Run the application: `./gradlew bootRun`

### Contributing

We welcome contributions! Please feel free to open issues, submit pull requests, or provide feedback.

