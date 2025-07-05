package Models;

import Interfaces.Expirapal;

import java.time.LocalDate;

public class ExpirableProducts extends Product implements Expirapal {
    private LocalDate expiryDate;

    public ExpirableProducts(String name, double price, int quantity, double Weight , LocalDate expiryDate) {
        super(name, price, quantity, Weight);
        this.expiryDate = expiryDate;
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


}
