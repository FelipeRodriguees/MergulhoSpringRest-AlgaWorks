ALTER TABLE ocorrencia ADD CONSTRAINT fk_ocorrencia_entrega FOREIGN KEY(entrega_id) REFERENCES entrega (id);
