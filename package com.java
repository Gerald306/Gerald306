// Product.java
package com.ecommerce;

public class Product {
    private int productID;
    private String name;
    private double price;

    public Product(int productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

// Customer.java
package com.ecommerce;

import java.util.ArrayList;

public class Customer {
    private int customerID;
    private String name;
    private ArrayList<Product> shoppingCart;

    public Customer(int customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
    }

    public void addProductToCart(Product product) {
        shoppingCart.add(product);
    }

    public void removeProductFromCart(Product product) {
        shoppingCart.remove(product);
    }

    public double calculateTotalCost() {
        double total = 0;
        for (Product product : shoppingCart) {
            total += product.getPrice();
        }
        return total;
    }

    public void placeOrder() {
        System.out.println("Order placed successfully!");
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public String getName() {
        return name;
    }
}

// Order.java
package com.ecommerce.orders;

import com.ecommerce.Customer;
import com.ecommerce.Product;
import java.util.ArrayList;

public class Order {
    private int orderID;
    private Customer customer;
    private ArrayList<Product> products;
    private double orderTotal;

    public Order(int orderID, Customer customer, ArrayList<Product> products) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = products;
        this.orderTotal = calculateTotal(products);
    }

    private double calculateTotal(ArrayList<Product> products) {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void displayOrderSummary() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println(" - " + product.getName() + ": $" + product.getPrice());
        }
        System.out.println("Order Total: $" + orderTotal);
    }
}

// Main.java
import com.ecommerce.Product;
import com.ecommerce.Customer;
import com.ecommerce.orders.Order;

public class Main {
    public static void main(String[] args) {
        // Creating Products
        Product product1 = new Product(101, "Laptop", 800.00);
        Product product2 = new Product(102, "Smartphone", 500.00);

        // Creating Customer
        Customer customer = new Customer(201, "John Doe");
        customer.addProductToCart(product1);
        customer.addProductToCart(product2);

        // Displaying Customer's Cart
        System.out.println("Customer's Cart:");
        for (Product product : customer.getShoppingCart()) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }

        // Placing Order
        Order order = new Order(301, customer, customer.getShoppingCart());
        order.displayOrderSummary();
    }
}
