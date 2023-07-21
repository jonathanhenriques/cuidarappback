
-- Define o schema padrão para cuidarapp_schema
SET SCHEMA 'cuidarapp_schema';

create table tb_atendente (
    id bigserial primary key,
    is_ativo boolean default true not null,
    nome varchar(255) not null
);


create table tb_local (
    id bigserial primary key,
    nome_local varchar(255) not null,
    end_bairro varchar(50),
    end_cep varchar(11),
    end_cidade varchar(50),
    end_numero varchar(20),
    end_observacao varchar(100),
    end_rua varchar(75),
    end_tipo_residencia varchar(11)
);

create table tb_medico (
    id bigserial primary key,
    nome varchar(255) not null,
    is_ativo boolean default true not null
);

create table tb_paciente (
    id bigserial primary key,
    nome varchar(100),
    rg varchar(9),
    estado_civil varchar(10),
    filhos integer,
    idade integer,
    indicacao varchar(100),
    is_ativo boolean,
    nome_responsavel_paciente varchar(100),
    observacao varchar(500),
    profissao varchar(30),
    is_aceite boolean,
    is_convenio boolean,
    data_cadastro timestamp,
    data_nasc timestamp,
    deficiencia varchar(50),
    deficiencia_familia varchar(255),
    is_deficiente boolean,
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
    end_tipo_residencia varchar(11)
);

create table tb_exame (
    id bigserial primary key,
    data_exame timestamp not null,
    nome_exame varchar(100) not null,
    observacao varchar(500),
    valor numeric(12, 2) not null,
    atendente_id bigint,
    local_id bigint,
    medico_id bigint,
    paciente_id bigint,
    foreign key (atendente_id) references tb_atendente (id),
    foreign key (local_id) references tb_local (id),
    foreign key (medico_id) references tb_medico (id),
    foreign key (paciente_id) references tb_paciente (id)
);

create table tb_usuario (
    id bigserial primary key,
    login varchar(255),
    senha varchar(255)
);


create table tb_grupo (
    id bigserial primary key,
    nome varchar(60) not null
);

create table tb_usuario_grupo (
    usuario_id bigint not null,
    grupo_id bigint not null,
    primary key (usuario_id, grupo_id),
    foreign key (usuario_id) references tb_usuario (id),
    foreign key (grupo_id) references tb_grupo (id)
);

create table tb_permissao (
    id bigserial primary key,
    descricao varchar(60) not null,
    nome varchar(100) not null
);

create table tb_grupo_permissao (
    grupo_id bigint not null,
    permissao_id bigint not null,
    primary key (grupo_id, permissao_id),
    foreign key (grupo_id) references tb_grupo (id),
    foreign key (permissao_id) references tb_permissao (id)
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
