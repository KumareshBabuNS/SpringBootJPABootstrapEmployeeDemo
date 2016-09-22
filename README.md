<h1>SpringBoot JPA Bootstrap Employee Demo</h2>

The following demo shows how to use a H2 database while developing locally and then how to swicth to a MySQl 
bound service instance in Pivotal Cloud Foundry

![alt tag](https://dl.dropboxusercontent.com/u/15829935/platform-demos/images/springboot-employee-1.png)

<h3> Running Locally </h3>

- Clone and package as follows

```
$ git clone https://github.com/papicella/SpringBootJPABootstrapEmployeeDemo.git
$ mvn package
```

- Run as follows

```
$ mvn spring-boot:run

```

<h3> Push to Pivotal Cloud Foundry </h3>

- Create a MySQL instance on PCF

```
$ cf create-service cleardb spark apples-mysql
```

- Push using manifest.yml as follows ensuring you use the correct MySQL service name

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
    - apples-mysql
  env:
    JAVA_OPTS: -Djava.security.egd=file:///dev/urando
    SPRING_PROFILES_ACTIVE: cloud
```

- Deploy to PCF

```
$ cf push 
```

<hr />
Pas Apicella [papicella at pivotal.io] is a Senior Platform Architect at Pivotal Australia 