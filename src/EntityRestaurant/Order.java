package EntityRestaurant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<MenuItem> items;

    public Order(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void saveOrderToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\DELL\\Desktop\\CDAC\\Restaurant.txt", true))) {
            writer.write(customer.toString());
            writer.newLine();
            for (MenuItem item : items) {
                writer.write(item.toString());
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
        for (MenuItem item : items) {
            System.out.println(" - " + item);
        }
        System.out.println("Total: $" + calculateTotal());
    }
}

