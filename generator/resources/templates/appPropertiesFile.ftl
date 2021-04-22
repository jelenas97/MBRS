server.port = 8080
spring.application.name = ${app_name}

spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true

spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.sufix=.jsp
