CREATE TABLE IF NOT EXISTS financeiro.gastos (
    id SERIAL PRIMARY KEY,
    valor DECIMAL(10,2) NOT NULL,
    descricao TEXT,
    data TIMESTAMP,
    categoria TEXT NOT NULL
);
