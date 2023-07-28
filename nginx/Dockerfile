# comentado ate que volte a funcionar
 # criando uma imagem do nginx
 FROM nginx:1.23.1-alpine

 # comando para remover o arquivo de config padrao, pois foi criado um personalizado (nginx.config)
 RUN rm /etc/nginx/conf.d/default.conf

 # copiando o arquivo personalizado (nginx.config) no lugar do arquivo default da imagem
 COPY nginx.conf /etc/nginx/conf.d/default.conf
