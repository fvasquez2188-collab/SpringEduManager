# 📚 SpringEduManager

Sistema web desarrollado con **Spring Boot** para la gestión de **cursos, estudiantes y evaluaciones**, con autenticación y control de acceso por roles.

---

## 🚀 Descripción

SpringEduManager es una aplicación web que permite:

* Gestionar cursos 📘
* Registrar estudiantes 👨‍🎓
* Crear y administrar evaluaciones 📝
* Controlar accesos mediante roles (ADMIN / USER) 🔐

Incluye interfaz web con **Thymeleaf** y una **API REST** para integración externa.

---

## 🛠️ Tecnologías utilizadas

* ☕ **Java 17**
* 🌱 **Spring Boot 3**
* 🔐 **Spring Security**
* 🗄️ **Spring Data JPA**
* 🧩 **Hibernate**
* 💾 **H2 Database (en memoria)**
* 🎨 **Thymeleaf**
* 🌐 **REST API**
* 📦 **Maven**

---

## ⚙️ Configuración y ejecución

### 🔽 1. Clonar el proyecto

```bash
git clone https://github.com/tu-repo/SpringEduManager.git
cd SpringEduManager
```

### ▶️ 2. Ejecutar la aplicación

Desde Eclipse / IntelliJ o terminal:

```bash
./mvnw spring-boot:run
```

---

## 🔐 Acceso al sistema

### 👤 Usuarios disponibles

| Usuario | Contraseña | Rol   |
| ------- | ---------- | ----- |
| admin   | 1234       | ADMIN |
| user    | 1234       | USER  |

---

## 🌍 Uso de la aplicación

### 🖥️ Interfaz Web

Accede desde:

```
http://localhost:8080/login
```

### 🔹 Funcionalidades principales

#### 📘 Cursos

* Crear curso
* Editar curso
* Eliminar curso
* Listar cursos

#### 👨‍🎓 Estudiantes

* Registrar estudiante
* Editar estudiante
* Eliminar estudiante

#### 📝 Evaluaciones

* Crear evaluaciones
* Asignar a estudiantes/cursos
* Eliminar evaluaciones

---

## 🔐 Seguridad

La aplicación implementa **Spring Security** con:

* Login personalizado
* Control de acceso por roles
* Protección de rutas:

| Ruta               | Acceso      |
| ------------------ | ----------- |
| `/login`           | Público     |
| `/cursos/**`       | ADMIN       |
| `/evaluaciones/**` | ADMIN       |
| `/api/**`          | ADMIN       |
| resto              | autenticado |

---

## 🌐 API REST

### 📍 Endpoints principales

#### 👨‍🎓 Estudiantes

```
GET    /api/estudiantes
GET    /api/estudiantes/{id}
POST   /api/estudiantes
DELETE /api/estudiantes/{id}
```

#### 📝 Evaluaciones

```
GET    /api/evaluaciones
POST   /api/evaluaciones
DELETE /api/evaluaciones/{id}
```

---

## 🗄️ Base de datos

* Tipo: **H2 en memoria**
* Consola disponible en:

```
http://localhost:8080/h2-console
```

---

## 📁 Estructura del proyecto

```
src/main/java/com/example/SpringEduManager/
│
├── config          → Configuración de seguridad
├── controller      → Controladores MVC
├── rest            → API REST
├── service         → Lógica de negocio
├── repository      → Acceso a datos (JPA)
├── model           → Entidades
```

---

## ✅ Funcionalidades implementadas

✔ CRUD completo
✔ Seguridad con roles
✔ API REST
✔ Integración con base de datos
✔ Interfaz web con Thymeleaf

---

## 🎯 Mejoras futuras

* Validaciones con `@Valid`
* Manejo global de excepciones
* Base de datos persistente (MySQL/PostgreSQL)
* Dockerización

---

## 👨‍💻 Autor

Felipe Antonio Vasquez Delgado
Proyecto desarrollado como parte de evaluación académica.

---

## 🏁 Estado del proyecto

```text
✔ Completo
✔ Funcional
✔ Listo para evaluación
```

---
