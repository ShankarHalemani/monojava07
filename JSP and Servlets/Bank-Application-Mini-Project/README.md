# Bank MVC Application

This is a Java-based MVC (Model-View-Controller) application for managing banking operations. The application allows users to add new customers, create bank accounts, and make transactions. It uses MySQL as the database.

## Features

- Add new customers
- Create new bank accounts
- Transfer funds between accounts
- View customer details
- Update customer profiles

## Technologies Used

- Java
- JSP
- Servlets
- MySQL
- Apache Tomcat
- JDBC
- Bootstrap for UI

## Prerequisites

- JDK 8 or higher
- Apache Tomcat 9 or higher
- MySQL 5.7 or higher
- MySQL Workbench (optional)
- IntelliJ IDEA (or any preferred IDE)

## Setup

### Database Setup

1. Install MySQL and MySQL Workbench.
2. Create a database named `bank_application`.
3. Create the required tables by executing the following SQL commands:

    ```sql
    CREATE TABLE customer (
        custid INT AUTO_INCREMENT PRIMARY KEY,
        fname VARCHAR(50),
        lname VARCHAR(50),
        email VARCHAR(100) UNIQUE,
        pass VARCHAR(100)
    );

    CREATE TABLE accounts (
        account_number INT AUTO_INCREMENT PRIMARY KEY,
        custid INT,
        balance DECIMAL(10, 2),
        FOREIGN KEY (custid) REFERENCES customer(custid)
    );

    CREATE TABLE transactions (
        tnumber INT AUTO_INCREMENT PRIMARY KEY,
        sender_account_number INT,
        receiver_account_number INT,
        date_of_transaction DATE,
        transaction_type VARCHAR(50),
        transaction_amount DECIMAL(10, 2),
        FOREIGN KEY (sender_account_number) REFERENCES accounts(account_number),
        FOREIGN KEY (receiver_account_number) REFERENCES accounts(account_number)
    );
    ```

4. Insert sample data into the tables if needed.

### Project Setup

1. Clone the repository:

    ```bash
    git clone https://github.com/ShankarHalemani/monojava07/tree/main/JSP%20and%20Servlets/Bank-Application-Mini-Project
    ```

2. Open the project in your preferred IDE (e.g., IntelliJ IDEA).

3. Configure the MySQL DataSource in `context.xml`:

    ```xml
    <Context>
        <Resource name="jdbc/bank_application"
                  auth="Container"
                  type="javax.sql.DataSource"
                  maxTotal="100"
                  maxIdle="30"
                  maxWaitMillis="10000"
                  username="your_mysql_username"
                  password="your_mysql_password"
                  driverClassName="com.mysql.cj.jdbc.Driver"
                  url="jdbc:mysql://localhost:3306/bank_application?useSSL=false"/>
    </Context>
    ```

4. Build the project and deploy it to Apache Tomcat.

### Running the Application

1. Start the Apache Tomcat server.
2. Access the application by navigating to `http://localhost:8080/bank-mvc-application/login.jsp` in your web browser.

## Usage

### Login

1. Open `http://localhost:8080/bank-mvc-application/login.jsp`.
2. Enter your email and password to log in.

### Add New Customer

1. Navigate to the "Add New Customer" page.
2. Fill in the required details and submit the form.
3. If the customer already exists, a message will be displayed. Otherwise, the customer will be added successfully.

### Create New Bank Account

1. Navigate to the "Add New Account" page.
2. Search for the customer by ID.
3. If the customer exists, click "Generate Account Number" to create a new account.
4. If the account already exists, a message will be displayed. Otherwise, the account will be created successfully.

### Make a Transaction

1. Navigate to the "New Transaction" page.
2. Enter the receiver's account number and the transfer amount.
3. Submit the form.
4. If the transaction is successful, a message will be displayed. If not, an error message will be shown.
