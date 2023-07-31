# cuidarApp
Criado para facilitar o cadastro de pacientes da ONG instituto Cuidar e substituir o sistema atual.

o sistema atual é regido por fichas em papel, o que torna o gerenciamento dos registros complexo e demorado.
A aplicação se mostra necessária diante da quantidade de tempo e trabalho que é despendida todos os meses.


De acordo com os 3 ambientes ```teste```, ```desenvolvimento``` e ```producao```

<h3>Ambiente de Producao</h3>

Rodando local:<br>
1. Necessário passar o comando como argumento na IDE
  ```
-Dspring.profiles.active=producao
```
3. caso necessário subir a aplicação pela IDE e usar o banco, crie o container postgres antes:<br>
```
 docker run -d -e POSTGRES_PASSWORD=159951 -e POSTGRES_USER=postgres  -p 5432:5432 -v /c/projsDesenvolvimentoBack/dataCuidarapp:/var/lib/postgresql/data --name postgres-A postgres
```
*será criada uma pasta para os dados do banco chamada "dataCuidarapp;C"*
<br>

temos acesso ao terminal postgres com o utilitário ```psql```
```
docker exec -it postgres-A psql -U postgres -W cuidarapp
```

Para listar os bancos usar ```\l``` *equivalente a SHOW DATABASES;*<br>
Para selecionar o schema para consultas ```SET search_path TO cuidarapp_schema;```<br>
Para listar as tabelas usar  ```SELECT * FROM tb_paciente;```  ou  ```SELECT * FROM cuidarapp_schema.tb_paciente;```<br>

*Esse ambiente foi pensado para replicar o Banco de produção usado no Deploy, por isso quando rodando
localmente, é necessário fazer um insert do Dump do Banco do Deploy*

*****************

<h4>Rodando em container Docker</h4>

Caso encontre erros ao executar Docker no windows 11 com wsl:
1. Criação de variável de ambiente no Windows: `DOCKER_HOST=tcp://127.0.0.1:2375`
2. Habilitando *Expose daemon on tcp://localhost:2375 without TLS* no Docker Desktop<br><br>


#Subindo containeres do projeto*<br>
```
PROFILE=producao docker-compose up --scale cuidarapp-api=1
```

<p>Arquivo Docker compose é composto por 3 imagens:</p>
<ul>
  <li>Imagem do Postgres</li>
  <li>Imagem da aplicação cuidarapp-api</li>
  <li>Imagem do Java openJdk 11</li>
</ul>

<p>Ao realizar modificações na aplicação, é necessário refazer o jar, existe uma comfiguração no pom.xml
que recria a imagem docker e faz upload automaticamente para o Docker hub</p>

```
mvn clean package -Pdocker
```

Para criar a imagem manualmente:

```
docker image build -t algafood-api .
```

Criando uma network

* ```network``` = criar uma rede
* ```--driver``` = indica qual driver usar
* ```bridge``` = tipo de driver (acesso para todos os containers locais)
```
docker network create —driver bridge cuidarapp-network
```

Para criar o container manualmente:
```
docker container run --rm -p 8080:8080 -e DB_HOST=cuidarapp-postgres --network cuidarapp-network cuidarapp-api
```

Para criar o container do Banco manualmente(ALTERAR PARA POSTGRES)<br>
Container MYSQL:>br>
```
docker container run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=suaSenha --network algafood-network --name algafood-mysql mysql:8.0
```
Container POSTGRES:<br>
```
docker container run -d -p 5432:5432 -e POSTGRES_PASSWORD=senha_desejada --network algafood-network --name algafood-postgres postgres:latest
```

Implantando dados no banco:<br>

Caso container > host

Fazendo dump do container postgres:<br>
```
docker exec -t pgdev pg_dump -U postgres -d cuidarapp > dump1.sql

```
*estando dentro do conitainer, utilizar a partir de psql...*

Executando o restore do dump na máquina local:<br>
```
psql -U postgres -d cuidarapp < dump1.sql

```

Caso host > container

Fazendo dump do banco postgres local:<br>
```
pg_dump -U postgres -d cuidarapp > dump.sql
```

Copiando o dump1.sql para dentro do container recém-criado:<br>
```
docker cp dump1.sql pgdev:/var/lib/postgresql/data 
```
*ou pgdev:/ raiz*

*******************************************************

Acessando postgres do railway pela cli<br>
*usando terminal linux do wsl2 no windows*

1.railway login --browserless
2.railway link (selecione o projeto)
3. railway connect Postgres
4.instalando psql
  1.sudo apt-get update
  2.sudo apt-get install postgresql-client

5.pg_dump -U <username> -h <host> -p <port> -W -F t <db_name> > <output_filename>

*************************************************



*IMPORTANTE
As variáveis de conexão entre Banco e aplicação foram criadas como ```variáveis de ambiente``` no windows(export) no linux(set) e no Railway(Deploy)<br>
São elas:
```
set DB_URL=jdbc:postgresql://localhost:5432/
set POSTGRES_USER=postgres
set POSTGRES_PASSWORD=159951
set POSTGRES_PORT=5432
set POSTGRES_DB=cuidarapp
```

a falta delas pode acarretar em erros de conexão:
![image](https://github.com/jonathanhenriques/cuidarAppBack/assets/65731881/813957e1-9669-4467-957a-5be58cc15015)


Arquivo ```wait-for-it.sh``` garante que os containeres subam na ordem adequada -> ```cria a rede``` -> ```postgres``` -> ```cuidarapp-api```</p>
Pssíveis erros desse arquivo:
erro " /usr/bin/env: ‘bash\r’: No such file or directory" 
*Solução 1*<br>
1.
usar no terminal: `$ dos2unix wait-for-it.sh`<br>
isso vai formatar o arquivo para sistemas linux (retirando \r usado em windows)
*Solução 2*
2.Mudar de CRLF PARA LF
![image](https://github.com/jonathanhenriques/cuidarAppBack/assets/65731881/46048a52-3388-4965-b431-1082b52330f8)

Após isso refazer a imagem e os containers e irá funcionar.

******************
