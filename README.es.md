# Aplicación de Escritorio LNB

Aplicación de escritorio desarrollada en Java como proyecto académico, basada en la Liga Nacional de Básquet (LNB) de Argentina.

El sistema permite gestionar información y actividades sobre equipos, jugadores, eventos y usuarios, aplicando principios sólidos de programación orientada a objetos y una arquitectura en capas.

---

## Tipo de Aplicación

- Aplicación de escritorio
- Java SE
- Interfaz gráfica desarrollada con Swing mediante WindowBuilder

---

## Arquitectura y Diseño

- Programación Orientada a Objetos (POO)
- Arquitectura en capas:
  - BLL (Lógica de Negocio)
  - DLL / DAO (Acceso a Datos)
  - GUI (Interfaz Gráfica)
- Patrón DAO para el acceso a base de datos
- Patrón Singleton utilizado para la gestión de la conexión a la base de datos
- Separación clara de responsabilidades
- Uso de herencia y encapsulamiento

---

## Base de Datos

- Base de datos MySQL
- Administrada mediante phpMyAdmin
- Esquema relacional con claves foráneas
- Operaciones CRUD completas para múltiples entidades

---

## Funcionalidades Principales

- Registro e inicio de sesión de usuarios
- Acceso por roles (aficionados / administradores)
- Gestión de:
  - Equipos
  - Jugadores
  - Entrenadores
  - Artículos
  - Eventos
  - Usuarios
- Operaciones CRUD completas
- Paneles administrativos de escritorio
- Juego integrado:
  - Ahorcado, implementado como parte del sistema

---

## Funcionalidades Adicionales

- Generación de perfil de jugador a partir de datos del usuario
- Sistema de puntos y progresión para aficionados
- Estructura modular que permite ampliar el sistema fácilmente

---

## Estado del Proyecto

- Proyecto finalizado y funcional
- Base de datos y flujo de aplicación completamente operativos
- Posibles mejoras futuras:
  - Cargar más datos reales en la base de datos
  - Agregar nuevos juegos o funcionalidades

---

## Tecnologías Utilizadas

- Java SE
- Swing (WindowBuilder)
- MySQL
- phpMyAdmin
- Eclipse IDE

---

## Idioma

- Versión en español (este archivo)
- English version available here: [README.md](README.md)
