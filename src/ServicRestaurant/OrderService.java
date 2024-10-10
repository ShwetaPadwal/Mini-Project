package ServicRestaurant;

import java.util.ArrayList;
import java.util.List;

import EntityRestaurant.*;
import ServicRestaurant.*;

public class OrderService {
    private List<Order> orders;

    public OrderService() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void displayAllOrders() {
        System.out.println("\n--- All Orders ---");
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }

    public void saveAllOrdersToFile(String filename) {
        for (Order order : orders) {
            order.saveOrderToFile(filename);
        }
    }
}

