<h1>SpringBoot JPA Bootstrap Employee Demo</h2>

The following demo shows how to use a H2 database while developing locally and then how to switch to a MySQl 
bound service instance in Pivotal Cloud Foundry. The blog entry below does into detail on how this works as
well as how to enable the H2 web console in DEV mode.

http://theblasfrompas.blogspot.com.au/2016/09/using-h2-console-in-development-with.html

![alt tag](https://dl.dropboxusercontent.com/u/15829935/platform-demos/images/springboot-employee-1.png)

<h3> Running Locally </h3>

- Clone and package as follows

```
$ git clone https://github.com/papicella/SpringBootJPABootstrapEmployeeDemo.git
$ mvn package
```

- Run as follows

Note: You will need a Eureka Server running locally with @EnableEurekaServer annotation on your Spring Boot main class 
for this demo to run locally.

```
$ mvn spring-boot:run

```

<h3> Push to Pivotal Cloud Foundry </h3>

- Create required services on PCF

```
$ cf create-service cleardb spark apples-mysql
$ cf create-service p-service-registry standard service-registry
```

- Push using manifest.yml as follows ensuring you use the correct MySQL service name

```
---
applications:
- name: springboot-bootstrap-employee
  memory: 1G
  instances: 1
  random-route: true
  timeout: 180
  path: ./target/springbootjpabootstrapemployeedemo-0.0.1-SNAPSHOT.jar
  services:
    - apples-mysql
    - service-registry
  env:
    JAVA_OPTS: -Djava.security.egd=file:///dev/urando
    SPRING_PROFILES_ACTIVE: cloud
```

- Deploy to PCF

```
$ cf push 
```


<h3>Spring Cloud Service Registry - Bound Service Instance</h3>

![alt tag](https://dl.dropboxusercontent.com/u/15829935/platform-demos/images/piv-service-registry-1.png)

<hr />
Pas Apicella [papicella at pivotal.io] is a Senior Platform Architect at Pivotal Australia 