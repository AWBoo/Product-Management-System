// ProductManagement class managing an array of products
class ProductManagement {
    private static final int MAX_PRODUCTS = 100; // Maximum number of products

    private Product[] products;
    private int productCount;

    // Constructor
    public ProductManagement() {
        this.products = new Product[MAX_PRODUCTS];
        this.productCount = 0;
    }

    // Method to add a new product
    public void addProduct(String name, double price, int quantity) {
        if (productCount < MAX_PRODUCTS) {
            products[productCount++] = new Product(name, price, quantity);
            System.out.println("Product added successfully!");
        } else {
            System.out.println("Cannot add more products. Maximum limit reached.");
        }
    }

    // Method to edit an existing product
    public void editProduct(int productID, String newName, double newPrice, int newQuantity) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductID() == productID) {
                products[i].setName(newName);
                products[i].setPrice(newPrice);
                products[i].setQuantity(newQuantity);
                System.out.println("Product edited successfully!");
                return;
            }
        }
        System.out.println("Product not found with ID: " + productID);
    }

    // Method to remove a product
    public void removeProduct(int productID) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductID() == productID) {
                // Shift products to fill the gap
                for (int j = i; j < productCount - 1; j++) {
                    products[j] = products[j + 1];
                }
                productCount--;
                System.out.println("Product removed successfully!");
                return;
            }
        }
        System.out.println("Product not found with ID: " + productID);
    }

    // Method to view all products
    public void viewAllProducts() {
        if (productCount == 0) {
            System.out.println("No products available.");
        } else {
            for (int i = 0; i < productCount; i++) {
                products[i].displayProductInfo();
            }
        }
    }
}