package Models;

public class Product {
    private  final int id;
    private  String name;
    private  double price;
    private  int quantity;

    private int c=0;

    public Product(String name, double price, int quantity, Double Weight) {
        id = ++c;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addQuantity (int quantity) {
        this.quantity += quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    public void removeQuantity(int quantity) {
        this.quantity -= quantity;
    }


}
