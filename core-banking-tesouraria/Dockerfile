FROM eclipse-temurin:17-jdk-alpine
WORKDIR /work/
# Copia apenas o uber-jar gerado
COPY target/core-banking-tesouraria-1.0.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]