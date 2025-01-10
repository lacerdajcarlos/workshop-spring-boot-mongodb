# Etapa 1: Construção do projeto Maven
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app

# Copia apenas o arquivo pom.xml e resolve as dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o restante dos arquivos do projeto
COPY src ./src

# Compila o projeto e gera o JAR
RUN mvn package -DskipTests

# Verifica se o JAR foi gerado corretamente
RUN ls -l /app/target

# Etapa 2: Imagem final para execução do aplicativo
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia o JAR gerado para a imagem final
COPY --from=build /app/target/workshopmongo-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta 8080
EXPOSE 8080

# Comando para executar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
