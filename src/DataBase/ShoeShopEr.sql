SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS purchases;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS shop;




/* Create Tables */

CREATE TABLE customers
(
	id bigint NOT NULL AUTO_INCREMENT,
	name varchar(60),
	phone varchar(20),
	profile_url varchar(200),
	PRIMARY KEY (id),
	UNIQUE (id)
);


CREATE TABLE products
(
	id int NOT NULL AUTO_INCREMENT,
	name varchar(300),
	price  double,
	size enum(LARGE,MEDUM,SMALL),
	desc varchar(300),
	shop_id bigint NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id),
	UNIQUE (shop_id)
);


CREATE TABLE purchases
(
	id bigint NOT NULL AUTO_INCREMENT,
	qty bigint NOT NULL,
	desc varchar(200),
	delivery_address varchar(100),
	delivery_date_time datetime,
	shop_id bigint NOT NULL,
	customer_id bigint NOT NULL,
	product_id int NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id),
	UNIQUE (qty),
	UNIQUE (shop_id),
	UNIQUE (customer_id),
	UNIQUE (product_id)
);


CREATE TABLE shop
(
	id bigint NOT NULL AUTO_INCREMENT,
	name varchar(60) NOT NULL,
	address varchar(200),
	phone varchar(40) NOT NULL,
	link varchar(300),
	PRIMARY KEY (id),
	UNIQUE (id)
);



/* Create Foreign Keys */

ALTER TABLE purchases
	ADD FOREIGN KEY (customer_id)
	REFERENCES customers (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE purchases
	ADD FOREIGN KEY (product_id)
	REFERENCES products (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE products
	ADD FOREIGN KEY (shop_id)
	REFERENCES shop (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE purchases
	ADD FOREIGN KEY (shop_id)
	REFERENCES shop (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



