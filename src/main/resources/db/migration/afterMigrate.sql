
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
--'Andreia irmã', true, CURRENT_DATE());

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

-- ########################################################################################################################################################################################################################################################################
INSERT
INTO
tb_paciente
(     id, codigo, nome, data_nasc, idade, rg, estado_civil, filhos, nome_responsavel_paciente, cont_celular, cont_telefone, cont_facebook, cont_instagram, cont_email, profissao, end_rua, end_numero, end_bairro, end_cidade, end_cep, end_tipo_residencia, end_observacao, is_deficiente, deficiencia, deficiencia_familia, is_convenio, observacao, is_aceite, indicacao, is_ativo, data_cadastro, data_atualizacao )
VALUES
(    5, 'afe5b29e-35c8-40f6-b601-f8609c5fa023', 'Antonio', '1974-04-15', 49, '501818352', 'VIUVO', 7, 'Nineuda resp', '11940551452', '40551452', 'facebook.com', 'instagram.com', 'email@email.com', 'Professor', 'Rua das Árvores', '94', 'Bairro Lindo', 'São Bernardo', '09981011', 'OUTRO', 'do lado da granja', false, 'n/a', 'n/a', true, 'observado', true, 'Andreia irmã', true, CURRENT_DATE(), CURRENT_DATE() );

INSERT
INTO
tb_paciente
(   id,codigo,   nome,   data_nasc,   idade,   rg,   estado_civil,   filhos,   nome_responsavel_paciente,   cont_celular,   cont_telefone,   cont_facebook,   cont_instagram,   cont_email,   profissao,   end_rua,   end_numero,   end_bairro,   end_cidade,   end_cep,   end_tipo_residencia,   end_observacao,   is_deficiente,   deficiencia,   deficiencia_familia,   is_convenio,   observacao,   is_aceite,   indicacao,   is_ativo,   data_cadastro,   data_atualizacao )
VALUES
(   6,'b84fda4c-e3e8-4e34-92ab-f2ce8c72a15d',   'Maria',   '1990-10-20',   32,   '702345128',   'CASADO',   2,   'João responsável',   '11987654321',   '98765432',   'facebook_maria',   'instagram_maria',   'maria@email.com',   'Advogada',   'Avenida das Flores',   '123',   'Centro',   'São Paulo',   '01234567',   'CASA',   'Próximo à praça',   false,   'n/a',   'n/a',   true,   'Observações sobre Maria',   true,   'Amiga da família',   true,   CURRENT_DATE(),   CURRENT_DATE() );


INSERT
INTO
tb_paciente
(   id,codigo,   nome,   data_nasc,   idade,   rg,   estado_civil,   filhos,   nome_responsavel_paciente,   cont_celular,   cont_telefone,   cont_facebook,   cont_instagram,   cont_email,   profissao,   end_rua,   end_numero,   end_bairro,   end_cidade,   end_cep,   end_tipo_residencia,   end_observacao,   is_deficiente,   deficiencia,   deficiencia_familia,   is_convenio,   observacao,   is_aceite,   indicacao,   is_ativo,   data_cadastro,   data_atualizacao )
VALUES
(   7,'c84c3a20-86f6-4a2d-9c95-ec3f7aaff4e1',   'João',   '1985-06-12',   38,   '801234567',   'SOLTEIRO',   0,   NULL,   '11999998888',   '99998888',   'facebook_joao',   'instagram_joao',   'joao@email.com',   'Engenheiro',   'Rua dos Carros',   '456',   'Bairro Novo',   'Porto Alegre',   '12345678',   'APARTAMENTO',   'Próximo à estação de metrô',   false,   'n/a',   'n/a',   false,   'Observações sobre João',   true,   NULL,   true,   CURRENT_DATE(),   CURRENT_DATE() );


