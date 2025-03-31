UPDATE medicos SET ativo = 1 WHERE ativo IS NULL;
ALTER TABLE medicos ALTER COLUMN ativo tinyint NOT NULL;