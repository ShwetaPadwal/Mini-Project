package Test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import EntityShop.*;
import ServiceShop.*;

public class TestShop {
	    public static void main(String[] args) {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        OrderService orderService = new OrderService();

	        try {
	            // Ask how many orders to create
	            System.out.print("How many orders do you want to create? ");
	            int numberOfOrders = Integer.parseInt(reader.readLine());

	            for (int i = 0; i < numberOfOrders; i++) {
	                System.out.println("\n--- Order " + (i + 1) + " ---");

	                // Get customer details
	                System.out.print("Enter customer name: ");
	                String customerName = reader.readLine();
	                System.out.print("Enter customer contact: ");
	                String customerContact = reader.readLine();
	                Customer customer = new Customer(customerName, customerContact);

	                // Create order
	                Order order = new Order(customer);

	                // Add products to the order
	                while (true) {
	                    System.out.print("Enter product name (or 'done' to finish): ");
	                    String productName = reader.readLine();
	                    if (productName.equalsIgnoreCase("done")) {
	                        break;
	                    }
	                    System.out.print("Enter product price: ");
	                    double productPrice = Double.parseDouble(reader.readLine());
	                    Product product = new Product(productName, productPrice);
	                    order.addProduct(product);
	                }

	                // Add order to OrderService
	                orderService.addOrder(order);

	                // Display order details
	                order.displayOrderDetails();
	            }

	            // Save all orders to file
	            orderService.saveAllOrdersToFile("orders.txt");

	            // Display all orders
	            orderService.displayAllOrders();

	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input: Please enter numeric values for order count.");
	        } catch (Exception e) {
	            System.out.println("An error occurred: " + e.getMessage());
	        }
	    }
	}
