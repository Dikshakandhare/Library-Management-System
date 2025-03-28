# 📚 Library Management System

## **📌 Project Overview**
A simple **Java-based Library Management System** that allows librarians to manage books efficiently.

## **🔧 Features**
- ✅ Add a new book
- ✅ View all books
- ✅ Search for a book (by ID or Title)
- ✅ Update book details (Title, Author, Genre, Availability)
- ✅ Delete a book from the catalog
- ✅ Exit system

## **💻 Setup & Run Instructions**
### **Prerequisites**
- Install [Java JDK](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- Install [MySQL](https://dev.mysql.com/downloads/)
- Install [Eclipse](https://www.eclipse.org/downloads/)

### **Database Setup**
1. Open MySQL and create a database:
   CREATE DATABASE LibraryDB;
2. Select the database:
USE LibraryDB;
3. Create the books table:
   CREATE TABLE books (
    book_id VARCHAR(50) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    genre VARCHAR(100),
    availability_status VARCHAR(20) CHECK (availability_status IN ('Available', 'Checked Out'))
);
4. Add sample data:
   INSERT INTO books (book_id, title, author, genre, availability_status) VALUES
('B001', 'Java Programming', 'James Gosling', 'Programming', 'Available'),
('B002', 'Python for Beginners', 'Guido van Rossum', 'Programming', 'Available'),
('B003', 'Database Management Systems', 'Raghu Ramakrishnan', 'Database', 'Checked Out');

🚀 How to Run the Project
Clone the repository:
1. git clone https://github.com/Dikshakandhare/Library-Management-System.git
2. Open the project in Eclipse.
3. Configure MySQL connection in DatabaseConnection.java.
4. Compile and run LibraryApplication.java.



---

## ** Reflect on Challenges & Improvements**
1️⃣ **Challenges Faced**  
- Setting up MySQL database connection.  
- Handling **git push errors** and permission issues.  

2️⃣ **Improvements**  
- Implement a **GUI version** using Java Swing.  
- Add a **login system** for admins and users.  
- Improve **error handling** and validations.  

---



