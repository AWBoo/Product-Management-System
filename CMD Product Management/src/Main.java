import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManagement productManagement = new ProductManagement();
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            try {
                System.out.println("Product Management System");
                System.out.println("1. Add Product");
                System.out.println("2. Edit Product");
                System.out.println("3. Remove Product");
                System.out.println("4. View All Products");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");

                option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (option) {
                    case 1 -> addProduct(scanner, productManagement);
                    case 2 -> editProduct(scanner, productManagement);
                    case 3 -> removeProduct(scanner, productManagement);
                    case 4 -> productManagement.viewAllProducts();
                    case 0 -> System.out.println("Exiting the program. Thank you!");
                    default -> System.out.println("Invalid option. Please enter a valid option.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
                option = -1; // Set option to an invalid value to continue the loop
            }

        } while (option != 0);

        scanner.close();
    }

    private static void addProduct(Scanner scanner, ProductManagement productManagement) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = getValidDoubleInput(scanner);
        System.out.print("Enter product quantity: ");
        int quantity = getValidIntInput(scanner);
        productManagement.addProduct(name, price, quantity);
    }

    private static void editProduct(Scanner scanner, ProductManagement productManagement) {
        System.out.print("Enter product ID to edit: ");
        int editProductID = getValidIntInput(scanner);
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter new product name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new product price: ");
        double newPrice = getValidDoubleInput(scanner);
        System.out.print("Enter new product quantity: ");
        int newQuantity = getValidIntInput(scanner);
        productManagement.editProduct(editProductID, newName, newPrice, newQuantity);
    }

    private static void removeProduct(Scanner scanner, ProductManagement productManagement) {
        System.out.print("Enter product ID to remove: ");
        int removeProductID = getValidIntInput(scanner);
        productManagement.removeProduct(removeProductID);
    }

    private static int getValidIntInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    private static double getValidDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }
}


