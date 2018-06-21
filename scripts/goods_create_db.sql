create database "DB_Goods"
;

create sequence seq_goodlist
	increment by 50
;

create sequence seq_goods
	increment by 50
;

create sequence seq_materials
	increment by 50
;

create sequence seq_measures
	increment by 50
;

create sequence seq_ordermaterials
	increment by 50
;

create sequence seq_orders
	increment by 50
;

create sequence seq_role
	increment by 50
;

create sequence seq_user
	increment by 50
;

create sequence seq_works
	increment by 50
;

create table if not exists goods
(
	goodid integer not null
		constraint goods_pkey
			primary key,
	goodname varchar(100) not null
)
;

create table if not exists measures
(
	measureid integer not null
		constraint measures_pkey
			primary key,
	measurename varchar(50) not null
)
;

create table if not exists materials
(
	materialid integer not null
		constraint materials_pkey
			primary key,
	formula varchar(500),
	mandatory boolean not null,
	materialname varchar(100) not null,
	price double precision not null,
	goodid integer not null
		constraint fk1hf60ga19jdhqf307hgwrhlvy
			references goods,
	measureid integer not null
		constraint fks1330gt6ym9a28e056jlsoosy
			references measures
)
;

create table if not exists role
(
	role_id integer not null
		constraint role_pkey
			primary key,
	role varchar(255)
)
;

create table if not exists users
(
	userid integer not null
		constraint users_pkey
			primary key,
	enabled boolean not null,
	password varchar(60) not null,
	username varchar(50) not null
)
;

create table if not exists orders
(
	orderid integer not null
		constraint orders_pkey
			primary key,
	createdate timestamp,
	createby integer
		constraint fkoonstoiwpuhr3pchnp12uj0ni
			references users
)
;

create table if not exists goodslist
(
	goodslistid integer not null
		constraint goodslist_pkey
			primary key,
	count integer not null,
	depth double precision,
	height double precision,
	length double precision,
	width double precision,
	goodid integer
		constraint fk2bbkog2adyqvriloww9anwd0a
			references goods,
	orderid integer
		constraint fkljxiocl8sukxk46lclk5pev71
			references orders
)
;

create table if not exists ordermaterials
(
	ordermaterialsid integer not null
		constraint ordermaterials_pkey
			primary key,
	koefficient double precision not null,
	price double precision not null,
	total double precision not null,
	goodslistid integer
		constraint fkgo4woi94qhdy7dxuibc40mgn7
			references goodslist,
	materialid integer
		constraint fkj0l745rwp8ugdd1l2duss5bw8
			references materials
)
;

create table if not exists user_role
(
	user_id integer not null
		constraint fkj345gk1bovqvfame88rcx7yyx
			references users,
	role_id integer not null
		constraint fka68196081fvovjhkek5m97n3y
			references role,
	constraint user_role_pkey
		primary key (user_id, role_id)
)
;

create table if not exists works
(
	workid integer not null
		constraint works_pkey
			primary key,
	count integer not null,
	workname varchar(50) not null,
	goodid integer
		constraint fkji0rbclf5od2iuptjq89075j
			references goods
)
;