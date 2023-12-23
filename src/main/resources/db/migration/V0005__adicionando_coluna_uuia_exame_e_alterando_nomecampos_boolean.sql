CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
ALTER TABLE tb_exame ADD COLUMN codigo VARCHAR(36) NOT NULL DEFAULT uuid_generate_v4();
ALTER TABLE tb_exame ADD CONSTRAINT uk_exame_codigo UNIQUE (codigo);

ALTER TABLE tb_exame RENAME COLUMN "situaçao" TO "is_ativo";

--ALTER TABLE tb_local ADD COLUMN is_Ativo BOOLEAN NOT NULL DEFAULT true;

--ALTER TABLE tb_paciente RENAME COLUMN aceite TO is_aceite;
ALTER TABLE tb_paciente RENAME COLUMN convenio TO has_convenio;
--ALTER TABLE tb_paciente RENAME COLUMN deficiente TO is_deficiente;
ALTER TABLE tb_paciente RENAME COLUMN filhos TO qtd_filhos;