# Usa una imagen base de JDK 17
FROM openjdk:17-alpine

# Instala Bash
RUN apk add --no-cache bash

# Directorio donde nuestra aplicación se ejecutará dentro del contenedor
WORKDIR /app

# Copio cualquier JAR compilado al contenedor
COPY target/*.jar /app/app.jar

RUN ls -la /app