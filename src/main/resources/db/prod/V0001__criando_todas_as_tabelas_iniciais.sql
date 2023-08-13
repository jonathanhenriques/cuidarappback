
-- Define o schema padrão para cuidarapp_schema
SET SCHEMA 'cuidarapp_schema';

create table tb_atendente (
    id                BIGSERIAL PRIMARY KEY,
    is_ativo          BOOLEAN DEFAULT TRUE NOT NULL,
    nome              VARCHAR(255) NOT NULL
);


create table tb_local (
    id BIGSERIAL      PRIMARY KEY,
    nome_local        VARCHAR(255) NOT NULL,
    ativo             BOOLEAN DEFAULT TRUE NOT NULL,
    end_bairro        VARCHAR(50),
    end_cep           VARCHAR(11),
    end_cidade        VARCHAR(50),
    end_numero        VARCHAR(20),
    end_observacao    VARCHAR(100),
    end_rua           VARCHAR(75),
    end_tipo_residencia VARCHAR(11)
);

create table tb_medico (
    id                BIGSERIAL PRIMARY KEY,
    nome              VARCHAR(255) NOT NULL,
    is_ativo          BOOLEAN DEFAULT TRUE NOT NULL
);

create table tb_paciente (
    id BIGSERIAL      PRIMARY KEY,
    nome              VARCHAR(100),
    rg                VARCHAR(9),
    estado_civil      VARCHAR(10),
    filhos            INTEGER,
    idade             INTEGER,
    indicacao         VARCHAR(100),
    is_ativo BOOLEAN,
    nome_responsavel_paciente VARCHAR(100),
    observacao        VARCHAR(500),
    profissao         VARCHAR(30),
    is_aceite         BOOLEAN,
    is_convenio       BOOLEAN,
    data_cadastro     TIMESTAMP,
    data_nasc         TIMESTAMP,
    deficiencia       VARCHAR(50),
    deficiencia_familia VARCHAR(255),
    is_deficiente     BOOLEAN,
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
    end_tipo_residencia VARCHAR(11)
);

create table tb_exame (
    id                BIGSERIAL PRIMARY KEY,
    data_exame        TIMESTAMP NOT NULL,
    nome_exame        VARCHAR(100) NOT NULL,
    observacao        VARCHAR(500),
    valor             NUMERIC(12, 2) NOT NULL,
    atendente_id      BIGINT,
    local_id          BIGINT,
    medico_id         BIGINT,
    paciente_id       BIGINT,
    
    FOREIGN KEY (atendente_id) REFERENCES tb_atendente (id),
    FOREIGN KEY (local_id) REFERENCES tb_local (id),
    FOREIGN KEY (medico_id) REFERENCES tb_medico (id),
    FOREIGN KEY (paciente_id) REFERENCES tb_paciente (id)
);

create table tb_usuario (
    id BIGSERIAL      PRIMARY KEY,
    login             VARCHAR(255),
    senha             VARCHAR(255)
);


create table tb_grupo (
    id BIGSERIAL      PRIMARY KEY,
    nome              VARCHAR(60) NOT NULL
);

create table tb_usuario_grupo (
    usuario_id        BIGINT NOT NULL,
    grupo_id          BIGINT NOT NULL,
    
    PRIMARY KEY (usuario_id, grupo_id),
    FOREIGN KEY (usuario_id) REFERENCES tb_usuario (id),
    FOREIGN KEY (grupo_id) REFERENCES tb_grupo (id)
);

create table tb_permissao (
    id                BIGSERIAL PRIMARY KEY,
    descricao         VARCHAR(60) NOT NULL,
    nome              VARCHAR(100) NOT NULL
);

create table tb_grupo_permissao (
    grupo_id          BIGINT NOT NULL,
    permissao_id      BIGINT NOT NULL,
    
    PRIMARY KEY (grupo_id, permissao_id),
    FOREIGN KEY (grupo_id) REFERENCES tb_grupo (id),
    FOREIGN KEY (permissao_id) REFERENCES tb_permissao (id)
);





ALTER TABLE tb_exame ADD CONSTRAINT fk_exame_atendente
FOREIGN KEY (atendente_id) REFERENCES tb_atendente (id);

ALTER TABLE tb_exame ADD CONSTRAINT fk_exame_local
FOREIGN KEY (local_id) REFERENCES tb_local (id);

ALTER TABLE tb_exame ADD CONSTRAINT fk_exame_medico
FOREIGN KEY (medico_id) REFERENCES tb_medico (id);

ALTER TABLE tb_exame ADD CONSTRAINT fk_exame_paciente
FOREIGN KEY (paciente_id) REFERENCES tb_paciente (id);


ALTER TABLE tb_grupo_permissao ADD CONSTRAINT fk_grupo_permissao_permissao
FOREIGN KEY (permissao_id) REFERENCES tb_permissao (id);

ALTER TABLE tb_grupo_permissao ADD CONSTRAINT fk_grupo_permissao_grupo
FOREIGN KEY (grupo_id) REFERENCES tb_grupo (id);

ALTER TABLE tb_usuario_grupo ADD CONSTRAINT fk_usuario_grupo_grupo
FOREIGN KEY (grupo_id) REFERENCES tb_grupo (id);

ALTER TABLE tb_usuario_grupo ADD CONSTRAINT fk_usuario_grupo_usuario
FOREIGN KEY (usuario_id) REFERENCES tb_usuario (id);