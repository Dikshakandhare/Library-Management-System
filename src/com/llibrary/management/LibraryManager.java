package com.llibrary.management;

import java.sql.*;
import java.util.Scanner;

public class LibraryManager {
    private static final Connection conn = DatabaseConnection.getConnection();

    public static void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Book ID: ");
        String bookID = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Availability Status (Available/Checked Out): ");
        String status = scanner.nextLine();

        String query = "INSERT INTO books (book_id, title, author, genre, availability_status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, bookID);
            stmt.setString(2, title);
            stmt.setString(3, author);
            stmt.setString(4, genre);
            stmt.setString(5, status);
            stmt.executeUpdate();
            System.out.println("Book added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    public static void viewAllBooks() {
        String query = "SELECT * FROM books";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("Book ID: " + rs.getString("book_id") + ", Title: " + rs.getString("title") + 
                    ", Author: " + rs.getString("author") + ", Genre: " + rs.getString("genre") + 
                    ", Status: " + rs.getString("availability_status"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching books: " + e.getMessage());
        }
    }

    public static void searchBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Book ID or Title: ");
        String input = scanner.nextLine();
        
        String query = "SELECT * FROM books WHERE book_id = ? OR title LIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, input);
            stmt.setString(2, "%" + input + "%");
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("Book Found: ");
                System.out.println("Book ID: " + rs.getString("book_id") + ", Title: " + rs.getString("title") + 
                    ", Author: " + rs.getString("author") + ", Genre: " + rs.getString("genre") + 
                    ", Status: " + rs.getString("availability_status"));
            } else {
                System.out.println("Book not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error searching for book: " + e.getMessage());
        }
    }

    public static void updateBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Book ID to update: ");
        String bookID = scanner.nextLine();
        
        System.out.println("1. Update Title");
        System.out.println("2. Update Author");
        System.out.println("3. Update Genre");
        System.out.println("4. Update Availability Status");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        
        String column = "";
        switch (choice) {
            case 1: column = "title"; break;
            case 2: column = "author"; break;
            case 3: column = "genre"; break;
            case 4: column = "availability_status"; break;
            default: System.out.println("Invalid choice"); return;
        }
        
        System.out.print("Enter new value: ");
        String newValue = scanner.nextLine();
        
        String query = "UPDATE books SET " + column + " = ? WHERE book_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newValue);
            stmt.setString(2, bookID);
            int rowsUpdated = stmt.executeUpdate();
            
            if (rowsUpdated > 0) {
                System.out.println("Book details updated successfully!");
            } else {
                System.out.println("Book not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating book: " + e.getMessage());
        }
    }

    public static void deleteBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Book ID to delete: ");
        String bookID = scanner.nextLine();
        
        String query = "DELETE FROM books WHERE book_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, bookID);
            int rowsDeleted = stmt.executeUpdate();
            
            if (rowsDeleted > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting book: " + e.getMessage());
        }
    }
}
