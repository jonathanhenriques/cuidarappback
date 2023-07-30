ALTER TABLE tb_paciente ADD codigo VARCHAR(36) NOT NULL after id;
UPDATE tb_paciente SET codigo = uuid();
ALTER TABLE tb_paciente ADD CONSTRAINT uk_pedido_codigo UNIQUE (codigo);