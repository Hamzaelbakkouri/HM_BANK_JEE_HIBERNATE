drop table IF EXISTS creditrequests;
drop table IF EXISTS clients;
drop table IF EXISTS employees;
drop table IF EXISTS persons;
drop table IF EXISTS agencies;
drop table IF EXISTS statehistory;

create table persons
(
    id          serial primary key,
    firstName   varchar(50),
    lastName    varchar(50),
    birthDate date,
    phoneNumber varchar(20)
);

CREATE TABLE clients
(
    code   varchar(100) primary key,
    address varchar(100)
)inherits (persons);

create table employees
(
    registrationNbr varchar(100) primary key ,
    recruitmentDate     date,
    email              varchar(100)
)inherits (persons);

create table agencies(
                         code        varchar(100) primary key,
                         name        varchar(100),
                         address    varchar(100),
                         phoneNumber varchar(100)
);

create type "state" as enum ('pending','accepted','refused');

create table creditrequests(
                               nbr  serial primary key,
                               agency varchar(100)  references agencies (code),
                               client varchar(100)  references clients (code),
                               amount double precision,
                               monthDuration int,
                               monthlyPayment double precision,
                               state  state
);

create table statehistory(
    nbr serial primary key,
    creditRequest int references creditrequests (nbr) ,
    state state
)
