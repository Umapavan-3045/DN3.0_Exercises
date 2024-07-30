import java.util.*;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private int price;

    Product(int productId, String productName, int quantity, int price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    int getProductId() {
        return productId;
    }

    int getProductQuantity() {
        return quantity;
    }

    int getProductPrice() {
        return price;
    }

    String getProductName() {
        return productName;
    }

    void updateProductName(String newProductName) {
        this.productName = newProductName;
    }

    void updateProductQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    void updateProductPrice(int newPrice) {
        this.price = newPrice;
    }
}

public class InventoryManagement {
    static HashMap<Integer, Product> productList = new HashMap<>();

    public static void add(Product product) {
        productList.put(product.getProductId(), product);
    }

    public static void deleteProduct(int productId) {
        productList.remove(productId);
    }

    public static void printProductDetails(Product product) {
        System.out.println("Product ID: " + product.getProductId());
        System.out.println("Product Name: " + product.getProductName());
        System.out.println("Product Quantity: " + product.getProductQuantity());
        System.out.println("Product Price: " + product.getProductPrice());
        System.out.println();
    }

    public static void main(String[] args) {
        // Adding products
        Product product1 = new Product(1, "sample_product1", 25, 2500);
        add(product1);
        Product product2 = new Product(2, "sample_product2", 35, 3500);
        add(product2);

        // Printing all products
        System.out.println("Initial Products:");
        for (Product product : productList.values()) {
            printProductDetails(product);
        }

        // Updating product details
        product1.updateProductName("updated_product1");
        product1.updateProductQuantity(30);
        product1.updateProductPrice(2600);

        System.out.println("Products after update:");
        for (Product product : productList.values()) {
            printProductDetails(product);
        }

        // Deleting a product
        deleteProduct(2);

        System.out.println("Products after deletion:");
        for (Product product : productList.values()) {
            printProductDetails(product);
        }
    }
}
