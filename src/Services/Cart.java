package Services;

import Models.ExpirableProducts;
import Models.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cartItems;

    public Cart (){
        this.cartItems = new HashMap<>();
    }

    public void addToCart(Product product, int quantity) {
        if (quantity <= 0) {
            throw new RuntimeException("Quantity must be greater than 0");
        }
        int currentQuantityInCart = cartItems.getOrDefault(product, 0);
        if (product.getQuantity() < quantity || currentQuantityInCart + quantity > product.getQuantity()) {
            throw new RuntimeException("Not enough Quantity in stock");
        }
        if (product instanceof ExpirableProducts && ((ExpirableProducts) product).isExpired()) {
            throw new RuntimeException("Product is expired");
        }

        cartItems.put(product, currentQuantityInCart + quantity);
        product.removeQuantity(quantity);
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
