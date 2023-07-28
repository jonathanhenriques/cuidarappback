# cuidarApp
Criado para facilitar o cadastro de pacientes da ONG instituto Cuidar e substituir o sistema atual.

o sistema atual é regido por fichas em papel, o que torna o gerenciamento dos registros complexo e demorado.
A aplicação se mostra necessária diante da quantidade de tempo e trabalho que é despendida todos os meses.


De acordo com os 3 ambientes ```teste```, ```desenvolvimento``` e ```producao```

<h3>Ambiente de Producao</h3>

Rodando local é necessário passar o comando 
  ```-Dspring.profiles.active=producao```
como argumento nas configurações de execução (usando Intellij).

<br>

<p>Esse ambiente foi pensado para replicar o Banco de produção usado no Deploy, por isso quando rodando
localmente, é necessário fazer um insert do Dump do Banco do Deploy</p>

<h4>Rodando em container Docker</h4>

<p>Caso encontre erros ao executar Docker no windows 11 com wsl: </p>
<ol>
  <li>criacao variável de ambiente no windows DOCKER_HOST=tcp://127.0.0.1:2375</li>
  <li>habilitando *Expose daemon on tcp://localhost:2375 without TLS no Docker Desktop</li>
</ol>

#Subindo containeres do projeto
```PROFILE=producao docker-compose up --scale cuidarapp-api=1```

<p>Arquivo Docker compose é composto por 3 imagens:</p>
<ul>
  <li>Imagem do Postgres</li>
  <li>Imagem da aplicação cuidarapp-api</li>
  <li>Imagem do Java openJdk 11</li>
</ul>

<p>Ao realizar modificações na aplicação, é necessário refazer o jar, existe uma comfiguração no pom.xml
que recria a imagem docker e faz upload automaticamente para o Docker hub</p>

```mvn clean package -Pdocker```

Para criar a imagem manualmente:

```docker image build -t algafood-api .```

Criando uma network

* ```network``` = criar uma rede
* ```--driver``` = indica qual driver usar
* ```bridge``` = tipo de driver (acesso para todos os containers locais)
```docker network create —driver bridge cuidarapp-network```

Para criar o container manualmente:
```docker container run --rm -p 8080:8080 -e DB_HOST=cuidarapp-postgres --network cuidarapp-network cuidarapp-api```

Para criar o container do Banco manualmente(ALTERAR PARA POSTGRES)
Container MYSQL: ```docker container run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=159951 --network algafood-network --name algafood-mysql mysql:8.0```
Container POSTGRES: ```docker container run -d -p 5432:5432 -e POSTGRES_PASSWORD=senha_desejada --network algafood-network --name algafood-postgres postgres:latest```

*IMPORTANTE
As variáveis de conexão entre Banco e aplicação foram criadas como ```variáveis de ambiente``` no windows e no Railway(Deploy)<br>
a falta delas pode acarretar em erros de conexão

Arquivo ```wait-for-it.sh``` garante que os containeres subam na ordem adequada -> ```cria a rede``` -> ```postgres``` -> ```cuidarapp-api```</p>


