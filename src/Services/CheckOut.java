package Services;

import Interfaces.Shippable;
import Models.*;

import java.util.HashMap;
import java.util.Map;

public class CheckOut {
    AdditionalMethods additionalMethods = new AdditionalMethods();
    public void CheckOut(Customer customer, Cart cart) {
        additionalMethods.reset();
        additionalMethods.cartValidation(cart);
        additionalMethods.customerValidation(customer);

        Map<Shippable,Integer> shippableProductsMap = new HashMap<>();
        Map<Product,Integer> productsMap = new HashMap<>();
        productsMap=cart.getProducts();

        for (Map.Entry<Product, Integer> entry : productsMap.entrySet()){
            if (entry.getKey() instanceof Shippable)
                shippableProductsMap.put((Shippable) entry.getKey(),entry.getValue());
        }

        additionalMethods.shippingReport(shippableProductsMap);
        additionalMethods.checkOutReceipt(productsMap);
    }

}
