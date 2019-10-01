DROP TABLE users;

CREATE TABLE users (
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	email VARCHAR(255) NOT NULL,
	password VARCHAR(50) NOT NULL,
	name VARCHAR(50) NOT NULL,
	age INTEGER NOT NULL,
	CONSTRAINT primary_key PRIMARY KEY(id),
	CONSTRAINT unique_email UNIQUE(email)
)