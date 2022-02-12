CREATE TABLE account(
	 id BIGINT NOT NULL,
	 agency VARCHAR(4) NOT NULL,
	 account VARCHAR(6) NOT NULL,
	 balance DOUBLE PRECISION NOT NULL,
	 status BOOLEAN NOT NULL,
	 typeAccount VARCHAR(16) NOT NULL,
	 client_id BIGINT NOT NULL, 
	 CONSTRAINT account_pk PRIMARY KEY (id),
     FOREIGN KEY (client_id) REFERENCES client(id));