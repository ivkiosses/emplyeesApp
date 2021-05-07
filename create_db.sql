--CREATE DATABASE IF NOT EXISTS employees with owner employess;
--use employees;

CREATE EXTENSION postgis;

create table IF NOT EXISTS employee
(
 EMPLOYEE_ID BIGINT,
 FIRST_NAME VARCHAR(255) NOT NULL,
 LAST_NAME VARCHAR(255) NOT NULL,
 EMAIL VARCHAR(255) NOT NULL,
 ADDRESS VARCHAR(255) NOT NULL,
 MOBILE VARCHAR(255) NOT NULL,
 PRIMARY KEY (EMPLOYEE_ID),
);