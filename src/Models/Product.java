package Models;

public class Product {
    protected  final int id;
    protected  String name;
    protected  double price;
    protected  int quantity;

    private int c=0;

    public Product(String name, double price, int quantity) {
        id = ++c;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
    }
}
