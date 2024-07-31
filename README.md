# Gestión de Prácticas - Backend

Este proyecto es una aplicación backend desarrollada con Spring Boot y JPA para gestionar las actividades complementarias (prácticas o visitas de observación) de los estudiantes de la Universidad Pedagógica y Tecnológica de Colombia - UPTC.

## Requisitos Previos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

- JDK 11 o superior

## Configuración del Proyecto

1. Clona el repositorio o descargalo

Endpoints
Prácticas
GET /api/practicas/{idDocente}: Obtiene las prácticas de un docente por su ID.
POST /api/practicas: Crea una nueva práctica.
PUT /api/practicas/{id}: Actualiza una práctica existente.
DELETE /api/practicas/{id}: Elimina una práctica por su ID.
Docentes
GET /api/docentes/{id}: Obtiene un docente por su ID.
POST /api/docentes: Crea un nuevo docente.
PUT /api/docentes/{id}: Actualiza un docente existente.
DELETE /api/docentes/{id}: Elimina un docente por su ID.
Estudiantes
GET /api/estudiantes/{id}: Obtiene un estudiante por su ID.
POST /api/estudiantes: Crea un nuevo estudiante.
PUT /api/estudiantes/{id}: Actualiza un estudiante existente.
DELETE /api/estudiantes/{id}: Elimina un estudiante por su ID.
Empresas
GET /api/empresas/{id}: Obtiene una empresa por su ID.
POST /api/empresas: Crea una nueva empresa.
PUT /api/empresas/{id}: Actualiza una empresa existente.
DELETE /api/empresas/{id}: Elimina una empresa por su ID.
