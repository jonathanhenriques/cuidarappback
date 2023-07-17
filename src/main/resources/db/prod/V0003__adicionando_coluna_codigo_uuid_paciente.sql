ALTER TABLE tb_paciente ADD COLUMN codigo VARCHAR(36) NOT NULL DEFAULT uuid_generate_v4();
ALTER TABLE tb_paciente ADD CONSTRAINT uk_paciente_codigo UNIQUE (codigo);

