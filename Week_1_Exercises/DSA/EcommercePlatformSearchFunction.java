import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Product {
    private int productId;
    private String productName;
    private String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }
}

public class EcommercePlatformSearchFunction {

    private static List<Product> productList = new ArrayList<>();

    public static void addProduct(Product product) {
        productList.add(product);
    }

    public static Product linearSearch(int productId) {
        for (Product product : productList) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(int productId) {
        int left = 0;
        int right = productList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = productList.get(mid);
            if (midProduct.getProductId() == productId) {
                return midProduct;
            } else if (midProduct.getProductId() < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product product1 = new Product(1, "SampleProduct1", "SampleCategory1");
        Product product2 = new Product(2, "SampleProduct2", "SampleCategory2");
        Product product3 = new Product(3, "SampleProduct3", "SampleCategory3");

        addProduct(product1);
        addProduct(product2);
        addProduct(product3);

        System.out.println("Using Linear Search:");
        Product foundProduct = linearSearch(2);
        if (foundProduct != null) {
            System.out.println("Product found: " + foundProduct.getProductName() + " in category " + foundProduct.getCategory());
        } else {
            System.out.println("Product not found");
        }

        Collections.sort(productList, Comparator.comparingInt(Product::getProductId));

        System.out.println("\nUsing Binary Search:");
        foundProduct = binarySearch(2);
        if (foundProduct != null) {
            System.out.println("Product found: " + foundProduct.getProductName() + " in category " + foundProduct.getCategory());
        } else {
            System.out.println("Product not found");
        }
    }
}
