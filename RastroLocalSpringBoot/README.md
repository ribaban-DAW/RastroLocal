# RastroLocal CRUD PoC

## Descripción

Prueba de concepto para CRUD de RastroLocal

## Uso

Crear un `application.properties` en `src/resources/application.properties` basado en `application.example.properties`.

Rellenar las siguientes propiedades:

- server.port
- spring.datasource.url
- spring.datasource.username
- spring.datasource.password

### Linux

Ejecutar `./mvnw spring-boot:run`

### Windows

Ejecutar `.\mvnw.cmd spring-boot:run`

## Endpoints

Los endpoints disponibles son

| Método | Ruta                  | Descripción                  |
| ------ | --------------------- | ---------------------------- |
| GET    | `/api/products/{id}`  | Obtener producto por id      |
| GET    | `/api/products`       | Listar productos             |
| POST   | `/api/products`       | Crear producto               |
| PUT    | `/api/products/{id}`  | Actualizar producto          |
| DELETE | `/api/products/{id}`  | Eliminar producto            |
| GET    | `/api/users/{id}`     | Obtener usuario por id       |
| GET    | `/api/users`          | Listar usuarios              |
| POST   | `/api/users`          | Crear usuario                |
| PUT    | `/api/users/{id}`     | Actualizar usuario           |
| DELETE | `/api/users/{id}`     | Eliminar usuario             |
