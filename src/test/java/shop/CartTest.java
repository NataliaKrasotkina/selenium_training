package shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest {

    @Test
    public void getCartNameTest() {
        String cartName = "testCart";
        Cart testCart = new Cart(cartName);

        Assertions.assertEquals(cartName, testCart.getCartName(), "Cart name value is not correct");
    }

    @Test
    public void addRealItemTest() {
        double price = 6;
        double total = 0.0;
        double tax = 0.2;

        Cart cart = new Cart("cart1");
        RealItem realItem = new RealItem();
        realItem.setPrice(price);

        cart.addRealItem(realItem);

        total = total + realItem.getPrice() + realItem.getPrice() * tax;

        Assertions.assertEquals(total, cart.getTotalPrice(), "Total value is not correct");
    }
}
