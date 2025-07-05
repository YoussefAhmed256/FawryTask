package Models;

public class Customer {
    private final int id;
    private String name;
    private double balance;

    private int c=0;

    public Customer(String _name, double _balance) {
        id=++c;
        name=_name;
        balance=_balance;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double _balance) {
        balance=_balance;
    }
    public void setName (String _name) {
        name=_name;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", balance=" + balance + "]";
    }

}
