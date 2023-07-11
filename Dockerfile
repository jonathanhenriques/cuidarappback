# a imagem base para criar a imagem do projeto (semelhante ao parent do pom)
FROM openjdk:11-jre
# diretorio base, caso nao exista, ele e criado
WORKDIR /app

# define uma variavel que pode ser passada em tempo de build (JAR_FILE usado no pom)
ARG JAR_FILE

# caminho de origem do jar da aplicacao / o destino para salvar a imagem
COPY target/*.jar /app/api.jar
# COPY target/${JAR_FILE} /app/api.jar

# porta para usar o container
EXPOSE 8082

# comando para rodar esse container
CMD ["java", "-jar", "api.jar"]



