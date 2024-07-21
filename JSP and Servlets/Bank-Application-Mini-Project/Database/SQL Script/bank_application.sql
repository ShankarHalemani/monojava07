CREATE DATABASE bank_application;
USE bank_application;

DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer
(
    custid INT AUTO_INCREMENT PRIMARY KEY,
    fname VARCHAR(50) NOT NULL,
    lname VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    pass VARCHAR(100) NOT NULL
) AUTO_INCREMENT = 10000;  -- Start custid from 10000

CREATE TABLE accounts
(
    account_number INT AUTO_INCREMENT PRIMARY KEY,
    custid INT NOT NULL UNIQUE,
    balance DECIMAL(15, 2) DEFAULT 500,
    FOREIGN KEY (custid) REFERENCES customer(custid)
) AUTO_INCREMENT = 50000;  -- Start account_number from 50000

CREATE TABLE transactions
(
    tnumber INT AUTO_INCREMENT PRIMARY KEY,
    sender_account_number INT NOT NULL,
    receiver_account_number INT NOT NULL,
    date_of_transaction DATETIME DEFAULT CURRENT_TIMESTAMP,
    transaction_type VARCHAR(20),
    transaction_amount DECIMAL(15, 2),
    FOREIGN KEY (sender_account_number) REFERENCES accounts(account_number),
    FOREIGN KEY (receiver_account_number) REFERENCES accounts(account_number)
) AUTO_INCREMENT = 80000;  -- Start tnumber from 80000


-- Insert sample data into customer table
INSERT INTO customer (fname, lname, email, pass) VALUES
('John', 'Doe', 'john.doe@example.com', 'password123'),
('Jane', 'Smith', 'jane.smith@example.com', 'password456'),
('Michael', 'Johnson', 'michael.johnson@example.com', 'password789'),
('Emily', 'Davis', 'emily.davis@example.com', 'password321'),
('David', 'Wilson', 'david.wilson@example.com', 'password654'),
('Sarah', 'Brown', 'sarah.brown@example.com', 'password987'),
('James', 'Taylor', 'james.taylor@example.com', 'password111'),
('Laura', 'Lee', 'laura.lee@example.com', 'password222'),
('Daniel', 'Walker', 'daniel.walker@example.com', 'password333'),
('Anna', 'Robinson', 'anna.robinson@example.com', 'password444');


-- Insert sample data into accounts table
INSERT INTO accounts (custid, balance) VALUES
(10000, 100000.00),  -- John Doe
(10001, 2000.00),  -- Jane Smith
(10002, 1500.00),  -- Michael Johnson
(10003, 2500.00),  -- Emily Davis
(10004, 3000.00),  -- David Wilson
(10005, 3500.00),  -- Sarah Brown
(10006, 4000.00),  -- James Taylor
(10007, 4500.00),  -- Laura Lee
(10008, 5000.00),  -- Daniel Walker
(10009, 5500.00);  -- Anna Robinson


INSERT INTO transactions (sender_account_number, receiver_account_number, date_of_transaction, transaction_type, transaction_amount) VALUES
(50000, 50001, '2024-07-18 10:15:00', 'transfer', 100.00),  -- John to Jane
(50002, 50000, '2024-07-19 11:30:00', 'transfer', 200.00),  -- Michael to John
(50001, 50003, '2024-07-20 12:45:00', 'transfer', 150.00),  -- Jane to Emily
(50004, 50005, '2024-07-21 14:00:00', 'transfer', 300.00),  -- David to Sarah
(50006, 50007, '2024-07-22 15:15:00', 'transfer', 400.00),  -- James to Laura
(50008, 50009, '2024-07-23 16:30:00', 'transfer', 500.00),  -- Daniel to Anna
(50003, 50006, '2024-07-24 17:45:00', 'transfer', 250.00),  -- Emily to James
(50007, 50002, '2024-07-25 19:00:00', 'transfer', 350.00),  -- Laura to Michael
(50005, 50004, '2024-07-26 20:15:00', 'transfer', 450.00),  -- Sarah to David
(50009, 50008, '2024-07-27 21:30:00', 'transfer', 550.00);  -- Anna to Daniel
