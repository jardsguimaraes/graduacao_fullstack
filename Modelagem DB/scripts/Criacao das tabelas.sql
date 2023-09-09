CREATE TABLE Usuario (
    IdUsuario INTEGER PRIMARY KEY,
    login VARCHAR(20),
    senha VARCHAR(15)
);

CREATE TABLE Produto (
    idProduto INTEGER PRIMARY KEY,
    nome VARCHAR(70),
    quantidade INTEGER,
    precoVenda DECIMAL(7,2)
);

CREATE TABLE Pessoa (
    idPessoa INTEGER PRIMARY KEY,
    nome VARCHAR(70),
    logradouro VARCHAR(50),
    cidade VARCHAR(30),
    estado VARCHAR(2),
    telefone VARCHAR(15),
    email VARCHAR(50)
);

CREATE TABLE PessoaJuridica (
    cnpj VARCHAR(15),
    fk_Pessoa_idPessoa INTEGER PRIMARY KEY
);

CREATE TABLE PessoaFisica (
    cpf VARCHAR(11),
    fk_Pessoa_idPessoa INTEGER PRIMARY KEY
);

CREATE TABLE movimento (
    idMovimento INTEGER PRIMARY KEY,
    quantidade INTEGER,
    tipo CHAR,
    valorUnitario DECIMAL(7,2),
    fk_Produto_idPoduto INTEGER,
    fk_Usuario_IdUsuario INTEGER,
    fk_Pessoa_idPessoa INTEGER
);
 
ALTER TABLE PessoaJuridica ADD CONSTRAINT FK_PessoaJuridica_1
    FOREIGN KEY (fk_Pessoa_idPessoa)
    REFERENCES Pessoa (idPessoa)
    ON DELETE CASCADE;
 
ALTER TABLE PessoaFisica ADD CONSTRAINT FK_PessoaFisica_1
    FOREIGN KEY (fk_Pessoa_idPessoa)
    REFERENCES Pessoa (idPessoa)
    ON DELETE CASCADE;
 
ALTER TABLE movimento ADD CONSTRAINT FK_movimento_2
    FOREIGN KEY (fk_Produto_idPoduto)
    REFERENCES Produto (idProduto)
    ON DELETE CASCADE;
 
ALTER TABLE movimento ADD CONSTRAINT FK_movimento_3
    FOREIGN KEY (fk_Usuario_IdUsuario)
    REFERENCES Usuario (IdUsuario)
    ON DELETE CASCADE;
 
ALTER TABLE movimento ADD CONSTRAINT FK_movimento_4
    FOREIGN KEY (fk_Pessoa_idPessoa)
    REFERENCES Pessoa (idPessoa)
    ON DELETE CASCADE;