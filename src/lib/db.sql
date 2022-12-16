CREATE DATABASE gerenciamentodocumentos;
USE gerenciamentodocumentos;

/* Tabela de usuários */
CREATE TABLE users (
	id int auto_increment not null,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    type int,
    created_at timestamp default now(),
    updated_at timestamp default now(),
    deleted_at timestamp null,
    primary key(id)
) ENGINE = InnoDB DEFAULT CHARSET=UTF8;

/* Tabela de templates de documentos */
CREATE TABLE templates (
	id int auto_increment not null,
    name varchar(255),
    descript text,
    created_by int not null,
    created_at timestamp default now(),
    updated_at timestamp default now(),
    deleted_at timestamp null,
    primary key(id),
    foreign key(created_by) references users(id)
) ENGINE = InnoDB DEFAULT CHARSET=UTF8;

/* Tabela de documentos */
CREATE TABLE documents (
	id int auto_increment not null,
    file text not null,
    template_id int not null,
    responsible_id int not null,
    created_at timestamp default now(),
    updated_at timestamp default now(),
    deleted_at timestamp null,
    primary key(id),
    foreign key(template_id) references templates(id),
    foreign key(responsible_id) references users(id)
) ENGINE = InnoDB DEFAULT CHARSET=UTF8;

/* Tabela relacional entre documentos e usuarios */
CREATE TABLE documents_users (
    id INT AUTO_INCREMENT NOT NULL,
    document_id INT NOT NULL,
    recipient_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (document_id)
        REFERENCES documents (id),
    FOREIGN KEY (recipient_id)
        REFERENCES users (id)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;