
-- Desabilitando verificação de chave estrangeira
SET REFERENTIAL_INTEGRITY FALSE;


-- Realizando as operações de exclusão
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

-- Habilitando verificação de chave estrangeira
SET REFERENTIAL_INTEGRITY TRUE;


-- Voltando a contagem dos IDs para 1
ALTER TABLE tb_atendente ALTER COLUMN id RESTART WITH 1;
ALTER TABLE tb_exame ALTER COLUMN id RESTART WITH 1;
ALTER TABLE tb_local ALTER COLUMN id RESTART WITH 1;
ALTER TABLE tb_medico ALTER COLUMN id RESTART WITH 1;
ALTER TABLE tb_paciente ALTER COLUMN id RESTART WITH 1;
ALTER TABLE tb_usuario ALTER COLUMN id RESTART WITH 1;
ALTER TABLE tb_permissao ALTER COLUMN id RESTART WITH 1;
ALTER TABLE tb_grupo ALTER COLUMN id RESTART WITH 1;



insert into tb_medico (id, nome, is_ativo) values (1, 'Dr.Ricardo Yoshio', true);
insert into tb_medico (id, nome, is_ativo) values (2, 'Dr.Drauzio Varela', true);
insert into tb_medico (id, nome, is_ativo) values (3, 'Dr.Veterinária', true);
insert into tb_medico (id, nome, is_ativo) values (4, 'Dr.Saulo', true);
insert into tb_medico (id, nome, is_ativo) values (5, 'Dr.Dorivaldo', true);
insert into tb_medico (id, nome, is_ativo) values (6, 'Dra.Ana', true);

insert into tb_atendente (id, nome, is_ativo)  values (1, 'Andreia', true);
insert into tb_atendente (id, nome, is_ativo)  values (2, 'Cida', true);
insert into tb_atendente (id, nome, is_ativo)  values (3, 'Elizete', true);


insert into tb_paciente (id,codigo, nome,  data_nasc, idade,  rg, estado_civil, filhos, nome_responsavel_paciente,
cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email,
profissao, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao,
is_deficiente,  deficiencia, deficiencia_familia, is_convenio, observacao, is_aceite,
indicacao, is_ativo, data_cadastro, data_atualizacao)
values (1,'a65bee75-2cb1-49d8-a31b-dfb6cbba39a3', 'Antonio','1974-04-15', 49, '501818352', 'VIUVO', 7, 'Nineuda resp',
'11940551452', '40551452', 'facebook.com', 'instagram.com', 'email@email.com',
'Professor', 'Rua das Árvores', '94', 'Bairro Lindo', 'São Bernardo', '09981011', 'OUTRO', 'do lado da granja',
false, 'n/a', 'n/a', true, 'observado', true,
'Andreia irmã', true, CURRENT_DATE(), CURRENT_DATE());
--'Andreia irmã', true, CURRENT_TIMESTAMP());

insert into tb_paciente (id,codigo, nome,  data_nasc, idade,  rg, estado_civil, filhos, nome_responsavel_paciente,
cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email,
profissao, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao,
is_deficiente,  deficiencia, deficiencia_familia, is_convenio, observacao, is_aceite,
indicacao, is_ativo, data_cadastro, data_atualizacao)
values (2,'7884fd62-f27e-4e5d-bd03-c50333c48f71', 'Rosinete','1976-06-15', 47, '501818352', 'DIVORCIADO', 7, 'Marinalva resp',
'1140675391', '40675391', 'facebook.com', 'instagram.com', 'email@email.com',
'Enfermeira', 'Rua Moyses Cheidde', '94', 'Bairro Planalto', 'São Bernardo', '09890190', 'APARTAMENTO', 'do lado da madeireira',
false, 'n/a', 'n/a', true, 'observado', true,
'Net irmã', true, CURRENT_DATE(), CURRENT_DATE());

insert into tb_paciente (id,codigo, nome,  data_nasc, idade,  rg, estado_civil, filhos, nome_responsavel_paciente,
cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email,
profissao, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao,
is_deficiente,  deficiencia, deficiencia_familia, is_convenio, observacao, is_aceite,
indicacao, is_ativo, data_cadastro, data_atualizacao)
values (3,'6f00edf7-d3fa-42a2-a643-cf2d7b5169a5', 'Batista','1946-03-15', 70, '501818352', 'SOLTEIRO', 7, 'Nireide resp',
'1140028922', '40028922', 'facebook.com', 'instagram.com', 'email@email.com',
'Caminhoneiro', 'Rua São Bernardo', '189', 'Bairro Inamar', 'Diadema', '09981011', 'CASA', 'do lado da igreja',
false, 'n/a', 'n/a', true, 'observado', true,
'Nireide esposa', true, CURRENT_DATE(), CURRENT_DATE());

insert into tb_paciente (id,codigo, nome,  data_nasc, idade,  rg, estado_civil, filhos, nome_responsavel_paciente,
cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email,
profissao, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao,
is_deficiente,  deficiencia, deficiencia_familia, is_convenio, observacao, is_aceite,
indicacao, is_ativo, data_cadastro, data_atualizacao)
values (4,'afe5b29e-35c8-40f6-b601-f8609c5fa080', 'Nireide','1950-06-15', 68, '501818352', 'CASADO', 7, 'Batista resp',
'11983181377', '83181377', 'facebook.com', 'instagram.com', 'email@email.com',
'Dona de Casa', 'Av São Bernardo', '189', 'Bairro inamar', 'Diadema', '09981011', 'OUTRO', 'do lado do bar',
false, 'n/a', 'n/a', true, 'observado', true,
'Batista marido', true, CURRENT_DATE(), CURRENT_DATE());


insert into tb_local (id, nome_local, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (1, 'Clínica Movel', 'Rua das Árvores', '189', 'Bairro Lindo', 'Diadema', '09981011', 'OUTRO', 'do lado da granja');
insert into tb_local (id, nome_local, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (2, 'Clínica Campanário', 'Rua do Campanário', '189', 'Bairro Campanário', 'Diadema-Campanário', '09981010', 'CASA', 'do lado da granja');
insert into tb_local (id, nome_local, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (3, 'Clínica Sítio Joaninha','Rua do Sítio Joaninha', '189', 'Bairro Sítio Joaninha', 'Diadema-Sítio Joaninha', '09981011', 'APARTAMENTO', 'do lado da feira');
insert into tb_local (id, nome_local, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (4, 'Clínica Inamar', 'Rua do Inamar', '189', 'Bairro Inamar', 'Diadema-Inamar', '09981012', 'OUTRO', 'do lado da escola');


insert into tb_exame (id,paciente_id,nome_exame, medico_id,local_id, data_exame, valor,  atendente_id, observacao, situacao) values (1,1, 'Exame do pulmão', 1, 1, CURRENT_DATE(), 350, 1, 'observações', 1);
insert into tb_exame (id,paciente_id,nome_exame, medico_id,local_id, data_exame, valor,  atendente_id, observacao, situacao) values (2,2, 'Exame de vista', 2, 2, CURRENT_DATE(), 139, 2, 'observações', 1);
insert into tb_exame (id,paciente_id,nome_exame, medico_id,local_id, data_exame, valor,  atendente_id, observacao, situacao) values (3,3, 'Exame do coração', 3, 3, CURRENT_DATE(), 50, 3, 'observações', 1);


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
insert into tb_usuario (id, login, senha) values (null, 'frodo@email.com','$2a$12$5zEvFcRzlN0kgDYAOdOehuG5qdfKgnWPYZnPhWRej91FKrMka9EJa');

--##################################################
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

--#################################################

