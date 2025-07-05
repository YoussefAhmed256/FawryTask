package Models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    protected final int Id;
    private String Name;
    private int Balance;

    private int c=0;

    public Customer(String name, int balance) {
        Id=++c;
        Name=name;
        Balance=balance;
    }
    public int getId() {
        return Id;
    }
    public String getName() {
        return Name;
    }
    public int getBalance() {
        return Balance;
    }

}
