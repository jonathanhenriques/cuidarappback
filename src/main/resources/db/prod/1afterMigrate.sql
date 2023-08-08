
-- Define o schema padrão para cuidarapp_schema
SET SCHEMA 'cuidarapp_schema';

--desativa os gatilhos
ALTER TABLE tb_atendente DISABLE TRIGGER ALL;
ALTER TABLE tb_exame DISABLE TRIGGER ALL;
ALTER TABLE tb_local DISABLE TRIGGER ALL;
ALTER TABLE tb_medico DISABLE TRIGGER ALL;
ALTER TABLE tb_paciente DISABLE TRIGGER ALL;
ALTER TABLE tb_usuario DISABLE TRIGGER ALL;
ALTER TABLE tb_usuario_grupo DISABLE TRIGGER ALL;
ALTER TABLE tb_permissao DISABLE TRIGGER ALL;
ALTER TABLE tb_grupo DISABLE TRIGGER ALL;
ALTER TABLE tb_grupo_permissao DISABLE TRIGGER ALL;


 DELETE FROM tb_atendente;
 DELETE FROM tb_exame;
 DELETE FROM tb_local;
 DELETE FROM tb_medico;
 DELETE FROM tb_paciente;
 DELETE FROM tb_usuario;
 DELETE FROM tb_usuario_grupo;
 DELETE FROM tb_permissao;
 DELETE FROM tb_grupo;
 DELETE FROM tb_grupo_permissao;


--reseta a sequencia(id) para 1
ALTER SEQUENCE tb_atendente_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_exame_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_local_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_medico_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_paciente_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_usuario_id_seq RESTART WITH 1;
--ALTER SEQUENCE tb_usuario_grupo_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_permissao_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_grupo_id_seq RESTART WITH 1;
--ALTER SEQUENCE tb_grupo_permissao_id_seq RESTART WITH 1;



insert into tb_medico (id, nome, is_ativo) values (1, 'Dr.Ricardo Yoshio', true);
insert into tb_medico (id, nome, is_ativo) values (2, 'Dr.Drauzio Varela', true);
insert into tb_medico (id, nome, is_ativo) values (3, 'Dr.Veterinária', true);
insert into tb_medico (id, nome, is_ativo) values (4, 'Dr.Saulo', true);
insert into tb_medico (id, nome, is_ativo) values (5, 'Dr.Dorivaldo', true);
insert into tb_medico (id, nome, is_ativo) values (6, 'Dra.Ana', true);

insert into tb_atendente (id, nome, is_ativo)  values (1, 'Andreia', true);
insert into tb_atendente (id, nome, is_ativo)  values (2, 'Cida', true);
insert into tb_atendente (id, nome, is_ativo)  values (3, 'Elizete', true);


