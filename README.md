# Proyecto con AceleradoraUTN 

Este proyecto utiliza las siguientes tecnologías y dependencias:

## Tecnologías principales:
- Java 17
- Spring Boot 3.1.3
- Maven

## Dependencias:
- Lombok: Simplifica la escritura de código al reducir la cantidad de código repetitivo.
- Spring Web: Permite crear aplicaciones web, incluyendo RESTful, usando Spring MVC.
- JUnit: Framework de pruebas para Java.
- Mockito: Framework de pruebas para crear mocks y stubs en Java.
- Spring Data JPA: Facilita la creación de repositorios basados en JPA.
- ModelMapper: Facilita el mapeo automático entre objetos, útil para convertir DTOs a entidades y viceversa.
- Spring Boot Actuator: Proporciona características de producción listas para monitorear y administrar la aplicación.
- MariaDB Driver: Driver necesario para conectar con bases de datos MariaDB.
- Thumbnailator: Biblioteca para la creación de miniaturas de imágenes en Java.
## Estructura del proyecto:
El proyecto sigue el siguiente modelo de carpetas:

- **Modelos**: Contiene las clases de entidades y modelos que representan las tablas de la base de datos.
- **Repositorio**: Contiene las interfaces del repositorio que extienden las capacidades de Spring Data JPA para acceder a la base de datos.
- **Servicios**: Clases de servicio que contienen la lógica de negocio.
- **Utilidades**: Contiene clases de utilidad y funciones que se utilizan en todo el proyecto.
- **DTO**: (Data Transfer Object) Clases que se utilizan para transferir datos entre capas y clases.
- **Controladores**: Contiene las clases de controladores para manejar las solicitudes HTTP y sus respuestas.

## Guía de Despliegue con Docker:

### Prerrequisitos:
1. Asegúrate de tener instalado [Git](https://git-scm.com/book/es/v2/Inicio---Sobre-el-Control-de-Versiones-Instalaci%C3%B3n-de-Git).
2. Debes tener Docker instalado en tu máquina. Si no lo tienes, puedes descargarlo e instalarlo desde la [página oficial de Docker](https://www.docker.com/).

### Instrucciones de Despliegue:
1. Abre la Terminal de Git.
2. Clonar el repositorio de Git. `git clone "https://github.com/disilab-frba-utn-edu-ar/t1-s1-socios-back"`
3. Ingresar a la carpeta donde clonamos el repositorio y abrir una consola
4. Correr el comando docker build -t javaback:latest .    (asegurarse tener corriendo docker)
5. Ejecutar el comando docker compose up
6. Abre http://localhost:8080 para visualizar el proyecto en tu navegador.

