create table tb_atendente 
  (
    id bigint         NOT NULL AUTO_INCREMENT,
    is_ativo boolean  DEFAULT TRUE NOT NULL,
    nome              VARCHAR(255) NOT NULL,
    
    PRIMARY KEY (id)
 );

create table tb_exame 
  (
    id bigint         NOT NULL AUTO_INCREMENT,
    data_exame        TIMESTAMP NOT NULL,
    nome_exame        VARCHAR(100) NOT NULL,
    observacao        VARCHAR(500),
    valor             DECIMAL(12,2) NOT NULL,
    atendente_id bigint,
    local_id bigint,
    medico_id bigint,
    paciente_id bigint,
    
    PRIMARY KEY (id)
 );

create table tb_local (
    id bigint         NOT NULL AUTO_INCREMENT,
    nome_local        VARCHAR(255) NOT NULL,
    end_bairro        VARCHAR(50),
    end_cep           VARCHAR(11),
    end_cidade        VARCHAR(50),
    end_numero        VARCHAR(20),
    end_observacao    VARCHAR(100),
    end_rua           VARCHAR(75),
    end_tipo_residencia VARCHAR(11),
    
    PRIMARY KEY (id)
 );

create table tb_medico (
    id bigint         NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    is_ativo boolean  DEFAULT TRUE NOT NULL,
    
    PRIMARY KEY (id)
 );

create table tb_paciente (
    id bigint         NOT NULL AUTO_INCREMENT,
    nome              VARCHAR(100),
    rg                VARCHAR(9),
    estado_civil      VARCHAR(10),
    filhos            INTEGER,
    idade             INTEGER,
    indicacao         VARCHAR(100),
    is_ativo          BIT,
    nome_responsavel_paciente VARCHAR(100),
    observacao        VARCHAR(500),
    profissao         VARCHAR(30),
    is_aceite         BIT,
    is_convenio       BIT,
    data_cadastro     TIMESTAMP,
    data_nasc         TIMESTAMP,
    deficiencia       VARCHAR(50),
    deficiencia_familia VARCHAR(255),
    is_deficiente     BIT,
    cont_celular      VARCHAR(15),
    cont_facebook     VARCHAR(50),
    cont_instagram    VARCHAR(50),
    cont_email        VARCHAR(50),
    cont_telefone     VARCHAR(14),
    end_bairro        VARCHAR(50),
    end_cep           VARCHAR(11),
    end_cidade        VARCHAR(50),
    end_numero        VARCHAR(20),
    end_observacao    VARCHAR(100),
    end_rua           VARCHAR(75),
    end_tipo_residencia VARCHAR(11),

    PRIMARY KEY (id)
);

create table tb_usuario (
    id bigint         NOT NULL AUTO_INCREMENT,
    login             VARCHAR(255),
    senha             VARCHAR(255),
    
    PRIMARY KEY (id)
 );

-- create table tb_usuario 
-- (
-- 	id bigint           NOT NULL AUTO_INCREMENT,
-- 	nome varchar(80)    NOT NULL,
-- 	email varchar(255)  NOT NULL,
-- 	senha varchar(255)  NOT NULL,
-- 	data_cadastro       datetime NOT NULL,
--
-- 	PRIMARY KEY (id)
-- );
--
 create table tb_usuario_grupo (
 	usuario_id bigint NOT NULL,
 	grupo_id bigint   NOT NULL,

 	PRIMARY KEY (usuario_id, grupo_id)
 );

 create table tb_grupo (
 	id bigint         NOT NULL AUTO_INCREMENT,
 	nome varchar(60)  NOT NULL,

 	PRIMARY KEY (id)
 );

 create table tb_grupo_permissao (
 	grupo_id bigint   NOT NULL,
 	permissao_id bigint NOT NULL,

 	PRIMARY KEY (grupo_id, permissao_id)
 );

 create table tb_permissao (
 	id bigint         NOT NULL AUTO_INCREMENT,
 	descricao         VARCHAR(60) NOT NULL,
 	nome              VARCHAR(100) NOT NULL,

 	PRIMARY KEY (id)
 );



alter table tb_exame add constraint fk_exame_atendente
foreign key (atendente_id) references tb_atendente (id);

alter table tb_exame add constraint fk_exame_local
foreign key (local_id) references tb_local (id);

alter table tb_exame add constraint fk_exame_medico
foreign key (medico_id) references tb_medico (id);

alter table tb_exame add constraint fk_exame_paciente
foreign key (paciente_id) references tb_paciente (id);


alter table tb_grupo_permissao add constraint fk_grupo_permissao_permissao
foreign key (permissao_id) references tb_permissao (id);

alter table tb_grupo_permissao add constraint fk_grupo_permissao_grupo
foreign key (grupo_id) references tb_grupo (id);

alter table tb_usuario_grupo add constraint fk_usuario_grupo_grupo
foreign key (grupo_id) references tb_grupo (id);

alter table tb_usuario_grupo add constraint fk_usuario_grupo_usuario
foreign key (usuario_id) references tb_usuario (id);