INSERT
INTO
tb_paciente
(   id,codigo,   nome,   data_nasc,   idade,   rg,   estado_civil,   filhos,   nome_responsavel_paciente,   cont_celular,   cont_telefone,   cont_facebook,   cont_instagram,   cont_email,   profissao,   end_rua,   end_numero,   end_bairro,   end_cidade,   end_cep,   end_tipo_residencia,   end_observacao,   is_deficiente,   deficiencia,   deficiencia_familia,   is_convenio,   observacao,   is_aceite,   indicacao,   is_ativo,   data_cadastro,   data_atualizacao )
VALUES
(   8,'f45303b7-efc5-4c77-a256-b8be956c3f10',   'Ana',   '1992-09-25',   31,   '904567123',   'CASADO',   1,   'Pedro responsável',   '11987655432',   '98765543',   'facebook_ana',   'instagram_ana',   'ana@email.com',   'Médica',   'Avenida das Palmeiras',   '789',   'Jardins',   'Rio de Janeiro',   '54321098',   'CASA',   'Próximo ao parque',   false,   'n/a',   'n/a',   true,   'Observações sobre Ana',   true,   'Indicação de um colega',   true,   CURRENT_DATE(),   CURRENT_DATE() );


INSERT
INTO
    tb_paciente
    (   id,codigo,   nome,   data_nasc,   idade,   rg,   estado_civil,   filhos,   nome_responsavel_paciente,   cont_celular,   cont_telefone,   cont_facebook,   cont_instagram,   cont_email,   profissao,   end_rua,   end_numero,   end_bairro,   end_cidade,   end_cep,   end_tipo_residencia,   end_observacao,   is_deficiente,   deficiencia,   deficiencia_familia,   is_convenio,   observacao,   is_aceite,   indicacao,   is_ativo,   data_cadastro,   data_atualizacao )
VALUES
    (   9,'b1f3a618-42a1-4c06-8c6c-df38739edfa3',   'Carlos',   '1988-03-08',   35,   '702345234',   'CASADO',   2,   'Julia responsável',   '11993456789',   '34567890',   'facebook_carlos',   'instagram_carlos',   'carlos@email.com',   'Engenheiro Civil',   'Rua dos Coqueiros',   '32',   'Centro',   'Curitiba',   '98765432',   'APARTAMENTO',   'Próximo ao shopping',   false,   'n/a',   'n/a',   true,   'Observações sobre Carlos',   true,   'Indicação de um amigo',   true,   CURRENT_DATE(),   CURRENT_DATE() );


INSERT
INTO
tb_paciente
(  id, codigo,   nome,   data_nasc,   idade,   rg,   estado_civil,   filhos,   nome_responsavel_paciente,   cont_celular,   cont_telefone,   cont_facebook,   cont_instagram,   cont_email,   profissao,   end_rua,   end_numero,   end_bairro,   end_cidade,   end_cep,   end_tipo_residencia,   end_observacao,   is_deficiente,   deficiencia,   deficiencia_familia,   is_convenio,   observacao,   is_aceite,   indicacao,   is_ativo,   data_cadastro,   data_atualizacao )
VALUES
(   10,'be19ed22-4b4a-478f-a28d-098d8ca91245',   'Laura',   '1995-11-02',   28,   '103254987',   'SOLTEIRO',   0,   NULL,   '11966665555',   '66665555',   'facebook_laura',   'instagram_laura',   'laura@email.com',   'Arquiteta',   'Rua das Montanhas',   '764',   'Alvorada',   'Porto Alegre',   '76543210',   'CASA',   'Próximo à praia',   false,   'n/a',   'n/a',   false,   'Observações sobre Laura',   true,   NULL,   true,   CURRENT_DATE(),   CURRENT_DATE() );


