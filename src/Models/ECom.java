package Models;

import java.util.ArrayList;
import java.util.List;

public class ECom {
    private List<Product> products;
    private List<Customer> customers;
    public ECom() {
        products = new ArrayList<>();
        customers = new ArrayList<>();
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public List<Product> getProducts() {
        return products;
    }
    public List<Customer> getCustomers() {
        return customers;
    }
    public Customer getCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        throw new RuntimeException("Customer with id " + id + " not found enter correct Id or add new Customer");
    }
    public Product getProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new RuntimeException("Product with id " + id + " not found enter correct Id or add new Product");
    }
    public void removeProduct(int id) {
        Product product = getProduct(id);
        products.remove(product);
    }
    public void removeCustomer(int id) {
        Customer customer = getCustomer(id);
        customers.remove(customer);
    }

}
