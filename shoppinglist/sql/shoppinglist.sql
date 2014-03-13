CREATE TABLE shopping_user(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	login VARCHAR(20) NOT NULL,
	password VARCHAR(8) NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT uc_login UNIQUE (login)
);

INSERT INTO shopping_user(login, password) VALUES('juan', '123');
INSERT INTO shopping_user(login, password) VALUES('maria', '456');

CREATE TABLE shopping_item(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	shopping_user_id INT NOT NULL,
	name VARCHAR(100) NOT NULL,
	status INT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (shopping_user_id) REFERENCES shopping_user(id)
);

INSERT INTO shopping_item(shopping_user_id, name, status)
VALUES(1, 'Harina', 0);
INSERT INTO shopping_item(shopping_user_id, name, status)
VALUES(2, 'Huevos', 0);

