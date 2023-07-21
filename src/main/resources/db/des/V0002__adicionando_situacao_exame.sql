ALTER TABLE cuidarapp_schema.tb_exame ADD COLUMN situacao boolean DEFAULT true NOT NULL;
UPDATE cuidarapp_schema.tb_exame SET situacao = true;
