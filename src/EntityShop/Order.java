package EntityShop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Order {
    private Customer customer;
    private List<Product> products;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void saveOrderToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\DELL\\Desktop\\CDAC\\Shop.txt", true))) {
            writer.write(customer.toString());
            writer.newLine();
            for (Product product : products) {
                writer.write(product.toString());
                writer.newLine();
            }
            writer.write("Total: $" + calculateTotal());
            writer.newLine();
            writer.write("-------------------------");
            writer.newLine();
            System.out.println("Order saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving order: " + e.getMessage());
        }
    }

    public void displayOrderDetails() {
        System.out.println("Order Details:");
        System.out.println(customer.toString());
        for (Product product : products) {
            System.out.println(" - " + product);
        }
        System.out.println("Total: $" + calculateTotal());
    }
}

