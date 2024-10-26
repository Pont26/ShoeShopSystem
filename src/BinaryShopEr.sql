
/* Drop Tables */

DROP TABLE IF EXISTS purchases;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS shoes;
DROP TABLE IF EXISTS shop;




/* Create Tables */

CREATE TABLE customers
(
	customer_id int NOT NULL CONSTRAINT id UNIQUE id,
	name varchar(255) NOT NULL,
	email varchar(255),
	phone varchar(20) NOT NULL,
	address varchar(255) NOT NULL,
	PRIMARY KEY (customer_id)
) WITHOUT OIDS;


CREATE TABLE purchases
(
	purchase_id  NOT NULL CONSTRAINT id UNIQUE id,
	customer_id int NOT NULL CONSTRAINT id UNIQUE id,
	shoe_id int NOT NULL CONSTRAINT id UNIQUE id,
	qty int NOT NULL,
	total_price numeric(10,2) NOT NULL,
	shop_id  NOT NULL CONSTRAINT id UNIQUE id,
	PRIMARY KEY (purchase_id)
) WITHOUT OIDS;


CREATE TABLE shoes
(
	shoe_id int NOT NULL CONSTRAINT id UNIQUE id,
	name varchar(255) NOT NULL,
	size numeric(5,2) NOT NULL,
	price numeric(10,2) NOT NULL,
	shop_id  NOT NULL CONSTRAINT id UNIQUE id,
	PRIMARY KEY (shoe_id)
) WITHOUT OIDS;


CREATE TABLE shop
(
	shop_id  NOT NULL CONSTRAINT id UNIQUE id,
	name varchar(50) NOT NULL,
	phone varchar(20) NOT NULL,
	email varchar(30),
	address varchar(255) NOT NULL,
	PRIMARY KEY (shop_id)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE purchases
	ADD FOREIGN KEY (customer_id)
	REFERENCES customers (customer_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE purchases
	ADD FOREIGN KEY (shoe_id)
	REFERENCES shoes (shoe_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE purchases
	ADD FOREIGN KEY (shop_id)
	REFERENCES shop (shop_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE shoes
	ADD FOREIGN KEY (shop_id)
	REFERENCES shop (shop_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



