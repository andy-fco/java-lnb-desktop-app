# LNB Desktop Application

Java desktop application developed as an academic project, based on the Argentine National Basketball League (Liga Nacional de Básquet – LNB).

The system is designed to provide structured access to information and activities regarding teams, players, events, and users, while applying solid object-oriented principles and a layered architecture.

---

## Application Type

- Desktop application
- Java SE
- Graphical User Interface built with Swing using WindowBuilder

---

## Architecture and Design

- Object-Oriented Programming (OOP)
- Layered architecture:
  - BLL (Business Logic Layer)
  - DLL / DAO (Data Access Layer)
  - GUI (Presentation Layer)
- DAO pattern for database access
- Singleton pattern used for database connection management
- Clear separation of responsibilities between layers
- Use of inheritance and encapsulation

---

## Database

- MySQL database
- Managed via phpMyAdmin
- Relational schema with foreign keys
- Fully functional CRUD operations for multiple entities

---

## Main Features

- User authentication and registration
- Role-based access (fans / administrators)
- Management of:
  - Teams
  - Players
  - Coaches
  - Articles
  - Events
  - Users
- Complete CRUD operations
- Desktop-based administrative panels
- Integrated mini-game:
  - Hangman game (Ahorcado), implemented as part of the system

---

## Additional Features

- Player profile generation based on user data
- Points and progression system for fans
- Modular structure allowing easy expansion

---

## Project Status

- Functionally complete
- Fully working database and application flow
- Possible future improvements:
  - Populate the database with more real-world data
  - Add additional mini-games or features

---

## Technologies Used

- Java SE
- Swing (WindowBuilder)
- MySQL
- phpMyAdmin
- Eclipse IDE

---

## Language

- English version (this file)
- Spanish version available here: [README.es.md](README.es.md)
