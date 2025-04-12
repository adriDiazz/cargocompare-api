FROM maven:3.9-eclipse-temurin-21-alpine

WORKDIR /app

COPY . ./

RUN mvn -B -DskipTests clean install

CMD ["sh", "-c", "java -jar target/*.jar"]
