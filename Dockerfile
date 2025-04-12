# Etapa de construcción (builder)
FROM eclipse-temurin:23-jdk AS builder
WORKDIR /app

COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:23-jre
WORKDIR /app

# Copiamos el JAR construido desde la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Railway suele exponer el puerto automáticamente, pero es buena práctica indicarlo
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
