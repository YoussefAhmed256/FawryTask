package Models;

import Interfaces.Expirapal;

import java.time.LocalDate;

public class ExpirableProducts extends Product implements Expirapal {
    private LocalDate expiryDate;

    public ExpirableProducts(String name, double price, int quantity , LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }


}
