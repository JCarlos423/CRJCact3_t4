# CRJCact3_t4 - Sistema CRUD de Directores y Películas (Spring Boot + JPA)

Este repositorio contiene la solución completa para la **Actividad 3 del Tema 4**, implementando un sistema **CRUD relacional en Spring Boot** conectado a una base de datos MySQL/MariaDB real, sin depender de un framework frontend externo (utilizando **Thymeleaf** para vistas internas y **REST Endpoints** para pruebas con Postman/Bruno).

---

## Tecnologías y Herramientas

* **Lenguaje:** Java 17+
* **Framework Backend:** Spring Boot (Spring Web, Spring Data JPA, Thymeleaf)
* **Base de Datos:** MySQL 
* **Gestor de Dependencias:** Maven
* **Cliente API:** Postman
* **Servidor de Despliegue:** VPS Ubuntu Server

---

## Arquitectura del Proyecto

El proyecto sigue una arquitectura sólida en capas con soporte para DTOs (Data Transfer Objects), vistas con Thymeleaf y API REST:

```text
src/main/java/com/act3_t4/act3_t4/
├── controllers/
│   ├── DirectorRestController.java      # Endpoints REST JSON para Directores
│   ├── DirectorViewController.java      # Vistas Thymeleaf para Directores
│   ├── PeliculaRestController.java      # Endpoints REST JSON para Películas
│   └── PeliculaViewController.java      # Vistas Thymeleaf para Películas
├── dto/
│   ├── DirectorDTO.java                 # Objeto de transferencia de datos de Director
│   └── PeliculaDTO.java                 # Objeto de transferencia de datos de Película
├── models/
│   ├── Director.java                    # Entidad JPA (Padre)
│   └── Pelicula.java                    # Entidad JPA (Hijo / Relacionada)
├── repository/
│   ├── DirectorRepository.java          # JpaRepository para Director
│   └── PeliculaRepository.java          # JpaRepository para Pelicula
└── services/
    ├── DirectorService.java             # Lógica de negocio de Director
    └── PeliculaService.java             # Lógica de negocio de Pelicula

src/main/resources/
├── templates/                           # Vistas HTML Thymeleaf
│   ├── directores.html
│   ├── directoresform.html
│   ├── peliculas.html
│   └── peliculasform.html
└── application.properties               # Configuración de base de datos y puerto
```

---

## Entidades y Relación Mapeada

Se implementó el dominio de cine con las entidades **`Director`** y **`Pelicula`**:

1. **`Director` (Entidad Padre / Uno):**
   * Mapeado con `@OneToMany(mappedBy = "director", cascade = CascadeType.ALL)`.
   * Un director puede haber dirigido múltiples películas.

2. **`Pelicula` (Entidad Hijo / Muchos):**
   * Mapeado con `@ManyToOne` y `@JoinColumn(name = "director_id")`.
   * Cada película pertenece a un único director.
   * La clave foránea `director_id` se administra automáticamente en la tabla `pelicula` en MySQL.


## Endpoints de la API REST y Rutas Web

### 🌐 Vistas Web (Thymeleaf)
| Ruta | Descripción |
| :--- | :--- |
| `GET /directores` | Lista completa de directores registados. |
| `GET /directores/nuevo` | Formulario para crear o editar un director. |
| `GET /peliculas` | Lista completa de películas con el nombre de su director. |
| `GET /peliculas/nuevo` | Formulario para registrar una película y seleccionar su director. |

### 🚀 Endpoints REST (JSON / Postman / Bruno)
| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `GET` | `/api/peliculas` | Obtiene todas las películas (incluyendo objeto `Director`). |
| `GET` | `/api/peliculas/{id}` | Obtiene una película específica por su ID. |
| `POST` | `/api/peliculas` | Crea una película asignando el `director_id`. |
| `PUT` | `/api/peliculas/{id}` | Actualiza una película existente. |
| `DELETE` | `/api/peliculas/{id}` | Elimina una película por su ID. |
| `GET` | `/api/directores` | Obtiene el listado de todos los directores. |
| `POST` | `/api/directores` | Crea un nuevo director. |

---

## Evidencias de Funcionamiento

### 1. Tablas y Relación Foreign Key en MySQL
*Verificación de las tablas `director` y `pelicula` con la columna `director_id` como clave foránea.*

![Tabla y Llave Foránea](docs/screenshots/01-db-relation.png)

### 2. Operación CREATE (Crear Película con Director)
*Inserción de película asociada a un director existente.*

![Crear Película](docs/screenshots/02-crud-create.png)

### 3. Operación READ (Leer Películas mostrando el Director)
*Consulta GET donde la película retorna la información completa del director y no solo su ID.*

![Leer Películas](docs/screenshots/03-crud-read.png)

### 4. Operación UPDATE (Actualizar Película)
*Modificación de atributos de una película o cambio de director asignado.*

![Actualizar Película](docs/screenshots/04-crud-update.png)

### 5. Operación DELETE (Eliminar Película)
*Eliminación de una película de la base de datos mediante petición DELETE.*

![Eliminar Película](docs/screenshots/05-crud-delete.png)

---

