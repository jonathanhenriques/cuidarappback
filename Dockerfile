# a imagem base para criar a imagem do projeto (semelhante ao parent do pom)
FROM openjdk:11-jre
# diretorio base, caso nao exista, ele e criado
WORKDIR /app

# define uma variavel que pode ser passada em tempo de build (JAR_FILE usado no pom)
ARG JAR_FILE
# ARG {DB_USER_PASSWORD}
# ARG DB_USER_USERNAME
# ARG AWS_ACCESS_KEY
# ARG AWS_SECRET_KEY

# caminho de origem do jar da aplicacao / o destino para salvar a imagem
# arquivos a serem copiados para dentro da imagem
# COPY target/*.jar /app/api.jar
# COPY target/${JAR_FILE} /app/api.jar
COPY ./${JAR_FILE} /api.jar
COPY wait-for-it.sh /wait-for-it.sh

# executar wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# porta para usar o container
EXPOSE 8082

# comando para rodar esse container
CMD ["java", "-jar", "api.jar"]

# # variaveis de ambiente para ambiente de teste
# ENV DB_USER_PASSWORD=${DB_USER_PASSWORD}
# ENV DB_USER_USERNAME=${DB_USER_USERNAME}
# ENV AWS_ACCESS_KEY=${AWS_ACCESS_KEY}
# ENV AWS_SECRET_KEY=${AWS_SECRET_KEY}



