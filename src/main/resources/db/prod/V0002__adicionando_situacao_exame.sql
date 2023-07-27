ALTER TABLE tb_exame ADD COLUMN situacao boolean DEFAULT true NOT NULL;
UPDATE tb_exame SET situacao = true;