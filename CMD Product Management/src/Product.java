// Product class representing a product with properties and methods
class Product {
    private static int idCounter = 1;

    private int productID;
    private String name;
    private double price;
    private int quantity;

    // Constructor
    public Product(String name, double price, int quantity) {
        this.productID = idCounter++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to display product information
    public void displayProductInfo() {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("------------------------------");
    }

    // Getter and Setter methods

    public int getProductID() {
        return productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


