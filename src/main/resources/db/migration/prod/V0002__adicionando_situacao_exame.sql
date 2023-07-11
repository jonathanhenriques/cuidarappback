ALTER TABLE tb_exame add situacao tinyint(1) DEFAULT 1 not null;
UPDATE tb_exame set situacao = true;