package restaurantsystem.model;

import java.util.List;

public class Cart {

    private final List<CartItem> cartItems;
    private double totalPrice;

    public Cart(List<CartItem> cartItems, double totalPrice) {
        this.cartItems = cartItems;
        this.totalPrice = totalPrice;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addItemToCart(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    public double getTotalPrice() {
        totalPrice = 0;
        cartItems.forEach((cartItem) -> totalPrice += cartItem.getPrice());
        return totalPrice;
    }

}