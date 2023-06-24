
--set foreign_key_checks = 0;
--
--delete from tb_atendente;
--delete from tb_exame;
--delete from tb_local_atendimento;
--delete from tb_medico_atendente;
--delete from tb_paciente;
--
--set foreign_key_checks = 1;
--
--alter table tb_atendente auto_increment = 1;
--alter table tb_exame auto_increment = 1;
--alter table tb_local_atendimento auto_increment = 1;
--alter table tb_medico_atendente auto_increment = 1;
--alter table tb_paciente = 1;


insert into tb_usuario values (null, 'frodo@email.com','$2a$12$5zEvFcRzlN0kgDYAOdOehuG5qdfKgnWPYZnPhWRej91FKrMka9EJa');

insert into tb_medico (id, nome, is_ativo) values (1, 'Dr.Ricardo Yoshio', true);
insert into tb_medico (id, nome, is_ativo) values (2, 'Dr.Drauzio Varela', true);
insert into tb_medico (id, nome, is_ativo) values (3, 'Dr.Veterinária', true);
insert into tb_medico (id, nome, is_ativo) values (4, 'Dr.Saulo', true);
insert into tb_medico (id, nome, is_ativo) values (5, 'Dr.Dorivaldo', true);
insert into tb_medico (id, nome, is_ativo) values (6, 'Dra.Ana', true);

insert into tb_atendente (id, nome, is_ativo)  values (1, 'Andreia', true);
insert into tb_atendente (id, nome, is_ativo)  values (2, 'Cida', true);
insert into tb_atendente (id, nome, is_ativo)  values (3, 'Elizete', true);


insert into tb_paciente (id, nome,  data_nasc, idade,  rg, estado_civil, filhos, nome_responsavel_paciente,
cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email,
profissao, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao,
is_deficiente,  deficiencia, deficiencia_familia, is_convenio, observacao, is_aceite,
indicacao, is_ativo, data_cadastro)
values (1, 'Antonio','1974-04-15', 49, '501818352', 'VIUVO', 7, 'Nineuda resp',
'11940551452', '40551452', 'facebook.com', 'instagram.com', 'email@email.com',
'Professor', 'Rua das Árvores', '94', 'Bairro Lindo', 'São Bernardo', '09981011', 'OUTRO', 'do lado da granja',
false, 'n/a', 'n/a', true, 'observado', true,
'Andreia irmã', true, CURRENT_DATE());

insert into tb_paciente (id, nome,  data_nasc, idade,  rg, estado_civil, filhos, nome_responsavel_paciente,
cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email,
profissao, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao,
is_deficiente,  deficiencia, deficiencia_familia, is_convenio, observacao, is_aceite,
indicacao, is_ativo, data_cadastro)
values (2, 'Rosinete','1976-06-15', 47, '501818352', 'DIVORCIADO', 7, 'Marinalva resp',
'1140675391', '40675391', 'facebook.com', 'instagram.com', 'email@email.com',
'Enfermeira', 'Rua Moyses Cheidde', '94', 'Bairro Planalto', 'São Bernardo', '09890190', 'APARTAMENTO', 'do lado da madeireira',
false, 'n/a', 'n/a', true, 'observado', true,
'Net irmã', true, CURRENT_DATE());

insert into tb_paciente (id, nome,  data_nasc, idade,  rg, estado_civil, filhos, nome_responsavel_paciente,
cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email,
profissao, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao,
is_deficiente,  deficiencia, deficiencia_familia, is_convenio, observacao, is_aceite,
indicacao, is_ativo, data_cadastro)
values (3, 'Batista','1946-03-15', 70, '501818352', 'SOLTEIRO', 7, 'Nireide resp',
'1140028922', '40028922', 'facebook.com', 'instagram.com', 'email@email.com',
'Caminhoneiro', 'Rua São Bernardo', '189', 'Bairro Inamar', 'Diadema', '09981011', 'CASA', 'do lado da igreja',
false, 'n/a', 'n/a', true, 'observado', true,
'Nireide esposa', true, CURRENT_DATE());

insert into tb_paciente (id, nome,  data_nasc, idade,  rg, estado_civil, filhos, nome_responsavel_paciente,
cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email,
profissao, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao,
is_deficiente,  deficiencia, deficiencia_familia, is_convenio, observacao, is_aceite,
indicacao, is_ativo, data_cadastro)
values (4, 'Nireide','1950-06-15', 68, '501818352', 'CASADO', 7, 'Batista resp',
'11983181377', '83181377', 'facebook.com', 'instagram.com', 'email@email.com',
'Dona de Casa', 'Av São Bernardo', '189', 'Bairro inamar', 'Diadema', '09981011', 'OUTRO', 'do lado do bar',
false, 'n/a', 'n/a', true, 'observado', true,
'Batista marido', true, CURRENT_DATE());


insert into tb_local (id, nome_local, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (1, 'Clínica Movel', 'Rua das Árvores', '189', 'Bairro Lindo', 'Diadema', '09981011', 'OUTRO', 'do lado da granja');
insert into tb_local (id, nome_local, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (2, 'Clínica Campanário', 'Rua do Campanário', '189', 'Bairro Campanário', 'Diadema-Campanário', '09981010', 'CASA', 'do lado da granja');
insert into tb_local (id, nome_local, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (3, 'Clínica Sítio Joaninha','Rua do Sítio Joaninha', '189', 'Bairro Sítio Joaninha', 'Diadema-Sítio Joaninha', '09981011', 'APARTAMENTO', 'do lado da feira');
insert into tb_local (id, nome_local, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (4, 'Clínica Inamar', 'Rua do Inamar', '189', 'Bairro Inamar', 'Diadema-Inamar', '09981012', 'OUTRO', 'do lado da escola');


insert into tb_exame (id,paciente_id,nome_exame, medico_id,local_id, data_exame, valor,  atendente_id, observacao) values (1,1, 'Exame do pulmão', 1, 1, CURRENT_DATE(), 350, 1, 'observações');
insert into tb_exame (id,paciente_id,nome_exame, medico_id,local_id, data_exame, valor,  atendente_id, observacao) values (2,2, 'Exame de vista', 2, 2, CURRENT_DATE(), 139, 2, 'observações');
insert into tb_exame (id,paciente_id,nome_exame, medico_id,local_id, data_exame, valor,  atendente_id, observacao) values (3,3, 'Exame do coração', 3, 3, CURRENT_DATE(), 50, 3, 'observações');





