DROP DATABASE IF EXISTS for_best;
CREATE DATABASE IF NOT EXISTS for_best;
USE for_best;


CREATE TABLE usuarios(
	codigo INT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255),
	sobrenome VARCHAR(255),
	idade INT(3),
	data_nascimento DATE,
	email VARCHAR(255),
	razao_social VARCHAR(255),
	cnpj VARCHAR(25),
	cpf VARCHAR(14),
	cep VARCHAR(9), 
	numero INT(5),
	logradouro VARCHAR(255), 
	estado CHAR(2),
	cidade VARCHAR(25),
	bairro VARCHAR(25),
	senha VARCHAR(255),
	celular VARCHAR(15),
	genero CHAR(1),
	biografia TEXT,
	foto BLOB,
	galeria BLOB,
	url_facebook VARCHAR(255),
	url_linkedin VARCHAR(255),
	url_twitter VARCHAR(255),
	url_instagram VARCHAR(255),
  numero_local INT(20)
);

CREATE TABLE tags(
	codigo INT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255)
);

CREATE TABLE amigos(
	codigo INT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo_usuario_solicitante INT(20),
	codigo_usuario_solicitado INT(20),
	data_criacao DATE,
	confirmado BOOLEAN,
	FOREIGN KEY (codigo_usuario_solicitante) REFERENCES usuarios(codigo),
	FOREIGN KEY (codigo_usuario_solicitado) REFERENCES usuarios(codigo)
);

CREATE TABLE posts(
	codigo INT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo_usuario INT(20),
	descricao TEXT,
	titulo VARCHAR(255),
	data_criacao DATE,
	data_evento DATE,
	status VARCHAR(25),
	apoios INT(200),

	FOREIGN KEY (codigo_usuario) REFERENCES usuarios(codigo)
);

CREATE TABLE doacoes(
	codigo INT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo_post INT(20),
	valor FLOAT,
	url_forma_pagamento VARCHAR(255),

	FOREIGN KEY (codigo_post) REFERENCES posts(codigo)
);

CREATE TABLE posts_tarefas(
	codigo INT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo_post INT(20),
	codigo_usuario INT(20),
	titulo VARCHAR(255),
	status VARCHAR(25),
	descricao TEXT,

	FOREIGN KEY (codigo_post) REFERENCES posts(codigo),	
	FOREIGN KEY (codigo_usuario) REFERENCES usuarios(codigo)
);

CREATE TABLE posts_tags(
	codigo INT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo_post INT(20),
	codigo_tag INT(20),

	FOREIGN KEY (codigo_post) REFERENCES posts(codigo),
	FOREIGN KEY (codigo_tag) REFERENCES tags(codigo)	
);

CREATE TABLE posts_imagens(
	codigo INT(20) PRIMARY KEY AUTO_INCREMENT, 
	codigo_post INT(20),
	imagem BLOB,

	FOREIGN KEY (codigo_post) REFERENCES posts(codigo)	
);

CREATE TABLE posts_videos(
	codigo INT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo_post INT(20),
	video BLOB,
    
	FOREIGN KEY (codigo_post) REFERENCES posts(codigo)	
);

CREATE TABLE prestacao_contas(
  codigo INT(20) PRIMARY KEY AUTO_INCREMENT,
  codigo_post INT(20),
  gastos DOUBLE,
  recebidos DOUBLE,
  foto BLOB,
  video BLOB,
  texto TEXT,
    
	FOREIGN KEY (codigo_post) REFERENCES posts(codigo)
);