INSERT
INTO
tb_paciente
(   id,codigo,   nome,   data_nasc,   idade,   rg,   estado_civil,   filhos,   nome_responsavel_paciente,   cont_celular,   cont_telefone,   cont_facebook,   cont_instagram,   cont_email,   profissao,   end_rua,   end_numero,   end_bairro,   end_cidade,   end_cep,   end_tipo_residencia,   end_observacao,   is_deficiente,   deficiencia,   deficiencia_familia,   is_convenio,   observacao,   is_aceite,   indicacao,   is_ativo,   data_cadastro,   data_atualizacao )
VALUES
(   11,'de85eac0-2e68-4d6e-bc89-e4d03577869e',   'Pedro',   '1980-07-18',   43,   '765432109',   'CASADO',   2,   'Luciana responsável',   '11999992222',   '99992222',   'facebook_pedro',   'instagram_pedro',   'pedro@email.com',   'Advogado',   'Avenida das Rosas',   '987',   'Jardim das Flores',   'São Paulo',   '12345678',   'APARTAMENTO',   'Próximo à estação de trem',   false,   'n/a',   'n/a',   true,   'Observações sobre Pedro',   true,   'Indicação de um cliente',   true,   CURRENT_DATE(),   CURRENT_DATE() );


INSERT
INTO
tb_paciente
(   id,codigo,   nome,   data_nasc,   idade,   rg,   estado_civil,   filhos,   nome_responsavel_paciente,   cont_celular,   cont_telefone,   cont_facebook,   cont_instagram,   cont_email,   profissao,   end_rua,   end_numero,   end_bairro,   end_cidade,   end_cep,   end_tipo_residencia,   end_observacao,   is_deficiente,   deficiencia,   deficiencia_familia,   is_convenio,   observacao,   is_aceite,   indicacao,   is_ativo,   data_cadastro,   data_atualizacao )
VALUES
(   12,'a2f4a0d2-68d1-4751-89c6-986f3a547381',   'Sofia',   '1998-12-05',   25,   '887654321',   'CASADO',   1,   'Rafael responsável',   '11976543210',   '76543210',   'facebook_sofia',   'instagram_sofia',   'sofia@email.com',   'Professora',   'Rua das Orquídeas',   '753',   'Vila Nova',   'Porto Alegre',   '87654321',   'CASA',   'Próximo ao parque',   false,   'n/a',   'n/a',   false,   'Observações sobre Sofia',   true,   'Amiga da família',   true,   CURRENT_DATE(),   CURRENT_DATE() );


INSERT
INTO
tb_paciente
(   id,codigo,   nome,   data_nasc,   idade,   rg,   estado_civil,   filhos,   nome_responsavel_paciente,   cont_celular,   cont_telefone,   cont_facebook,   cont_instagram,   cont_email,   profissao,   end_rua,   end_numero,   end_bairro,   end_cidade,   end_cep,   end_tipo_residencia,   end_observacao,   is_deficiente,   deficiencia,   deficiencia_familia,   is_convenio,   observacao,   is_aceite,   indicacao,   is_ativo,   data_cadastro,   data_atualizacao )
VALUES
(   13,'c80a941f-25df-43e5-b98e-8c0bf3d05e9c',   'Daniel',   '1999-04-30',   24,   '102938475',   'SOLTEIRO',   0,   NULL,   '11988776655',   '88776655',   'facebook_daniel',   'instagram_daniel',   'daniel@email.com',   'Estudante',   'Rua das Estrelas',   '148',   'Centro',   'Curitiba',   '87654321',   'APARTAMENTO',   'Próximo ao teatro',   false,   'n/a',   'n/a',   true,   'Observações sobre Daniel',   true,   NULL,   true,   CURRENT_DATE(),   CURRENT_DATE() );


INSERT
INTO
tb_paciente
(   id,codigo,   nome,   data_nasc,   idade,   rg,   estado_civil,   filhos,   nome_responsavel_paciente,   cont_celular,   cont_telefone,   cont_facebook,   cont_instagram,   cont_email,   profissao,   end_rua,   end_numero,   end_bairro,   end_cidade,   end_cep,   end_tipo_residencia,   end_observacao,   is_deficiente,   deficiencia,   deficiencia_familia,   is_convenio,   observacao,   is_aceite,   indicacao,   is_ativo,   data_cadastro,   data_atualizacao )
VALUES
(   14,'fb4a9e29-87f1-4e49-b706-9e69a58b7845',   'Isabela',   '2000-11-15',   23,   '987654321',   'SOLTEIRO',   0,   NULL,   '11911112222',   '11112222',   'facebook_isabela',   'instagram_isabela',   'isabela@email.com',   'Estudante de Medicina',   'Avenida das Maravilhas',   '987',   'Jardim das Aves',   'São Paulo',   '87654321',   'CASA',   'Próximo ao hospital',   false,   'n/a',   'n/a',   false,   'Observações sobre Isabela',   true,   'Indicação de um colega',   true,   CURRENT_DATE(),   CURRENT_DATE() );


