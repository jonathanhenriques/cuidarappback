ALTER TABLE tb_exame ADD situacao tinyint(1) DEFAULT 1 NOT NULL;
UPDATE tb_exame SET situacao = TRUE;