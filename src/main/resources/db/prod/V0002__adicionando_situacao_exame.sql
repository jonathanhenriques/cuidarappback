ALTER TABLE tb_exame ADD COLUMN situacao boolean DEFAULT TRUE NOT NULL;
UPDATE tb_exame SET situacao = TRUE;