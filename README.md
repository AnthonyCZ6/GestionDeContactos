# GestionDeContactos#

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0-green)

## 📖 Descripción

Este proyecto es una API RESTful desarrollada con **Spring Boot** para la gestión eficiente de contactos que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar.

El objetivo principal es demostrar la implementación de buenas prácticas en arquitectura de software, uso de DTOs, manejo de excepciones.

## 🚀 Características Principales

* **Gestión de Contactos:** Crear,visualisar, eliminar contactos.
* **Búsqueda y Filtrado:** Buscar contactos por Id.
* **Validación de Datos:** Uso de *Spring Validation* para asegurar telefonos válidos y campos obligatorios.
* **Manejo de Errores:** Respuestas JSON para errores (404, 400, 500).

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 21
* **Framework:** Spring Boot 4.0
* **Gestión de Dependencias:** Maven

## 📂 Estructura del Proyecto

```text
src/main/java/com/example/demo
├── Controller/
├── DTO/
├── Model/
├── Exception/
└── Service/
