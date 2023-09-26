#!/bin/bash

# Detenemos y eliminamos los contenedores actuales
echo "Deteniendo y eliminando contenedores actuales..."
docker-compose down

# Construimos y levantamos los contenedores nuevamente
echo "Construyendo y levantando nuevos contenedores..."
docker-compose up --build -d
