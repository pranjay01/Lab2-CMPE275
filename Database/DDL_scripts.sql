DROP DATABASE IF EXISTS CMPE275_LAB2;

CREATE DATABASE CMPE275_LAB2;

USE CMPE275_LAB2;

create table PLAYER( 
id INT NOT NULL AUTO_INCREMENT, 
firstname VARCHAR(40) NOT NULL, 
lastname VARCHAR(40) NOT NULL, 
email VARCHAR(40) NOT NULL, 
description VARCHAR(100),
sponsorid INT, 
PRIMARY KEY ( id ) ); 

create table SPONSOR( 
id INT NOT NULL AUTO_INCREMENT, 
name VARCHAR(40) NOT NULL, 
description VARCHAR(100), 
street VARCHAR(40), 
city VARCHAR(40), 
state VARCHAR(40), 
zip VARCHAR(40),
PRIMARY KEY ( id )); 

create table OPPONENTS(
id INT NOT NULL AUTO_INCREMENT, 
player1 INT NOT NULL,
player2 INT NOT NULL,
PRIMARY KEY ( id )); 