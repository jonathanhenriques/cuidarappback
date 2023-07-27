create table tb_atendente (
    id bigint not null auto_increment,
    is_ativo boolean default true not null,
    nome varchar(255) not null,
    primary key (id)
 );

create table tb_exame (
    id bigint not null auto_increment,
    data_exame TIMESTAMP not null,
    nome_exame varchar(100) not null,
    observacao varchar(500),
    valor decimal(12,2) not null,
    atendente_id bigint,
    local_id bigint,
    medico_id bigint,
    paciente_id bigint,
    primary key (id)
 );

create table tb_local (
    id bigint not null auto_increment,
    nome_local varchar(255) not null,
    end_bairro varchar(50),
    end_cep varchar(11),
    end_cidade varchar(50),
    end_numero varchar(20),
    end_observacao varchar(100),
    end_rua varchar(75),
    end_tipo_residencia varchar(11),
    primary key (id)
 );

create table tb_medico (
    id bigint not null auto_increment,
    nome varchar(255) not null,
    is_ativo boolean default true not null,
    primary key (id)
 );

create table tb_paciente (
    id bigint not null auto_increment,
    nome varchar(100),
    rg varchar(9),
    estado_civil varchar(10),
    filhos integer,
    idade integer,
    indicacao varchar(100),
    is_ativo BIT,
    nome_responsavel_paciente varchar(100),
    observacao varchar(500),
    profissao varchar(30),
    is_aceite BIT,
    is_convenio BIT,
    data_cadastro TIMESTAMP,
    data_nasc TIMESTAMP,
    deficiencia varchar(50),
    deficiencia_familia varchar(255),
    is_deficiente BIT,
    cont_celular varchar(15),
    cont_facebook varchar(50),
    cont_instagram varchar(50),
    cont_email varchar(50),
    cont_telefone varchar(14),
    end_bairro varchar(50),
    end_cep varchar(11),
    end_cidade varchar(50),
    end_numero varchar(20),
    end_observacao varchar(100),
    end_rua varchar(75),
    end_tipo_residencia varchar(11),

    primary key (id)
);

create table tb_usuario (
    id bigint not null auto_increment,
    login varchar(255),
    senha varchar(255),
    primary key (id)
 );

-- create table tb_usuario (
-- 	id bigint not null auto_increment,
-- 	nome varchar(80) not null,
-- 	email varchar(255) not null,
-- 	senha varchar(255) not null,
-- 	data_cadastro datetime not null,
--
-- 	primary key (id)
-- );
--
 create table tb_usuario_grupo (
 	usuario_id bigint not null,
 	grupo_id bigint not null,

 	primary key (usuario_id, grupo_id)
 );

 create table tb_grupo (
 	id bigint not null auto_increment,
 	nome varchar(60) not null,

 	primary key (id)
 );

 create table tb_grupo_permissao (
 	grupo_id bigint not null,
 	permissao_id bigint not null,

 	primary key (grupo_id, permissao_id)
 );

 create table tb_permissao (
 	id bigint not null auto_increment,
 	descricao varchar(60) not null,
 	nome varchar(100) not null,

 	primary key (id)
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