package Services;

import Models.ExpirableProducts;
import Models.Product;
import Models.ShippableAndExpirable;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cartItems;

    public Cart (){
        this.cartItems = new HashMap<Product, Integer>();
    }

    public void addToCart(Product product, int quantity) {
        if (quantity <= 0)
            throw new RuntimeException("Quantity must be greater than 0");
        else if (product.getQuantity() < quantity || cartItems.get(product) + quantity > product.getQuantity())
            throw new RuntimeException("Not enough Quantity in stock");
        else if (product instanceof ExpirableProducts && ((ExpirableProducts) product).isExpired() || product instanceof ShippableAndExpirable && ((ShippableAndExpirable) product).isExpired())
            throw new RuntimeException("Product is expired");
        else if (cartItems.containsKey(product))
            cartItems.put(product, cartItems.get(product) + quantity);
        else{
            cartItems.put(product, quantity);
            product.removeQuantity(quantity);
        }
    }
    public void removeFromCart(Product product ,int quantity) {
        if (quantity <= 0)
            throw new RuntimeException("Quantity must be greater than 0");
        else if (cartItems.get(product) - quantity < 0)
            throw new RuntimeException("You should remove valid quantity");
        else if (cartItems.get(product) - quantity == 0)
            cartItems.remove(product);
        else if (cartItems.containsKey(product))
            cartItems.put(product, cartItems.get(product) - quantity);
        else
            throw new RuntimeException("You didn't add this Product to the cart");
    }
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public Map<Product, Integer> getProducts() {
        return cartItems;
    }
}
