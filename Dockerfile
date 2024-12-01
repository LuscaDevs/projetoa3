# Etapa 1: Construção do JAR
FROM maven:3.9.4-eclipse-temurin-17 as builder

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo pom.xml e as dependências para o cache do Docker
COPY pom.xml .
COPY src ./src

# Compila o projeto e cria o JAR
RUN mvn clean package -DskipTests

# Etapa 2: Construção da imagem de produção
FROM eclipse-temurin:17-jdk-jammy

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR da etapa anterior para a imagem final
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

# Comando para executar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
