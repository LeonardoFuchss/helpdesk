# Help Desk API

A Help Desk API developed to manage support requests, users, profiles, and permissions in a centralized environment.

The project simulates a real-world service desk system where users can open support tickets, support agents can handle requests, and administrators can manage access and permissions.

This application was created as a portfolio project to demonstrate backend development skills using Java and Spring Boot.

---

# Main Features

## User Management

- User registration
- User authentication
- User profile update
- Password management
- User activation and deactivation

## Profile and Permission Management

- Profile creation and maintenance
- Permission assignment
- Access control based on roles and permissions

## Ticket Management

- Create support tickets
- Track ticket status
- Update ticket information
- Close tickets
- Ticket history

## Security

- Authentication with JWT
- Authorization based on permissions
- Protected endpoints

---

# Business Rules

- Every self-registered user receives a default profile.
- Access to system features is controlled through permissions.
- Permissions are grouped into profiles.
- Users inherit permissions from their assigned profile.
- Inactive users cannot access the system.

---

# Technologies

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Flyway
- Docker
- Swagger / OpenAPI
- Lombok

---

# Project Goals

This project aims to demonstrate:

- REST API development
- Software architecture principles
- Authentication and authorization
- Database versioning
- Containerized applications
- Clean and maintainable code

---

# Future Improvements

- SLA management
- Email notifications
- File attachments
- Dashboard and reporting
- Audit logs
- Advanced ticket workflows

---

# Author

Developed by Leonardo Fuchs as a backend portfolio project.
