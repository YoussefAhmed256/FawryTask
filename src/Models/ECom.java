package Models;

import java.util.ArrayList;
import java.util.List;

public class ECom {
    public List<Product> products;
    public List<Customer> customers;
    public ECom() {
        products = new ArrayList<Product>();
        customers = new ArrayList<Customer>();
    }
}
