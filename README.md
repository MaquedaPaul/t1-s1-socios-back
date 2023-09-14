# Proyecto con AceleradoraUTN 

Este proyecto utiliza las siguientes tecnologías y dependencias:

## Tecnologías principales:
- Java 17
- Spring Boot 3.1.3
- Maven

## Dependencias:
- Lombok: Simplifica la escritura de código al reducir la cantidad de código repetitivo.
- Spring Web: Permite crear aplicaciones web, incluyendo RESTful, usando Spring MVC.
- Spring Security: Provee características de seguridad como autenticación y autorización.
- JUnit: Framework de pruebas para Java.
- Mockito: Framework de pruebas para crear mocks y stubs en Java.
- Spring Data JPA: Facilita la creación de repositorios basados en JPA.
- Spring Boot Actuator: Proporciona características de producción listas para monitorear y administrar la aplicación.
- MySQL Driver: Driver necesario para conectar con bases de datos MySQL.

## Estructura del proyecto:
El proyecto sigue el siguiente modelo de carpetas:

- **Modelos**: Contiene las clases de entidades y modelos que representan las tablas de la base de datos.
- **Repositorio**: Contiene las interfaces del repositorio que extienden las capacidades de Spring Data JPA para acceder a la base de datos.
- **Servicios**: Clases de servicio que contienen la lógica de negocio.
- **Utilidades**: Contiene clases de utilidad y funciones que se utilizan en todo el proyecto.
- **DTO**: (Data Transfer Object) Clases que se utilizan para transferir datos entre capas y clases.
- **Controladores**: Contiene las clases de controladores para manejar las solicitudes HTTP y sus respuestas.
