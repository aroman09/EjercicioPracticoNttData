# Utilizar una imagen base de OpenJDK con Java 17
FROM openjdk:17-jdk-slim
WORKDIR /app
# Añadir el jar de la aplicación al contenedor
COPY target/microservicio-persona-cliente-0.0.1-SNAPSHOT.jar /app/microservicio-persona-cliente-0.0.1-SNAPSHOT.jar

# Exponer el puerto que utiliza la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/microservicio-persona-cliente-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]
