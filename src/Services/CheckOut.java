package Services;

import Models.*;
import Services.AdditionalMethods;

import java.util.HashMap;
import java.util.Map;

public class CheckOut {
    AdditionalMethods additionalMethods = new AdditionalMethods();
    public void CheckOut(Customer customer, Cart cart) {
        additionalMethods.cartValidation(cart);
        additionalMethods.customerValidation(customer);

        Map<ShippableProducts,Integer> shippableProductsMap = new HashMap<>();
        Map<Product,Integer> productsMap = new HashMap<>();
        productsMap=cart.getProducts();

        for (Map.Entry<Product, Integer> entry : productsMap.entrySet()){
            if (entry.getKey() instanceof ShippableProducts || entry.getKey() instanceof ShippableAndExpirable)
                shippableProductsMap.put((ShippableProducts) entry.getKey(),entry.getValue());
        }

        additionalMethods.shippingReport(shippableProductsMap);
        additionalMethods.checkOutReceipt(productsMap);
    }

}
