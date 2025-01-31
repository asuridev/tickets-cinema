# Prueba Técnica: Sección 3 item 11 (Sistema de reserva de tickets)

Para el desarrollo de la prueba se optó por utilizar el framework spring-boot, dado que implementa JAVA como lenguaje de programación, soportando una alta concurrencia.

El sistema desarrollado consiste en una aplicación de reserva de tickets para cine. para este fin se construyeron
3 entidades con sus respectivas relaciones.

- users
- tickets
- movies

!["request"](/assets/modelo-db.png)

## Desarrollo de la API-REST
Para cada uno de los dominios se implementó un CRUD completo

- /api/v1/movie
- /api/v1/user
- /api/v1/ticket

persistiendo la data en una base de datos PostgresSQL.

### Persistencia  de los datos
Para esta tarea se implementó la base de datos Postgres. el servidor se conectó a esta utilizando Spring-JPA.

!["data-base"](/assets/db.png)

Se utilizó repository como patrón para la persistencia de los datos y desacoplar lógica de dominio de los detalles de la base de datos.

Ademas cuando el servidor es iniciado por primera vez se ejecutará una migración para insertar datos, crear las tablas y relaciones necesarias para el funcionamiento optimo de la base de datos.

## Deployment del proyecto.
Para el despliegue del proyecto seguir los siguientes pasos:

1. Clonar el repositorio.

```shell script
git clone https://github.com/asuridev/tickets-cinema.git
```
2. Ingresar a la raíz del proyecto.

```shell script
cd tickets-cinema
```
3. Ejecutar docker-compose

```shell script
docker-compose up --build
```
Este ultimo comando construirá un cluster de docker-compose con dos contenedores, uno para el servidor y otro para la base de datos de postgreSQL.

## Verificando el funcionaminto del proyecto.

### Validación del endpoint
Las APIs exponen los diferentes endpoints en el puerto 8000.
según los metodos HTTP se construyó un CRUD completo para cada uno de ellos.
```
localhost:8000/api/v1/user
```
```
localhost:8000/api/v1/movie
```
```
localhost:8000/api/v1/ticket
```

> **_NOTA:_**  Ver la documentación de los diferentes endpoints publicada en el siguinte enlace: https://documenter.getpostman.com/view/19057359/2sAYX2Miw6

### Consulta de la Base de datos.
Luego de ingresar varios registros de forma exitosa a traves de los difernetes endpoints, se puede realizar la conexión a la base de datos para verificar la persistencia de los mismos.

El cluster de docker-compose expone el puerto **5432** para permitir la conexión mediante un cliente gráfico de Postgres.

Parametros de conexion de la base de datos

```
host: localhost
port: 5432
database: database
user: user
password: secret
```