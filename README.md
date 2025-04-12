# CargoCompare – Configuración de Entornos

Este proyecto utiliza Spring Boot y se despliega en Railway. Para facilitar el manejo de configuraciones, se utilizan diferentes archivos por entorno (`dev`, `test`, `prod`) y variables de entorno definidas desde el sistema o desde Railway.

---

## 🚀 Entornos disponibles

| Entorno | Propósito             | Archivo de configuración       |
|---------|------------------------|--------------------------------|
| dev     | Desarrollo local       | `application-dev.yml`          |
| test    | Testing / Railway Test | `application-test.yml`         |
| prod    | Producción en Railway  | `application-prod.yml`         |

---

## 🔐 Variables de entorno necesarias

Define las siguientes variables de entorno según el entorno activo (`SPRING_PROFILES_ACTIVE`):

### 🌱 Desarrollo (`dev`)
Estas variables se definen en tu entorno local (por ejemplo, `.env`, terminal o IDE):

- `SPRING_PROFILES_ACTIVE=dev`
- `mysql-url-dev`
- `mysql-username-dev`
- `mysql-password-dev`
- `mail-username-dev`
- `mail-appPassword-dev`
- `jwt-secret-dev`

### 🧪 Testing (`test` en Railway)
Se definen en la sección "Variables" del proyecto Railway:

- `SPRING_PROFILES_ACTIVE=test`
- `mysql-url-test`
- `mysql-username-test`
- `mysql-password-test`
- `mail-username-test`
- `mail-appPassword-test`
- `jwt-secret-test`

### 🚢 Producción (`prod` en Railway)
También desde Railway, pero separadas del entorno de test:

- `SPRING_PROFILES_ACTIVE=prod`
- `mysql-url-prod`
- `mysql-username-prod`
- `mysql-password-prod`
- `mail-username-prod`
- `mail-appPassword-prod`
- `jwt-secret-prod`

---

## ⚙️ Ejecución local

```bash
# Ejecutar con perfil de desarrollo
SPRING_PROFILES_ACTIVE=dev ./mvnw spring-boot:run
