CREATE TYPE emp_shift_enum AS ENUM ('Morning', 'Evening');
CREATE TYPE payment_method_enum AS ENUM ('Cash', 'Card');
CREATE type delivery_enum AS ENUM('Dine-in', 'Takeout', 'Delivery');

create table shop_owner.employee (
  emp_id SERIAL  PRIMARY KEY,
  emp_name VARCHAR(255) NOT NULL,
  emp_pos VARCHAR(255) NOT NULL,
  emp_shift emp_shift_enum,
  emp_phonenum VARCHAR(20),
  monthly_wage int NOT NULL
);

create table shop_owner.customer (
  cust_id SERIAL  PRIMARY KEY,
  cust_firstname varchar(10) NOT NULL,
  cust_lastname varchar(10) NOT NULL,
  cust_phonenum VARCHAR(20),
  payment_method payment_method_enum 
);

create table shop_owner.item (
  item_id SERIAL  PRIMARY KEY,
  item varchar(50)  NOT NULL ,
  item_cat varchar(50)  NOT NULL ,
  item_size varchar(20)  NOT NULL ,
  item_price decimal(7,2)  NOT NULL
);

create table shop_owner.address (
  add_id SERIAL  PRIMARY KEY,
  add_1 varchar(200)  NOT NULL ,
  add_2 varchar(200)  NULL ,
  add_city varchar(50)  NOT NULL ,
  add_zipcode varchar(20)  NOT NULL 
);

create table shop_owner.orders (
  id SERIAL PRIMARY KEY,
  emp_id int,
  order_id int,
  order_ts timestamp DEFAULT CURRENT_TIMESTAMP,
  cust_id int not null,
  item_id int not null,
  quantity int not null,
  total_price DECIMAL(10,2) not null,
  delivery delivery_enum,
  add_id int,
  foreign key (emp_id) references shop_owner.employee(emp_id),
  foreign key (cust_id) references shop_owner.customer(cust_id),
  foreign key (item_id) references shop_owner.item(item_id),
  foreign key (add_id) references shop_owner.address(add_id)
);