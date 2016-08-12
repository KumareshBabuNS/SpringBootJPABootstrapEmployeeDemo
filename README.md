<h1>SpringBoot JPA Bootstrap Employee Demo</h2>

The following demo shows how to use a MySQL instance while running locally on your laptop and then use a MySQL instance in the cloud with
Pivotal Cloud Foundry without code changes using Spring Cloud Connectors

![alt tag](https://dl.dropboxusercontent.com/u/15829935/platform-demos/images/springboot-employee-1.png)

<h3> Running Locally </h3>

- Create a file called "spring-cloud-mysql.properties" with details to you local MySQL instance on your network/laptop/PC etc

```
spring.cloud.appId: SpringBootMYSQLLocal
spring.cloud.database: mysql://pas:pas@localhost:3306/apples
spring.datasource.max-active: 5
spring.datasource.initial-size: 1
```

- Reference the file location in "resources/spring-cloud-bootstrap.properties" a shown below

```
spring.cloud.propertiesFile: /Users/pasapicella/springboot/spring-cloud-mysql.properties
```

<h3> Push to Pivotal Cloud Foundry </h3>

- Create a MySQL instance on PCF

```
$ cf create-service cleardb spark apples-mysql
```

- Push using manifest.yml as follows  ensuring you use the correct MySQL service name

```
---
applications:
- name: springboot-bootstrap-employee
  memory: 512M
  instances: 1
  random-route: true
  timeout: 180
  path: ./target/springbootjpabootstrapemployeedemo-0.0.1-SNAPSHOT.jar
  services:
    - mysql-dev
```

<hr />
Pas Apicella [papicella at pivotal.io] is a Senior Platform Architect at Pivotal Australia 