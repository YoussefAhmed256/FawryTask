package Services;

import Interfaces.Shippable;
import Models.*;

import java.util.HashMap;
import java.util.Map;

public class AdditionalMethods {
    double totalPrice=0.0;
    double shippingFees=0.0;
    private  Map<Product, Integer> products= new HashMap<>();

    public Double calcTotalShippingFees() {
        return this.shippingFees = getTotalWeight() * 3;
    }

    public void cartValidation (Cart cart) {
        if(cart.isEmpty())
            throw new RuntimeException("Shopping cart is empty");
        Map<Product, Integer> products = cart.getProducts();
        for (Map.Entry<Product, Integer> product : products.entrySet()) {
            if ((product instanceof ExpirableProducts && ((ExpirableProducts) product).isExpired() )||(product instanceof ShippableAndExpirable && ((ShippableAndExpirable) product).isExpired())) {
                throw new RuntimeException("This product is expired");
            }
            else
                totalPrice += product.getValue()*product.getKey().getPrice();
        }
    }
    public void customerValidation (Customer customer) {
        if (totalPrice+shippingFees > customer.getBalance())
            throw new RuntimeException("You have not enough money");
    }

    public Double getTotalWeight() {
        double totalWeight = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            if (product instanceof ShippableProducts)
                totalWeight += ((ShippableProducts) product).getWeight()*entry.getValue();
            else if (product instanceof ShippableAndExpirable)
                totalWeight += ((ShippableAndExpirable) product).getWeight()*entry.getValue();
        }
        return totalWeight;
    }
    public void shippingReport (Map<ShippableProducts, Integer> products) {
        System.out.println("** Shipment notice **");
        for (Map.Entry<ShippableProducts, Integer> product : products.entrySet()) {
            double productWeight = product.getValue() * product.getKey().getWeight();

            System.out.println(product.getValue() + "X" + product.getKey().getName() + "             " +
                    "       "+ productWeight);
        }
        System.out.println("Total package weight " + getTotalWeight()/1000 + "kg\n");
    }

    public void checkOutReceipt (Map<Product, Integer> products) {
        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> product : products.entrySet()) {
            double productPrice = product.getValue() * product.getKey().getPrice();

            System.out.println(product.getValue() + "X" + product.getKey().getName() + "             " +
                    "       "+ productPrice);
        }
        System.out.println("----------------------------------");
        System.out.println("Sub Total " + "                           "+totalPrice);
        System.out.println("Shipping Fees                             "+shippingFees);
        System.out.println("Total " + "                               "+totalPrice+shippingFees);
    }

}
