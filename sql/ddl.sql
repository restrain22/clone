-- member table
drop table if exists member CASCADE;
create table member
(
seqId bigint generated by default as identity,
memberId varchar(255),
name varchar(255),
password varchar(255),
gender varchar(255),
phoneNumber varchar(255),
email varchar(255),
address varchar(255),
birth varchar(255),
type varchar(255),
--use varchar(3), 추가 예정
primary key (seqId)
);


-- category table
drop table if exists category CASCADE;
create table category
(
categoryId bigint generated by default as identity,
categoryDescription varchar(255),
primary key (categoryId)
);


-- payment table
drop table if exists payment CASCADE;
create table payment
(
paymentId bigint generated by default as identity,
memberId bigint,
products --arraylist객체
address varchar(255),
shipStatus varchar(255),
totalPrice varchar(255),
phoneNumber varchar(255),
orderTime Date,
primary key (categoryId)
);


-- product table
drop table if exists product CASCADE;
create table product
(
product_Id bigint generated by default as identity,
category_Id bigint,
product_Name varchar(255),
price int,
product_Owner_Id varchar(255),
stock int,
register_Date Date,
product_Info varchar(255),
primary key (product_Id)
);