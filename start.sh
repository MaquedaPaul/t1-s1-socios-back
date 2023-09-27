#!/bin/bash

# Descargo el script wait-for-it
echo "Descargando el script wait-for-it.sh..."
curl -o wait-for-it.sh https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh

if [ $? -ne 0 ]; then
  echo "Error al descargar wait-for-it.sh."
  exit 1
fi

read -p "Introduce la ruta donde quieres guardar las imágenes: " ruta_imagenes
# si el directorio no esta yo lo creo para que no hay error
[ ! -d "$ruta_imagenes" ] && mkdir -p "$ruta_imagenes"

chmod +x wait-for-it.sh

# Uso Docker Compose para construir y ejecutar los servicios
echo "Usando Docker Compose para construir y ejecutar los servicios..."
PATH_IMAGENES=$ruta_imagenes docker-compose up --build -d


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
echo "Aplicación Spring Boot y MySQL están en funcionamiento."