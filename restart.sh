#!/bin/bash

echo "Reconstruyendo la aplicación Spring Boot..."

./mvnw clean
./mvnw validate
./mvnw package -DskipTests

if [ $? -ne 0 ]; then
  echo "Error al reconstruir la aplicación Spring Boot."
  exit 1
fi

echo "Usando Docker Compose para reconstruir y reiniciar los servicios..."
docker-compose down
docker-compose up --build -d

if [ $? -ne 0 ]; then
  echo "Error al usar Docker Compose."
  exit 1
fi

# Pequeña pausa para dar tiempo a los contenedores de iniciar
sleep 10

# Mostrar logs de MySQL para diagnóstico
echo "Mostrando logs de MySQL..."
docker-compose logs mysql-tabla

# Finalizado
echo "Aplicación Spring Boot y MySQL han sido reiniciados correctamente."