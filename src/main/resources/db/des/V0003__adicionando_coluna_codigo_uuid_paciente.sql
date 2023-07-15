ALTER TABLE tb_paciente add codigo VARCHAR(36) not null after id;
UPDATE tb_paciente set codigo = uuid();
alter table tb_paciente add constraint uk_pedido_codigo unique (codigo);