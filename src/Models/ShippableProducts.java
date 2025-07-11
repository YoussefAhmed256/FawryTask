package Models;

import Interfaces.Shippable;

public class ShippableProducts extends Product implements Shippable {
    private double weight;

    public ShippableProducts(String name, double price, int quantity, double Weight) {
        super(name, price, quantity);
        this.weight = Weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity +"weight="
                + weight +"]";
    }
}
