CREATE TYPE emp_shift_enum AS ENUM ('Morning', 'Evening');
CREATE TYPE payment_method_enum AS ENUM ('Cash', 'Card');
CREATE type delivery_enum AS ENUM('Dine-in', 'Takeout', 'Delivery');

create table shop_owner.cs_employee (
  emp_pos VARCHAR(255) NOT NULL,
  emp_shift emp_shift_enum,
  emp_phonenum VARCHAR(20),
  monthly_wage int NOT null
) inherits (public.cs_user);
ALTER TABLE shop_owner.cs_employee ADD CONSTRAINT cs_employee_un UNIQUE (id);

create table shop_owner.cs_customer (
  cust_id SERIAL  PRIMARY KEY,
  cust_firstname varchar(10) NOT NULL,
  cust_lastname varchar(10) NOT NULL,
  cust_phonenum VARCHAR(20),
  payment_method payment_method_enum , 
  created_date timestamp,
  created_by varchar(225),
  updated_date timestamp,
  updated_by varchar(225),
  deleted_date timestamp,
  deleted_by varchar(225)
);

create table shop_owner.cs_item (
  item_id SERIAL  PRIMARY KEY,
  item varchar(50)  NOT NULL ,
  item_cat varchar(50)  NOT NULL ,
  item_size varchar(20)  NOT NULL ,
  item_price float4  NOT NULL, 
  created_date timestamp,
  created_by varchar(225),
  updated_date timestamp,
  updated_by varchar(225),
  deleted_date timestamp,
  deleted_by varchar(225)
);

create table shop_owner.cs_item_tag (
	item_tag_id SERIAL PRIMARY KEY,
  	name varchar(50)  NOT NULL 
  );
 
 
--create table shop_owner.cs_address (
--  add_id SERIAL  PRIMARY KEY,
--  add_1 varchar(200)  NOT NULL ,
--  add_2 varchar(200)  NULL ,
--  add_city varchar(50)  NOT NULL ,
--  add_zipcode varchar(20)  NOT NULL , 
--  created_date timestamp,
--  created_by varchar(225),
--  updated_date timestamp,
--  updated_by varchar(225),
--  deleted_date timestamp,
--  deleted_by varchar(225)
--);

create table shop_owner.cs_order (
  order_id SERIAL PRIMARY KEY,
  emp_id uuid not null,
  cust_id bigint,
  total_quantity int not null,
  total_price float4 not null,
  delivery delivery_enum,
  address varchar(225), 
  created_date timestamp,
  created_by varchar(225),
  updated_date timestamp,
  updated_by varchar(225),
  deleted_date timestamp,
  deleted_by varchar(225),
  foreign key (emp_id) references shop_owner.cs_employee(id),
  foreign key (cust_id) references shop_owner.cs_customer(cust_id)
);

create table shop_owner.cs_order_item_link (

order_id bigint REFERENCES shop_owner.cs_order(order_id),

item_id bigint REFERENCES shop_owner.cs_item(item_id));

create table shop_owner.cs_item_tag_link (

item_id bigint REFERENCES shop_owner.cs_item(item_id),

tag_id bigint REFERENCES shop_owner.cs_item_tag(item_tag_id));

create table shop_owner.cs_order_cust_link (

order_id bigint REFERENCES shop_owner.cs_order(order_id),

cust_id bigint REFERENCES shop_owner.cs_customer(cust_id) );


