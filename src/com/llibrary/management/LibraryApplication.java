package com.llibrary.management;

import java.util.Scanner;

public class LibraryApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    LibraryManager.addBook();
                    break;
                case 2:
                    LibraryManager.viewAllBooks();
                    break;
                case 3:
                    LibraryManager.searchBook();
                    break;
                case 4:
                    LibraryManager.updateBook();
                    break;
                case 5:
                    LibraryManager.deleteBook();
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
