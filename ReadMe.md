# Product Inventory Management System (JDBC Integration)

## Objective

The objective of this project is to integrate a Java application with a MySQL database using JDBC. The project demonstrates database connectivity, CRUD operations, PreparedStatement usage, DAO design pattern, exception handling, and resource management.

---

## Features Implemented

* Create Product Table
* Insert Product
* View All Products
* Search Product by ID
* Update Product Price
* Update Product Quantity
* Delete Product
* JDBC Database Connectivity
* DAO (Data Access Object) Pattern
* PreparedStatement for SQL Injection Prevention
* Try-With-Resources for Resource Management
* SQLException Handling with Meaningful Messages

---

## Technologies Used

* Java 17
* JDBC
* MySQL 8.x
* IntelliJ IDEA
* MySQL Workbench

---

## Project Structure

src/
└── com/JDBC_Integration/
├── Main.java
├── Product.java
├── ProductDAO.java
└── DataBaseConnection.java

schema.sql
README.md

---

## Database Configuration

Database Name:

inventry_db

Update the following values in DataBaseConnection.java:

URL = jdbc:mysql://localhost:3306/inventry_db

USER = root

PASSWORD = database Passward

---

## Steps to Compile and Run

1. Install MySQL Server.
2. Create the database using schema.sql.
3. Add MySQL JDBC Driver (mysql-connector-j).
4. Open the project in IntelliJ IDEA.
5. Configure database credentials.
6. Run Main.java.
7. Use the menu to perform CRUD operations.

---

## Sample Input and Output

### Insert Product

Input:

Product Name: Laptop

Price: 55000

Quantity: 10

Category: Electronics

Output:

Product Inserted Successfully

---

### View Products

Output:

---

ID : 1
Name : Laptop
Category : Electronics
Price : 55000
Quantity : 10
-------------

---

### Update Product Price

Input:

Product ID: 1

New Price: 60000

Output:

Product Updated Successfully

---

### Delete Product

Input:

Product ID: 1

Output:

Product Deleted Successfully

---

## Exception Handling

The application handles SQLExceptions using meaningful error messages such as:

* Error creating table
* Error inserting product
* Error fetching products
* Error searching product
* Error updating product price
* Error updating product quantity
* Error deleting product

---

## Author

Jitesh Agrawal
