

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


INSERT INTO tb_paciente (id,codigo, nome, rg, estado_civil, filhos, idade, indicacao, is_ativo, nome_responsavel_paciente, observacao, profissao, is_aceite, is_convenio, data_cadastro, data_nasc, data_atualizacao, deficiencia, deficiencia_familia, is_deficiente, cont_celular, cont_facebook, cont_instagram, cont_email, cont_telefone, end_bairro, end_cep, end_cidade, end_numero, end_observacao, end_rua, end_tipo_residencia)
VALUES (1,'a65bee75-2cb1-49d8-a31b-dfb6cbba39a3', 'Antonio', '501818352', 'VIUVO', 7, 49, 'Nineuda resp', true, 'Antonio responsável', 'observações', 'Professor', true, true, CURRENT_TIMESTAMP, '1974-01-01', CURRENT_TIMESTAMP, 'n/a', 'n/a', false, '11940551452', 'facebook.com', 'instagram.com', 'email@email.com', '40551452', 'Bairro Lindo', '09981011', 'São Bernardo', '94', 'do lado da granja', 'Rua das Árvores', 'OUTRO');



INSERT INTO tb_paciente (id,codigo, nome, rg, estado_civil, filhos, idade, indicacao, is_ativo, nome_responsavel_paciente, observacao, profissao, is_aceite, is_convenio, data_cadastro, data_nasc, data_atualizacao, deficiencia, deficiencia_familia, is_deficiente, cont_celular, cont_facebook, cont_instagram, cont_email, cont_telefone, end_bairro, end_cep, end_cidade, end_numero, end_observacao, end_rua, end_tipo_residencia)
VALUES (2,'7884fd62-f27e-4e5d-bd03-c50333c48f71', 'Rosinete', '501818352', 'VIUVO', 7, 47, 'Marinalva resp', true, 'Antonio responsável', 'observações', 'Enfermeira', true, true, CURRENT_TIMESTAMP, '1974-01-01', CURRENT_TIMESTAMP, 'n/a', 'n/a', false, '11940551452', 'facebook.com', 'instagram.com', 'email@email.com', '40551452', 'Bairro Planalto', '09981011', 'São Bernardo', '94', 'do lado da granja', 'Rua Moyses Cheidde', 'OUTRO');


--insert into tb_paciente (id,codigo, nome,  data_nasc, idade,  rg, estado_civil, filhos, nome_responsavel_paciente,
--cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email,
--profissao, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao,
--is_deficiente,  deficiencia, deficiencia_familia, is_convenio, observacao, is_aceite,
--indicacao, is_ativo, data_cadastro, data_atualizacao)
--values (2,'7884fd62-f27e-4e5d-bd03-c50333c48f71', 'Rosinete',DATE('1974-01-01'), 47, '501818352', 'DIVORCIADO', 7, 'Marinalva resp',
--'1140675391', '40675391', 'facebook.com', 'instagram.com', 'email@email.com',
--'Enfermeira', 'Rua Moyses Cheidde', '94', 'Bairro Planalto', 'São Bernardo', '09890190', 'APARTAMENTO', 'do lado da madeireira',
--false, 'n/a', 'n/a', true, 'observado', true,
--'Net irmã', true, CURRENT_DATE(), CURRENT_DATE());


INSERT INTO tb_paciente (id,codigo, nome, rg, estado_civil, filhos, idade, indicacao, is_ativo, nome_responsavel_paciente, observacao, profissao, is_aceite, is_convenio, data_cadastro, data_nasc, data_atualizacao, deficiencia, deficiencia_familia, is_deficiente, cont_celular, cont_facebook, cont_instagram, cont_email, cont_telefone, end_bairro, end_cep, end_cidade, end_numero, end_observacao, end_rua, end_tipo_residencia)
VALUES (3,'78823d92-f27e-4e5d-bd03-c50333c48f71', 'Rosinete', '501818352', 'VIUVO', 7, 47, 'Marinalva resp', true, 'Antonio responsável', 'observações', 'Enfermeira', true, true, CURRENT_TIMESTAMP, '1974-01-01', CURRENT_TIMESTAMP, 'n/a', 'n/a', false, '11940551452', 'facebook.com', 'instagram.com', 'email@email.com', '40551452', 'Bairro Planalto', '09981011', 'São Bernardo', '94', 'do lado da granja', 'Rua Moyses Cheidde', 'OUTRO');

--
--insert into tb_paciente (id,codigo, nome,  data_nasc, idade,  rg, estado_civil, filhos, nome_responsavel_paciente,
--cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email,
--profissao, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao,
--is_deficiente,  deficiencia, deficiencia_familia, is_convenio, observacao, is_aceite,
--indicacao, is_ativo, data_cadastro, data_atualizacao)
--values (3,'6f00edf7-d3fa-42a2-a643-cf2d7b5169a5', 'Batista',DATE('1974-01-01'), 70, '501818352', 'SOLTEIRO', 7, 'Nireide resp',
--'1140028922', '40028922', 'facebook.com', 'instagram.com', 'email@email.com',
--'Caminhoneiro', 'Rua São Bernardo', '189', 'Bairro Inamar', 'Diadema', '09981011', 'CASA', 'do lado da igreja',
--false, 'n/a', 'n/a', true, 'observado', true,
--'Nireide esposa', true, CURRENT_DATE(), CURRENT_DATE());


