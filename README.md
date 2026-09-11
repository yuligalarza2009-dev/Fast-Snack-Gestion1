# Fast-Snack-Gestion1
ABP
Integrantes: DANIELA TRIVIÑO-ODETTE QUIROZ-MILENA GONZALES-NORA CEDILLO-YULIANA GALARZA-ALLISON PARRALES
# FastSnack – Aplicación de gestión de datos

## 1. Descripción del proyecto

FastSnack es una aplicación de escritorio desarrollada en Java que permite gestionar información relacionada con el proceso de atención y registro de datos de un establecimiento de comida.

La aplicación cuenta con una interfaz gráfica desarrollada mediante JFrame y permite trabajar con información almacenada en una base de datos MySQL.

El sistema integra funcionalidades de registro, consulta, búsqueda, edición y eliminación de datos, además de validaciones para evitar el ingreso de información incorrecta o incompleta.

---

## 2. Contexto del problema

En un establecimiento de comida es necesario mantener organizada la información utilizada durante el proceso de gestión de los registros.

Cuando esta información se maneja de manera manual o sin un sistema centralizado, pueden presentarse dificultades para registrar nuevos datos, encontrar información específica, realizar modificaciones o eliminar registros correctamente.

Los principales usuarios del sistema son las personas encargadas de ingresar y administrar la información dentro de la aplicación.

A partir de esta necesidad se desarrolló FastSnack, una aplicación que permite gestionar los datos desde una interfaz gráfica y almacenarlos directamente en una base de datos MySQL.

---

## 3. Objetivo

### Objetivo general

Desarrollar una aplicación de escritorio que permita gestionar información mediante una interfaz gráfica conectada a una base de datos MySQL, aplicando programación orientada a eventos, validación de datos y operaciones CRUD.

### Objetivos específicos

- Diseñar una interfaz gráfica sencilla y organizada.
- Permitir el registro de nuevos datos.
- Facilitar la consulta y visualización de información.
- Implementar una búsqueda específica de registros.
- Permitir la modificación de información existente.
- Permitir la eliminación segura de registros.
- Implementar validaciones para garantizar la integridad de los datos.
- Establecer una conexión funcional entre Java y MySQL.

---

## 4. Análisis de requerimientos

La aplicación debe permitir realizar las siguientes acciones:

### Registro de información
El usuario podrá ingresar información mediante un formulario y almacenarla en la base de datos.

### Consulta y visualización
El sistema permitirá visualizar los registros almacenados en MySQL desde la interfaz gráfica.

### Búsqueda
El usuario podrá buscar registros específicos utilizando los datos disponibles en el sistema.

### Modificación
El usuario podrá seleccionar un registro existente, modificar su información y guardar los cambios.

### Eliminación
El usuario podrá eliminar registros seleccionados. Antes de realizar esta operación se solicitará una confirmación.

---

## 5. Funcionalidades principales

La aplicación cuenta con cinco funcionalidades principales:

1. *Visualización de datos*
2. *Búsqueda específica*
3. *Registro de datos*
4. *Edición de datos*
5. *Eliminación segura*
