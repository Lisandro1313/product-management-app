# Gestión de Productos

Este es un proyecto de gestión de productos desarrollado en Java con Spring Boot. Proporciona una API RESTful que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en una base de datos de productos.

## Funcionalidades

El proyecto ofrece las siguientes funcionalidades:

- Crear un producto con nombre, descripción, precio y cantidad.
- Actualizar un producto existente.
- Consultar un producto por ID o por nombre.
- Eliminar un producto existente.
- Consultar todos los productos ordenados por precio.

## Tecnologías utilizadas

- Java
- Spring Boot
- Spring Data JPA
- H2 Database (base de datos en memoria)

## Configuración

Antes de ejecutar el proyecto, asegúrate de tener instalado Java y MySQL. Además, asegúrate de configurar las credenciales y la URL de la base de datos en el archivo `application.properties` según tus preferencias.

## Cómo ejecutar el proyecto

1. Clona este repositorio.
2. Abre el proyecto en tu IDE favorito (por ejemplo, IntelliJ IDEA, Eclipse).
3. Configura las dependencias y los ajustes de configuración según sea necesario.
4. Ejecuta la aplicación desde tu IDE o utiliza el comando `mvn spring-boot:run` en la línea de comandos.

Una vez que el proyecto esté en ejecución, puedes utilizar Postman u otra herramienta similar para interactuar con la API y probar las diferentes funcionalidades.


![Crud con Postman](https://res.cloudinary.com/dd8wdqyeb/image/upload/v1684623498/Grabaci%C3%B3n-2023-05-20-194249_zp8i1e.gif)
