DROP DATABASE IF EXISTS vm_project;
CREATE DATABASE vm_project;
USE vm_project;

-- Users table
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    no VARCHAR(20) UNIQUE NULL, 
    name VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    age INT NULL,
    sex INT NULL,
    phone VARCHAR(20),
    role_id INT NULL comment '0-Superadmin, 1-Admin, 2-Member',
    is_valid varchar(4) default 'Y' NULL
);