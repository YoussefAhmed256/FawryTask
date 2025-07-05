package Services;

import Interfaces.Shippable;
import Models.*;

import java.util.HashMap;
import java.util.Map;

public class AdditionalMethods {
    double totalPrice=0.0;
    double totalWeight=0.0;


    public Double calcTotalShippingFees() {
        return totalWeight/1000 * 30;
    }

    public void cartValidation (Cart cart) {
        if(cart.isEmpty())
            throw new RuntimeException("Shopping cart is empty");
        Map<Product, Integer> products = cart.getProducts();
        for (Map.Entry<Product, Integer> product : products.entrySet()) {
            Product prod = product.getKey();
            if ((prod instanceof ExpirableProducts && ((ExpirableProducts) prod).isExpired()) ||
                    (prod instanceof ShippableAndExpirable && ((ShippableAndExpirable) prod).isExpired())) {
                throw new RuntimeException("This product is expired");
            }

            if (prod instanceof Shippable) {
                totalWeight += product.getValue() * ((Shippable) prod).getWeight();
            }

            totalPrice += product.getValue()*product.getKey().getPrice();
        }
    }
    public void customerValidation (Customer customer) {
        if (totalPrice+calcTotalShippingFees() > customer.getBalance())
            throw new RuntimeException("You have not enough money");
    }

    public void shippingReport (Map<Shippable, Integer> products) {
        System.out.println("** Shipment notice **");
        for (Map.Entry<Shippable, Integer> product : products.entrySet()) {
            double productWeight = product.getValue() * product.getKey().getWeight();

            System.out.println(product.getValue() + "X" + product.getKey().getName() + "             " +
                    "       "+ productWeight);
        }
        System.out.println("Total package weight " + totalWeight/1000.0 + "kg\n");
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
        System.out.println("Shipping Fees                             "+calcTotalShippingFees());
        double totalAmount =totalPrice+calcTotalShippingFees();
        System.out.println("Total " + "                               "+totalAmount);
    }

    public void reset() {
        totalPrice = 0.0;
        totalWeight = 0.0;
    }

}
