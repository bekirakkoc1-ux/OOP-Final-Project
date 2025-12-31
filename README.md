# Inventory Management System (OOP Final Project)

This project is a Java-based application designed to demonstrate Object-Oriented Programming (OOP) principles. It simulates a store inventory system where users can manage products, track stock levels, and handle perishable items.

## Project Description
The system interacts with the user through a console interface. It allows store managers to:
- Add new products to the inventory.
- Remove existing products using their ID.
- Monitor stock levels and receive warnings for low stock.
- Load initial product data from a text file (products.txt).
- Manage perishable products (with expiration dates) using inheritance.

## Technical Details & OOP Concepts
This project implements the following concepts:

* Java SE: Used as the main programming language.
* Encapsulation: Variables in the Product class are private and accessed via getter/setter methods to ensure data security.
* Inheritance: The PerishableProduct class extends the Product class to include expiration date features without rewriting code.
* Polymorphism: The Inventory class uses the List interface to manage products, allowing flexibility in implementation.
* File I/O: Product data is read from an external file using BufferedReader for dynamic data loading.
* JUnit Testing: Unit tests are included to verify the functionality of main classes.

## How to Run the Project
1. Open the project in Eclipse.
2. Make sure the "products.txt" file is in the main project folder.
3. Navigate to "src/inventory" and run the "Main.java" file.
4. Follow the menu options in the console.

## Testing
To verify the system logic:
1. Right-click on the "tests" package.
2. Select "Run As > JUnit Test".
3. Check the results bar (Green indicates success).

## Known Issues
* Input validation is basic. Entering text instead of numbers might crash the app.