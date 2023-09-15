FROM openjdk:17-alpine

# Instalo bash
RUN apk add --no-cache bash

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

#Copio el script para esperar a que la base de datos este lista
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

EXPOSE 8080