package Interfaces;
import java.time.LocalDate;

public interface Expirapal {
    LocalDate getExpiryDate();
    boolean isExpired();
}
