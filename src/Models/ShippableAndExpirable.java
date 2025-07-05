package Models;

import Interfaces.Expirapal;
import Interfaces.Shippable;

import java.time.LocalDate;

public class ShippableAndExpirable extends Product implements Shippable, Expirapal {
    private LocalDate expiryDate;
    private Double weight;

    public ShippableAndExpirable(String name, double price, int quantity, double Weight , LocalDate expiryDate) {
        super(name, price, quantity, Weight);
        this.expiryDate = expiryDate;
        this.weight = Weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean isExpired() {
        if (expiryDate.isBefore(LocalDate.now()))
            return false;
        return true;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }
}
