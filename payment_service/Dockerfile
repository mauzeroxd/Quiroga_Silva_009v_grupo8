# Paso 1: Usar una imagen de Java 21 (basada en tu pom.xml)
FROM eclipse-temurin:21-jdk-jammy

# Paso 2: Directorio de trabajo dentro del contenedor
WORKDIR /app

# Paso 3: Copiar el archivo JAR generado por Maven
# Asegúrate de haber ejecutado 'mvn clean package' antes
COPY target/*.jar app.jar

# Paso 4: Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]