INSERT INTO tb_paciente (id, codigo, nome, data_nasc, idade, rg, estado_civil, has_filhos, nome_responsavel_paciente, cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email, profissao, end_rua, end_numero, end_bairro, end_cidade, end_cep, end_tipo_residencia, end_observacao, is_deficiente, deficiencia, deficiencia_familia, has_convenio, observacao, is_aceite, indicacao, is_ativo, data_cadastro, data_atualizacao)
VALUES (1, 'a65bee75-2cb1-49d8-a31b-dfb6cbba39a3', 'Antonio', DATE('1974-01-01'), 49, '501818352', 'VIUVO', 7, 'Nineuda resp', '11940551452', '40551452', 'facebook.com', 'instagram.com', 'email@email.com', 'Professor', 'Rua das Árvores', '94', 'Bairro Lindo', 'São Bernardo', '09981011', 'OUTRO', 'do lado da granja', false, 'n/a', 'n/a', true, 'observado', true, 'Andreia irmã', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_paciente (id, codigo, nome, data_nasc, idade, rg, estado_civil, has_filhos, nome_responsavel_paciente, cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email, profissao, end_rua, end_numero, end_bairro, end_cidade, end_cep, end_tipo_residencia, end_observacao, is_deficiente, deficiencia, deficiencia_familia, has_convenio, observacao, is_aceite, indicacao, is_ativo, data_cadastro, data_atualizacao)
VALUES (2, '7884fd62-f27e-4e5d-bd03-c50333c48f71', 'Rosinete', DATE('1974-01-01'), 47, '501818352', 'DIVORCIADO', 7, 'Marinalva resp', '1140675391', '40675391', 'facebook.com', 'instagram.com', 'email@email.com', 'Enfermeira', 'Rua Moyses Cheidde', '94', 'Bairro Planalto', 'São Bernardo', '09890190', 'APARTAMENTO', 'do lado da madeireira', false, 'n/a', 'n/a', true, 'observado', true, 'Net irmã', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_paciente (id, codigo, nome, data_nasc, idade, rg, estado_civil, has_filhos, nome_responsavel_paciente, cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email, profissao, end_rua, end_numero, end_bairro, end_cidade, end_cep, end_tipo_residencia, end_observacao, is_deficiente, deficiencia, deficiencia_familia, has_convenio, observacao, is_aceite, indicacao, is_ativo, data_cadastro, data_atualizacao)
VALUES (3, '6f00edf7-d3fa-42a2-a643-cf2d7b5169a5', 'Batista', DATE('1974-01-01'), 70, '501818352', 'SOLTEIRO', 7, 'Nireide resp', '1140028922', '40028922', 'facebook.com', 'instagram.com', 'email@email.com', 'Caminhoneiro', 'Rua São Bernardo', '189', 'Bairro Inamar', 'Diadema', '09981011', 'CASA', 'do lado da igreja', false, 'n/a', 'n/a', true, 'observado', true, 'Nireide esposa', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_paciente (id, codigo, nome, data_nasc, idade, rg, estado_civil, has_filhos, nome_responsavel_paciente, cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email, profissao, end_rua, end_numero, end_bairro, end_cidade, end_cep, end_tipo_residencia, end_observacao, is_deficiente, deficiencia, deficiencia_familia, has_convenio, observacao, is_aceite, indicacao, is_ativo, data_cadastro, data_atualizacao)
VALUES (4, 'afe5b29e-35c8-40f6-b601-f8609c5fa080', 'Nireide', DATE('1974-01-01'), 68, '501818352', 'CASADO', 7, 'Batista resp', '11983181377', '83181377', 'facebook.com', 'instagram.com', 'email@email.com', 'Dona de Casa', 'Av São Bernardo', '189', 'Bairro inamar', 'Diadema', '09981011', 'OUTRO', 'do lado do bar', false, 'n/a', 'n/a', true, 'observado', true, 'Batista marido', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_paciente (id, codigo, nome, data_nasc, idade, rg, estado_civil, has_filhos, nome_responsavel_paciente, cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email, profissao, end_rua, end_numero, end_bairro, end_cidade, end_cep, end_tipo_residencia, end_observacao, is_deficiente, deficiencia, deficiencia_familia, has_convenio, observacao, is_aceite, indicacao, is_ativo, data_cadastro, data_atualizacao)
VALUES (5, 'afe5b29e-35c8-40f6-b601-f8609c5fa081', 'João', DATE('1985-06-20'), 38, '202020202', 'SOLTEIRO', 0, NULL, '11999999999', NULL, 'joao_facebook', 'joao_instagram', 'joao@email.com', 'Engenheiro', 'Rua das Flores', '123', 'Centro', 'São Paulo', '01234567', 'CASA', 'Próximo ao parque', false, NULL, NULL, false, NULL, true, 'Amigo indicou', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO tb_paciente (id, codigo, nome, data_nasc, idade, rg, estado_civil, has_filhos, nome_responsavel_paciente, cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email, profissao, end_rua, end_numero, end_bairro, end_cidade, end_cep, end_tipo_residencia, end_observacao, is_deficiente, deficiencia, deficiencia_familia, has_convenio, observacao, is_aceite, indicacao, is_ativo, data_cadastro, data_atualizacao)
VALUES (6, 'afe5b29e-35c8-40f6-b601-f8609c5fa082', 'Maria', DATE('1990-03-12'), 33, '303030303', 'CASADO', 2, 'Carlos resp', '11987654321', '11223344', 'carlos_facebook', 'carlos_instagram', 'carlos@email.com', 'Advogada', 'Avenida das Palmeiras', '500', 'Jardins', 'São Paulo', '02345678', 'APARTAMENTO', 'Próximo ao shopping', true, 'Nenhuma', 'Nenhuma', true, 'Paciente VIP', true, 'Indicação médica', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_paciente (id, codigo, nome, data_nasc, idade, rg, estado_civil, has_filhos, nome_responsavel_paciente, cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email, profissao, end_rua, end_numero, end_bairro, end_cidade, end_cep, end_tipo_residencia, end_observacao, is_deficiente, deficiencia, deficiencia_familia, has_convenio, observacao, is_aceite, indicacao, is_ativo, data_cadastro, data_atualizacao)
VALUES (7, 'afe5b29e-35c8-40f6-b601-f8609c5fa083', 'Ana', DATE('1982-11-05'), 40, '404040404', 'DIVORCIADO', 1, 'Pedro resp', '11944444444', '98765432', 'pedro_facebook', 'pedro_instagram', 'pedro@email.com', 'Médica', 'Rua das Montanhas', '70', 'Vila Bela', 'Campinas', '03456789', 'CASA', 'Próximo ao parque', false, NULL, NULL, false, NULL, true, 'Indicação de amigo', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_paciente (id, codigo, nome, data_nasc, idade, rg, estado_civil, has_filhos, nome_responsavel_paciente, cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email, profissao, end_rua, end_numero, end_bairro, end_cidade, end_cep, end_tipo_residencia, end_observacao, is_deficiente, deficiencia, deficiencia_familia, has_convenio, observacao, is_aceite, indicacao, is_ativo, data_cadastro, data_atualizacao)
VALUES (8, 'afe5b29e-35c8-40f6-b601-f8609c5fa084', 'Pedro', DATE('1978-09-28'), 45, '505050505', 'CASADO', 3, 'Marina resp', '11911111111', '33224455', 'marina_facebook', 'marina_instagram', 'marina@email.com', 'Engenheiro Civil', 'Rua dos Campos', '987', 'Centro', 'Belo Horizonte', '04567890', 'APARTAMENTO', 'Próximo ao metrô', true, 'Nenhuma', 'Nenhuma', true, 'Observações importantes', true, 'Indicação de colega', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO tb_paciente (id, codigo, nome, data_nasc, idade, rg, estado_civil, has_filhos, nome_responsavel_paciente, cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email, profissao, end_rua, end_numero, end_bairro, end_cidade, end_cep, end_tipo_residencia, end_observacao, is_deficiente, deficiencia, deficiencia_familia, has_convenio, observacao, is_aceite, indicacao, is_ativo, data_cadastro, data_atualizacao)
VALUES (9, 'afe5b29e-35c8-40f6-b601-f8609c5fa085', 'Carla', DATE('1989-12-10'), 33, '606060606', 'SOLTEIRO', 0, NULL, '11922222222', NULL, 'carla_facebook', 'carla_instagram', 'carla@email.com', 'Psicóloga', 'Rua das Rosas', '222', 'Jardim Florido', 'Porto Alegre', '05678901', 'CASA', 'Próximo à praça', false, NULL, NULL, false, NULL, true, 'Indicação de vizinho', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO tb_paciente (id, codigo, nome, data_nasc, idade, rg, estado_civil, has_filhos, nome_responsavel_paciente, cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email, profissao, end_rua, end_numero, end_bairro, end_cidade, end_cep, end_tipo_residencia, end_observacao, is_deficiente, deficiencia, deficiencia_familia, has_convenio, observacao, is_aceite, indicacao, is_ativo, data_cadastro, data_atualizacao)
VALUES (10, 'afe5b29e-35c8-40f6-b601-f8609c5fa086', 'Mariana', DATE('1995-07-25'), 28, '707070707', 'CASADO', 1, 'Ricardo resp', '11933333333', '44443333', 'ricardo_facebook', 'ricardo_instagram', 'ricardo@email.com', 'Enfermeira', 'Av das Águias', '456', 'Alphaville', 'Barueri', '06789012', 'APARTAMENTO', 'Próximo ao shopping', true, 'Nenhuma', 'Nenhuma', true, 'Observações importantes', true, 'Indicação do médico', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- ########################################################################################################################################################


insert into tb_local (id, nome_local, is_ativo,  end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (1, 'Clínica Movel', true, 'Rua das Árvores', '189', 'Bairro Lindo', 'Diadema', '09981011', 'OUTRO', 'do lado da granja');
insert into tb_local (id, nome_local,  is_ativo, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (2, 'Clínica Campanário', true, 'Rua do Campanário', '189', 'Bairro Campanário', 'Diadema-Campanário', '09981010', 'CASA', 'do lado da granja');
insert into tb_local (id, nome_local,  is_ativo, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (3, 'Clínica Sítio Joaninha', true,'Rua do Sítio Joaninha', '189', 'Bairro Sítio Joaninha', 'Diadema-Sítio Joaninha', '09981011', 'APARTAMENTO', 'do lado da feira');
insert into tb_local (id, nome_local,  is_ativo, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (4, 'Clínica Inamar', true, 'Rua do Inamar', '189', 'Bairro Inamar', 'Diadema-Inamar', '09981012', 'OUTRO', 'do lado da escola');

--
--insert into tb_exame (id,paciente_id,nome_exame, medico_id,local_id, data_exame, valor,  atendente_id, observacao, is_ativo) values (1,1, 'Exame do pulmão', 1, 1, CURRENT_DATE(), 350, 1, 'observações', 1);
--insert into tb_exame (id,paciente_id,nome_exame, medico_id,local_id, data_exame, valor,  atendente_id, observacao, is_ativo) values (2,2, 'Exame de vista', 2, 2, CURRENT_DATE(), 139, 2, 'observações', 1);
--insert into tb_exame (id,paciente_id,nome_exame, medico_id,local_id, data_exame, valor,  atendente_id, observacao, is_ativo) values (3,3, 'Exame do coração', 3, 3, CURRENT_DATE(), 50, 3, 'observações', 1);


INSERT INTO tb_exame (id, codigo, data_exame, nome_exame, observacao, valor, atendente_id, local_id, is_ativo, medico_id, paciente_id)
VALUES (1, '92bace06-9cc0-4bb0-aa45-587aeef8f812', CURRENT_TIMESTAMP, 'Exame de exemplo', 'Observações sobre o exame', 100.00, 1, 1, true, 1, 1);

INSERT INTO tb_exame (id, codigo, data_exame, nome_exame, observacao, valor, atendente_id, local_id, is_ativo, medico_id, paciente_id)
VALUES (2, 'b133bf67-715d-4a29-8f75-8d3f72f6ea45', CURRENT_TIMESTAMP, 'Exame de exemplo', 'Observações sobre o exame', 100.00, 1, 1, true, 1, 1);

INSERT INTO tb_exame (id, codigo, data_exame, nome_exame, observacao, valor, atendente_id, local_id, is_ativo, medico_id, paciente_id)
VALUES (3, '69541c9a-39ef-47a2-8c1f-88b5ac62f776', CURRENT_TIMESTAMP, 'Exame de exemplo', 'Observações sobre o exame', 100.00, 1, 1, true, 1, 1);

INSERT INTO tb_exame (id, codigo, data_exame, nome_exame, observacao, valor, atendente_id, local_id, is_ativo, medico_id, paciente_id)
VALUES (4, 'f366c720-1a6c-4cd3-975f-0ef93b145397', CURRENT_TIMESTAMP, 'Exame de exemplo', 'Observações sobre o exame', 100.00, 1, 1, true, 1, 1);

-- Inserts 2
INSERT INTO tb_exame (id, codigo, data_exame, nome_exame, observacao, valor, atendente_id, local_id, is_ativo, medico_id, paciente_id)
VALUES (5, '72629b51-0dd1-4b80-82c1-1c9e7751fc5c', CURRENT_TIMESTAMP, 'Exame de exemplo 2', 'Outras observações sobre o exame', 150.00, 2, 2, true, 2, 2);

INSERT INTO tb_exame (id, codigo, data_exame, nome_exame, observacao, valor, atendente_id, local_id, is_ativo, medico_id, paciente_id)
VALUES (6, 'cfaa2f84-c24a-4b96-8d0e-d53e44f0d9da', CURRENT_TIMESTAMP, 'Exame de terceiro', 'Observações adicionais sobre o terceiro exame', 80.00, 1, 3, true, 3, 3);

INSERT INTO tb_exame (id, codigo, data_exame, nome_exame, observacao, valor, atendente_id, local_id, is_ativo, medico_id, paciente_id)
VALUES (7, '02b7d758-cf20-42f0-8b65-450b94aef40c', CURRENT_TIMESTAMP, 'Exame de teste', 'Observações sobre o exame de teste', 120.00, 2, 1, false, 4, 4);

INSERT INTO tb_exame (id, codigo, data_exame, nome_exame, observacao, valor, atendente_id, local_id, is_ativo, medico_id, paciente_id)
VALUES (8, '3a2d55e2-46f4-43d5-b515-c56c2b51d2d9', CURRENT_TIMESTAMP, 'Exame 123', 'Mais informações sobre o exame 123', 90.00, 3, 2, true, 5, 5);

INSERT INTO tb_exame (id, codigo, data_exame, nome_exame, observacao, valor, atendente_id, local_id, is_ativo, medico_id, paciente_id)
VALUES (9, '68e4da18-06b9-45b2-af19-33b51f6058f6', CURRENT_TIMESTAMP, 'Exame A', 'Observações sobre o exame A', 130.00, 3, 3, false, 6, 4);

INSERT INTO tb_exame (id, codigo, data_exame, nome_exame, observacao, valor, atendente_id, local_id, is_ativo, medico_id, paciente_id)
VALUES (10, 'f951e11d-e05e-4c8a-92d1-5b0211d2a0e3', CURRENT_TIMESTAMP, 'Exame B', 'Observações sobre o exame B', 110.00, 2, 1, true, 4, 7);

INSERT INTO tb_exame (id, codigo, data_exame, nome_exame, observacao, valor, atendente_id, local_id, is_ativo, medico_id, paciente_id)
VALUES (11, '17f52c86-d891-4d19-9677-bd9e1d0b6ce5', CURRENT_TIMESTAMP, 'Exame XPTO', 'Observações sobre o exame XPTO', 75.00, 1, 2, false, 2, 8);

INSERT INTO tb_exame (id, codigo, data_exame, nome_exame, observacao, valor, atendente_id, local_id, is_ativo, medico_id, paciente_id)
VALUES (12, '0b4ce877-b2b7-40c1-84e6-28c151f6a2e9', CURRENT_TIMESTAMP, 'Exame YZ', 'Observações sobre o exame YZ', 95.00, 3, 3, true, 3, 9);

INSERT INTO tb_exame (id, codigo, data_exame, nome_exame, observacao, valor, atendente_id, local_id, is_ativo, medico_id, paciente_id)
VALUES (13, 'd3c8d330-69e5-4383-8e37-e98c69e9bdee', CURRENT_TIMESTAMP, 'Exame Final', 'Observações finais sobre o exame', 200.00, 2, 1, false, 3, 10);

INSERT INTO tb_exame (id, codigo, data_exame, nome_exame, observacao, valor, atendente_id, local_id, is_ativo, medico_id, paciente_id)
VALUES (14, '71ca40b9-8d4f-48e5-bb17-57ca94db8571', CURRENT_TIMESTAMP, 'Exame Último', 'Últimas observações sobre o exame', 85.00, 1, 2, true, 4, 11);

INSERT INTO tb_exame (id, codigo, data_exame, nome_exame, observacao, valor, atendente_id, local_id, is_ativo, medico_id, paciente_id)
VALUES (15, '8218e159-9e76-46c1-b0c1-95b3a9635ed0', CURRENT_TIMESTAMP, 'Exame odontológico', 'Novas observações sobre o exame', 82.00, 1, 2, true, 5, 11);



insert into tb_permissao (id, nome, descricao) values (1, 'EDITAR_PACIENTES', 'Permite criar, editar ou gerenciar exames');
insert into tb_permissao (id, nome, descricao) values (2, 'EDITAR_LOCAIS', 'Permite criar ou editar locais');
insert into tb_permissao (id, nome, descricao) values (3, 'EDITAR_MEDICOS', 'Permite criar ou editar medicos');
insert into tb_permissao (id, nome, descricao) values (4, 'EDITAR_ATENDENTES', 'Permite criar ou editar atendentes');
insert into tb_permissao (id, nome, descricao) values (5, 'CONSULTAR_USUARIOS_GRUPOS_PERMISSOES', 'Permite consultar usuários, grupos e permissões');
insert into tb_permissao (id, nome, descricao) values (6, 'EDITAR_USUARIOS_GRUPOS_PERMISSOES', 'Permite criar ou editar usuários, grupos e permissões');
insert into tb_permissao (id, nome, descricao) values (7, 'CONSULTAR_EXAMES', 'Permite consultar exames');
insert into tb_permissao (id, nome, descricao) values (8, 'GERENCIAR_EXAMES', 'Permite gerenciar exames');
insert into tb_permissao (id, nome, descricao) values (9, 'GERAR_RELATORIOS', 'Permite gerar relatórios');

insert into tb_grupo (id, nome) values (1, 'Gerente'), (2, 'Medico'), (3, 'Atendente'), (4, 'Cadastrador');



--# Adiciona todas as permissoes no grupo do gerente
insert into tb_grupo_permissao (grupo_id, permissao_id)
select 1, id from tb_permissao;

--# Adiciona permissoes no grupo do medico
insert into tb_grupo_permissao (grupo_id, permissao_id)
select 2, id from tb_permissao where nome like 'CONSULTAR_%';

insert into tb_grupo_permissao (grupo_id, permissao_id)
select 2, id from tb_permissao where nome = 'GERENCIAR_EXAMES';

--# Adiciona permissoes no grupo do atendente
insert into tb_grupo_permissao (grupo_id, permissao_id)
select 3, id from tb_permissao where nome like 'CONSULTAR_%';

insert into tb_grupo_permissao (grupo_id, permissao_id)
select 3, id from tb_permissao where nome = 'GERENCIAR_EXAMES';


--inserindo dados para testes
insert into tb_usuario (id, login, senha) values (1, 'frodo@email.com','$2a$12$5zEvFcRzlN0kgDYAOdOehuG5qdfKgnWPYZnPhWRej91FKrMka9EJa');

-- ##################################################
--insert into usuario (id, nome, email, senha, data_cadastro) values
--(1, 'Jonathan Henrique', 'jonathan@cuidar.com.br', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp),
--(2, 'Andreia Silva', 'andreia@cuidar.com.br', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp),
--(3, 'Eliete', 'eliete@cuidar.com.br', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp),
--(4, 'Nilson', 'nilson@cuidar.com.br', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp),
--(5, 'Ricardo Yoshio', 'ricardo@cuidar.com.br', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp),
--(6, 'Cida', 'cida@cuidar.com.br', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp),
--(7, 'Carlos Lima', 'email.teste.aw+carlos@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp);

--insert into tb_usuario_grupo (usuario_id, grupo_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 3),(3, 3), (4, 2), (5, 2);
insert into tb_usuario_grupo (usuario_id, grupo_id) values (1, 1);

-- #################################################

-- reativando todos os gatilhos

ALTER TABLE tb_atendente ENABLE TRIGGER ALL;
ALTER TABLE tb_exame ENABLE TRIGGER ALL;
ALTER TABLE tb_local ENABLE TRIGGER ALL;
ALTER TABLE tb_medico ENABLE TRIGGER ALL;
ALTER TABLE tb_paciente ENABLE TRIGGER ALL;
ALTER TABLE tb_usuario ENABLE TRIGGER ALL;
ALTER TABLE tb_usuario_grupo ENABLE TRIGGER ALL;
ALTER TABLE tb_permissao ENABLE TRIGGER ALL;
ALTER TABLE tb_grupo ENABLE TRIGGER ALL;
ALTER TABLE tb_grupo_permissao ENABLE TRIGGER ALL;