INSERT
INTO
tb_paciente
(   id,codigo,   nome,   data_nasc,   idade,   rg,   estado_civil,   filhos,   nome_responsavel_paciente,   cont_celular,   cont_telefone,   cont_facebook,   cont_instagram,   cont_email,   profissao,   end_rua,   end_numero,   end_bairro,   end_cidade,   end_cep,   end_tipo_residencia,   end_observacao,   is_deficiente,   deficiencia,   deficiencia_familia,   is_convenio,   observacao,   is_aceite,   indicacao,   is_ativo,   data_cadastro,   data_atualizacao )
VALUES
(   15,'ab65a2a2-5c89-4025-b1e6-3f90a2db5a63',   'Guilherme',   '1994-08-07',   29,   '675849203',   'SOLTEIRO',   0,   NULL,   '11933334444',   '33334444',   'facebook_guilherme',   'instagram_guilherme',   'guilherme@email.com',   'Engenheiro de Software',   'Rua das Pedras',   '78',   'Centro',   'Belo Horizonte',   '76543210',   'APARTAMENTO',   'Próximo à universidade',   false,   'n/a',   'n/a',   false,   'Observações sobre Guilherme',   true,   'Indicação de um amigo',   true,   CURRENT_DATE(),   CURRENT_DATE() );


INSERT
INTO
tb_paciente
(   id,codigo,   nome,   data_nasc,   idade,   rg,   estado_civil,   filhos,   nome_responsavel_paciente,   cont_celular,   cont_telefone,   cont_facebook,   cont_instagram,   cont_email,   profissao,   end_rua,   end_numero,   end_bairro,   end_cidade,   end_cep,   end_tipo_residencia,   end_observacao,   is_deficiente,   deficiencia,   deficiencia_familia,   is_convenio,   observacao,   is_aceite,   indicacao,   is_ativo,   data_cadastro,   data_atualizacao )
VALUES
(   16,'fd3dd8aa-4314-4c08-94ef-b15e14b66f49',   'Rafaela',   '1997-02-25',   26,   '908172635',   'SOLTEIRO',   0,   NULL,   '11922223333',   '22223333',   'facebook_rafaela',   'instagram_rafaela',   'rafaela@email.com',   'Jornalista',   'Avenida das Águas',   '321',   'Vila Nova',   'Curitiba',   '09876543',   'CASA',   'Próximo ao parque',   false,   'n/a',   'n/a',   true,   'Observações sobre Rafaela',   true,   NULL,   true,   CURRENT_DATE(),   CURRENT_DATE() );





-- ########################################################################################################################################################################################################################################################################




