package Models;

import Interfaces.Expirapal;
import Interfaces.Shippable;

import java.time.LocalDate;

public class ShippableAndExpirable extends Product implements Shippable, Expirapal {
    private LocalDate expiryDate;
    private Double weight;

    public ShippableAndExpirable(String name, double price, int quantity, double weight , LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }


    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity +"weight="
                + weight + "expiryDate="+expiryDate +"]";
    }
}
