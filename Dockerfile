# Use uma imagem base do OpenJDK compatível com sua versão do Java
FROM eclipse-temurin:17-jdk-alpine

# Configurar o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o JAR gerado para o contêiner
COPY target/WorkshopmongoApplication.java app.jar

# Expor a porta usada pelo aplicativo
EXPOSE 8080

# Comando para rodar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
