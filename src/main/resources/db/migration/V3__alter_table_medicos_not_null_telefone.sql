UPDATE medicos SET telefone = '00000000000' WHERE telefone IS NULL;
ALTER TABLE medicos ALTER COLUMN telefone VARCHAR(20) NOT NULL;