INSERT INTO tb_paciente (id,codigo, nome, rg, estado_civil, filhos, idade, indicacao, is_ativo, nome_responsavel_paciente, observacao, profissao, is_aceite, is_convenio, data_cadastro, data_nasc, data_atualizacao, deficiencia, deficiencia_familia, is_deficiente, cont_celular, cont_facebook, cont_instagram, cont_email, cont_telefone, end_bairro, end_cep, end_cidade, end_numero, end_observacao, end_rua, end_tipo_residencia)
VALUES (4,'7884fd62-f56e-4e5d-bd03-c50333c48f71', 'Rosinete', '501818352', 'VIUVO', 7, 47, 'Marinalva resp', true, 'Antonio responsável', 'observações', 'Enfermeira', true, true, CURRENT_TIMESTAMP, '1974-01-01', CURRENT_TIMESTAMP, 'n/a', 'n/a', false, '11940551452', 'facebook.com', 'instagram.com', 'email@email.com', '40551452', 'Bairro Planalto', '09981011', 'São Bernardo', '94', 'do lado da granja', 'Rua Moyses Cheidde', 'OUTRO');

--
--insert into tb_paciente (id,codigo, nome,  data_nasc, idade,  rg, estado_civil, filhos, nome_responsavel_paciente,
--cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email,
--profissao, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao,
--is_deficiente,  deficiencia, deficiencia_familia, is_convenio, observacao, is_aceite,
--indicacao, is_ativo, data_cadastro, data_atualizacao)
--values (4,'afe5b29e-35c8-40f6-b601-f8609c5fa080', 'Nireide',DATE('1974-01-01'), 68, '501818352', 'CASADO', 7, 'Batista resp',
--'11983181377', '83181377', 'facebook.com', 'instagram.com', 'email@email.com',
--'Dona de Casa', 'Av São Bernardo', '189', 'Bairro inamar', 'Diadema', '09981011', 'OUTRO', 'do lado do bar',
--false, 'n/a', 'n/a', true, 'observado', true,
--'Batista marido', true, CURRENT_DATE(), CURRENT_DATE());


insert into tb_local (id, nome_local, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (1, 'Clínica Movel', 'Rua das Árvores', '189', 'Bairro Lindo', 'Diadema', '09981011', 'OUTRO', 'do lado da granja');
insert into tb_local (id, nome_local, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (2, 'Clínica Campanário', 'Rua do Campanário', '189', 'Bairro Campanário', 'Diadema-Campanário', '09981010', 'CASA', 'do lado da granja');
insert into tb_local (id, nome_local, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (3, 'Clínica Sítio Joaninha','Rua do Sítio Joaninha', '189', 'Bairro Sítio Joaninha', 'Diadema-Sítio Joaninha', '09981011', 'APARTAMENTO', 'do lado da feira');
insert into tb_local (id, nome_local, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (4, 'Clínica Inamar', 'Rua do Inamar', '189', 'Bairro Inamar', 'Diadema-Inamar', '09981012', 'OUTRO', 'do lado da escola');

--
--insert into tb_exame (id,paciente_id,nome_exame, medico_id,local_id, data_exame, valor,  atendente_id, observacao, situacao) values (1,1, 'Exame do pulmão', 1, 1, CURRENT_DATE(), 350, 1, 'observações', 1);
--insert into tb_exame (id,paciente_id,nome_exame, medico_id,local_id, data_exame, valor,  atendente_id, observacao, situacao) values (2,2, 'Exame de vista', 2, 2, CURRENT_DATE(), 139, 2, 'observações', 1);
--insert into tb_exame (id,paciente_id,nome_exame, medico_id,local_id, data_exame, valor,  atendente_id, observacao, situacao) values (3,3, 'Exame do coração', 3, 3, CURRENT_DATE(), 50, 3, 'observações', 1);
INSERT INTO tb_exame (id,data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (1,CURRENT_TIMESTAMP, 'Exame de exemplo', 'Observações sobre o exame', 100.00, 1, 1, true, 1, 1);

INSERT INTO tb_exame (id,data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (2,CURRENT_TIMESTAMP, 'Exame de exemplo', 'Observações sobre o exame', 100.00, 1, 1, true, 1, 1);

INSERT INTO tb_exame (id,data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (3,CURRENT_TIMESTAMP, 'Exame de exemplo', 'Observações sobre o exame', 100.00, 1, 1, true, 1, 1);


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


insert into tb_grupo_permissao (grupo_id, permissao_id)
select 1, id from tb_permissao;

insert into tb_grupo_permissao (grupo_id, permissao_id)
select 2, id from tb_permissao where nome like 'CONSULTAR_%';

insert into tb_grupo_permissao (grupo_id, permissao_id)
select 2, id from tb_permissao where nome = 'GERENCIAR_EXAMES';

insert into tb_grupo_permissao (grupo_id, permissao_id)
select 3, id from tb_permissao where nome like 'CONSULTAR_%';

insert into tb_grupo_permissao (grupo_id, permissao_id)
select 3, id from tb_permissao where nome = 'GERENCIAR_EXAMES';


insert into tb_usuario (id, login, senha) values (1, 'frodo@email.com','$2a$12$5zEvFcRzlN0kgDYAOdOehuG5qdfKgnWPYZnPhWRej91FKrMka9EJa');

insert into tb_usuario_grupo (usuario_id, grupo_id) values (1, 1);


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