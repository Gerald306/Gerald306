import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ECommerceSystem {

    // Simulating com.ecommerce.Product
    static class Product {
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

        @Override
        public String toString() {
            return "Product [ID=" + productID + ", Name=" + name + ", Price=" + price + "]";
        }
    }

    // Simulating com.ecommerce.Customer
    static class Customer {
        private int customerID;
        private String name;
        private List<Product> shoppingCart;

        public Customer(int customerID, String name) {
            this.customerID = customerID;
            this.name = name;
            this.shoppingCart = new ArrayList<>();
        }

        public void addToCart(Product product) {
            shoppingCart.add(product);
        }

        public void removeFromCart(Product product) {
            shoppingCart.remove(product);
        }

        public double calculateTotal() {
            return shoppingCart.stream().mapToDouble(Product::getPrice).sum();
        }

        public List<Product> getShoppingCart() {
            return shoppingCart;
        }

        public int getCustomerID() {
            return customerID;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Customer [ID=" + customerID + ", Name=" + name + "]";
        }
    }

    // Simulating com.ecommerce.orders.Order
    static class Order {
        private static final AtomicInteger counter = new AtomicInteger(1);
        private int orderID;
        private Customer customer;
        private List<Product> products;
        private double total;
        private String status;

        public Order(Customer customer, List<Product> products) {
            this.orderID = counter.getAndIncrement();
            this.customer = customer;
            this.products = new ArrayList<>(products);
            this.total = products.stream().mapToDouble(Product::getPrice).sum();
            this.status = "Pending";
        }

        public void updateStatus(String status) {
            this.status = status;
        }

        public String getSummary() {
            return "Order ID: " + orderID +
                    "\nCustomer: " + customer.getName() +
                    "\nProducts: " + products +
                    "\nTotal: $" + total +
                    "\nStatus: " + status;
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        // Create products
        Product p1 = new Product(1, "Laptop", 999.99);
        Product p2 = new Product(2, "Smartphone", 499.99);
        Product p3 = new Product(3, "Headphones", 89.99);

        // Display available products
        System.out.println("Available Products:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println();

        // Create a customer
        Customer customer = new Customer(1001, "Alice");

        // Add products to cart
        customer.addToCart(p1);
        customer.addToCart(p3);

        // Display cart
        System.out.println(customer.getName() + "'s Shopping Cart:");
        customer.getShoppingCart().forEach(System.out::println);
        System.out.println("Total: $" + customer.calculateTotal());
        System.out.println();

        // Place order
        Order order = new Order(customer, customer.getShoppingCart());
        System.out.println("Placing Order...");
        System.out.println(order.getSummary());

        // Update order status
        order.updateStatus("Shipped");
        System.out.println("\nUpdated Order Status:");
        System.out.println(order.getSummary());
    }
}