insert into tb_local (id, nome_local, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (1, 'Clínica Movel', 'Rua das Árvores', '189', 'Bairro Lindo', 'Diadema', '09981011', 'OUTRO', 'do lado da granja');
insert into tb_local (id, nome_local, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (2, 'Clínica Campanário', 'Rua do Campanário', '189', 'Bairro Campanário', 'Diadema-Campanário', '09981010', 'CASA', 'do lado da granja');
insert into tb_local (id, nome_local, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (3, 'Clínica Sítio Joaninha','Rua do Sítio Joaninha', '189', 'Bairro Sítio Joaninha', 'Diadema-Sítio Joaninha', '09981011', 'APARTAMENTO', 'do lado da feira');
insert into tb_local (id, nome_local, end_rua, end_numero, end_bairro,end_cidade, end_cep, end_tipo_residencia, end_observacao) values (4, 'Clínica Inamar', 'Rua do Inamar', '189', 'Bairro Inamar', 'Diadema-Inamar', '09981012', 'OUTRO', 'do lado da escola');


insert into tb_exame (id,paciente_id,nome_exame, medico_id,local_id, data_exame, valor,  atendente_id, observacao, situacao) values (1,1, 'Exame do pulmão', 1, 1, CURRENT_DATE(), 350, 1, 'observações', 1);
insert into tb_exame (id,paciente_id,nome_exame, medico_id,local_id, data_exame, valor,  atendente_id, observacao, situacao) values (2,2, 'Exame de vista', 2, 2, CURRENT_DATE(), 139, 2, 'observações', 1);
insert into tb_exame (id,paciente_id,nome_exame, medico_id,local_id, data_exame, valor,  atendente_id, observacao, situacao) values (3,3, 'Exame do coração', 3, 3, CURRENT_DATE(), 50, 3, 'observações', 1);

INSERT INTO tb_exame (id,data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (1,CURRENT_DATE(), 'Exame de exemplo', 'Observações sobre o exame', 100.00, 1, 1, true, 1, 1);

INSERT INTO tb_exame (id,data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (2,CURRENT_DATE(), 'Exame de exemplo', 'Observações sobre o exame', 100.00, 1, 1, true, 1, 1);

INSERT INTO tb_exame (id,data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (3,CURRENT_DATE(), 'Exame de exemplo', 'Observações sobre o exame', 100.00, 1, 1, true, 1, 1);

INSERT INTO cuidarapp_schema.tb_exame (id,data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (4,CURRENT_DATE(), 'Exame de exemplo', 'Observações sobre o exame', 100.00, 1, 1, true, 1, 1);

-- Inserts 2
INSERT INTO cuidarapp_schema.tb_exame (id, data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (5, CURRENT_DATE(), 'Exame de exemplo 2', 'Outras observações sobre o exame', 150.00, 2, 2, true, 2, 2);

INSERT INTO cuidarapp_schema.tb_exame (id, data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (6, CURRENT_DATE(), 'Exame de terceiro', 'Observações adicionais sobre o terceiro exame', 80.00, 1, 3, true, 3, 3);

INSERT  INTO cuidarapp_schema.tb_exame (id, data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (7, CURRENT_DATE(), 'Exame de teste', 'Observações sobre o exame de teste', 120.00, 2, 1, false, 4, 4);

INSERT  INTO cuidarapp_schema.tb_exame (id, data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (8, CURRENT_DATE(), 'Exame 123', 'Mais informações sobre o exame 123', 90.00, 3, 2, true, 5, 5);

INSERT  INTO cuidarapp_schema.tb_exame (id, data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (9, CURRENT_DATE(), 'Exame A', 'Observações sobre o exame A', 130.00, 3, 3, false, 6, 4);

INSERT INTO cuidarapp_schema.tb_exame (id, data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (10, CURRENT_DATE(), 'Exame B', 'Observações sobre o exame B', 110.00, 2, 1, true, 4, 7);

INSERT INTO cuidarapp_schema.tb_exame(id, data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (11, CURRENT_DATE(), 'Exame XPTO', 'Observações sobre o exame XPTO', 75.00, 1, 2, false, 2, 8);

INSERT INTO cuidarapp_schema.tb_exame (id, data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (12, CURRENT_DATE(), 'Exame YZ', 'Observações sobre o exame YZ', 95.00, 3, 3, true, 3, 9);

INSERT INTO cuidarapp_schema.tb_exame (id, data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (13, CURRENT_DATE(), 'Exame Final', 'Observações finais sobre o exame', 200.00, 2, 1, false, 3, 10);

INSERT INTO cuidarapp_schema.tb_exame (id, data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (14, CURRENT_DATE(), 'Exame Último', 'Últimas observações sobre o exame', 85.00, 1, 2, true, 4, 11);

INSERT INTO cuidarapp_schema.tb_exame (id, data_exame, nome_exame, observacao, valor, atendente_id, local_id, situacao, medico_id, paciente_id)
VALUES (15, CURRENT_DATE(), 'Exame odontológico', 'Novas observações sobre o exame', 82.00, 1, 2, true, 5, 11);



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

