
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

insert into
tb_paciente (paciente_id, rg, is_aceite, cont_celular, cont_facebook, cont_instagram, cont_email, cont_telefone, is_convenio,
 data_cadastro, data_nasc, deficiencia, deficiencia_familia, is_deficiente, end_bairro, end_cep, end_cidade, end_numero,
  end_observacao, end_rua, end_tipo_residencia, estado_civil, filhos, idade, indicacao, is_ativo, nome,
   nome_responsavel_paciente, observacao, profissao)
 values (null, '501818352', true, '11983181377', 'facebook.com', 'instagram.com', 'email@email.com', '40028922', false,
     CURRENT_DATE(), '1997-05-05', false, false, false, 'Bairro Lindo', '09981011', 'Diadema', '189',
      'do lado da granja', 'Rua das Árvores', 'CASA', 0, 0, 25, '', true, 'Jonathan',
       '', 'observado', 'Programador');

insert into
tb_paciente (paciente_id, rg, is_aceite, cont_celular, cont_facebook, cont_instagram, cont_email, cont_telefone, is_convenio,
 data_cadastro, data_nasc, deficiencia, deficiencia_familia, is_deficiente, end_bairro, end_cep, end_cidade, end_numero,
  end_observacao, end_rua, end_tipo_residencia, estado_civil, filhos, idade, indicacao, is_ativo, nome,
   nome_responsavel_paciente, observacao, profissao)
 values (null, '501818352', true, '11983181377', 'facebook.com', 'instagram.com', 'email@email.com', '40028922', false,
     CURRENT_DATE(), '1997-05-05', false, false, false, 'Bairro Lindo', '09981011', 'Diadema', '189',
      'do lado da granja', 'Rua das Árvores', 'CASA', 1, 0, 1, '', true, 'Frodo',
       '', 'observado', 'Gato Doméstico');

 insert into
 tb_paciente (paciente_id, rg, is_aceite, cont_celular, cont_facebook, cont_instagram, cont_email, cont_telefone, is_convenio,
  data_cadastro, data_nasc, deficiencia, deficiencia_familia, is_deficiente, end_bairro, end_cep, end_cidade, end_numero,
   end_observacao, end_rua, end_tipo_residencia, estado_civil, filhos, idade, indicacao, is_ativo, nome,
    nome_responsavel_paciente, observacao, profissao)
  values (null, '501818352', true, '11983181377', 'facebook.com', 'instagram.com', 'email@email.com', '40028922', false,
      CURRENT_DATE(), '1997-05-05', false, false, false, 'Bairro Lindo', '09981011', 'Diadema', '189',
       'do lado da granja', 'Rua das Árvores', 'OUTRO', 2, 0, 1, '', true, 'Andreia',
        '', 'observado', 'Aposentada');

insert into
 tb_paciente (paciente_id, rg, is_aceite, cont_celular, cont_facebook, cont_instagram, cont_email, cont_telefone, is_convenio,
  data_cadastro, data_nasc, deficiencia, deficiencia_familia, is_deficiente, end_bairro, end_cep, end_cidade, end_numero,
   end_observacao, end_rua, end_tipo_residencia, estado_civil, filhos, idade, indicacao, is_ativo, nome,
    nome_responsavel_paciente, observacao, profissao)
  values (null, '501818352', true, '11983181377', 'facebook.com', 'instagram.com', 'email@email.com', '40028922', false,
      CURRENT_DATE(), '1997-05-05', false, false, false, 'Bairro Lindo', '09981011', 'Diadema', '189',
       'do lado da granja', 'Rua das Árvores', 'APARTAMENTO', 3, 0, 1, '', true, 'Dr.Yoshio',
        '', 'observado', 'Político');

insert into
 tb_paciente (paciente_id, rg, is_aceite, cont_celular, cont_facebook, cont_instagram, cont_email, cont_telefone, is_convenio,
  data_cadastro, data_nasc, deficiencia, deficiencia_familia, is_deficiente, end_bairro, end_cep, end_cidade, end_numero,
   end_observacao, end_rua, end_tipo_residencia, estado_civil, filhos, idade, indicacao, is_ativo, nome,
    nome_responsavel_paciente, observacao, profissao)
  values (null, '501818352', true, '11983181377', 'facebook.com', 'instagram.com', 'email@email.com', '40028922', false,
      CURRENT_DATE(), '1997-05-05', false, false, false, 'Bairro Lindo', '09981011', 'Diadema', '189',
       'do lado da granja', 'Rua das Árvores', 'CASA', 0, 0, 1, '', false, 'Willian desativ',
        '', 'observado', 'Político');

insert into tb_exame (id_exame, data_exame, local, medico, nome_exame, observacao, id_paciente, valor)
 values (null, CURRENT_DATE(), 'Diadema', 'Dr.Médico', 'Exame de Vista', 'observações', 1, 50);

insert into tb_exame (id_exame, data_exame, local, medico, nome_exame, observacao, id_paciente, valor)
values (null, CURRENT_DATE(), 'Diadema', 'Veterinária', 'Castração', 'observações', 2, 89);

insert into tb_exame (id_exame, data_exame, local, medico, nome_exame, observacao, id_paciente, valor)
 values (null, CURRENT_DATE(), 'Diadema', 'Dr.Saulo', 'Exame de Cabeã', 'observações', 3, 110);

insert into tb_exame (id_exame, data_exame, local, medico, nome_exame, observacao, id_paciente, valor)
 values (null, CURRENT_DATE(), 'Diadema', 'Dr.Dorivaldo', 'Exame do coração', 'observações', 4, 210);

 insert into tb_exame (id_exame, data_exame, local, medico, nome_exame, observacao, id_paciente, valor)
  values (null, CURRENT_DATE(), 'Diadema', 'Dra.Ana', 'Exame do pulmão', 'observações', 5, 350);

insert into tb_atendente (id_paciente, id_atendente) values (1, 'Andreia');
insert into tb_atendente (id_paciente, id_atendente) values (2, 'Cida');
insert into tb_atendente (id_paciente, id_atendente) values (3, 'Andreia');
insert into tb_atendente (id_paciente, id_atendente) values (4, 'Cida');
insert into tb_atendente (id_paciente, id_atendente) values (5, 'Andreia');

insert into tb_local_atendimento (id_paciente, id_local_atendimento) values (1, 'Diadema');
insert into tb_local_atendimento (id_paciente, id_local_atendimento) values (2, 'Campanário');
insert into tb_local_atendimento (id_paciente, id_local_atendimento) values (3, 'Sítio Joaninha');
insert into tb_local_atendimento (id_paciente, id_local_atendimento) values (4, 'Inamar');
insert into tb_local_atendimento (id_paciente, id_local_atendimento) values (5, 'Serraria');

insert into tb_medico_atendente (id_paciente, id_medico_atendente) values (1, 'Dr.Médico');
insert into tb_medico_atendente (id_paciente, id_medico_atendente) values (1, 'Dr.Veterinária');
insert into tb_medico_atendente (id_paciente, id_medico_atendente) values (1, 'Dr.Saulo');
insert into tb_medico_atendente (id_paciente, id_medico_atendente) values (1, 'Dr.Dorivaldo');
insert into tb_medico_atendente (id_paciente, id_medico_atendente) values (1, 'Dra.Ana');