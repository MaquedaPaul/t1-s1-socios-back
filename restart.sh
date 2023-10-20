#!/bin/bash

# Detenemos y eliminamos los contenedores actuales
echo "Deteniendo y eliminando contenedores actuales..."
docker-compose down

# Construimos y levantamos los contenedores nuevamente
echo "Construyendo y levantando nuevos contenedores..."
read -p "Introduce la ruta donde quieres guardar las imágenes: " ruta_imagenes
# si el directorio no esta yo lo creo para que no hay error
[ ! -d "$ruta_imagenes" ] && mkdir -p "$ruta_imagenes"

chmod +x wait-for-it.sh

# Uso Docker Compose para construir y ejecutar los servicios
echo "Usando Docker Compose para construir y ejecutar los servicios..."
PATH_IMAGENES=$ruta_imagenes docker-compose up --build -d
