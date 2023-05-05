package shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parser.JsonParser;

import java.io.File;

public class CartTest {

    private Cart cart;
    private RealItem realItem;
    private JsonParser jsonParser;
    private static final double TAX = 0.2;
    private double total;

    @BeforeEach
    public void setUp() {
        jsonParser = new JsonParser();
        cart = jsonParser.readFromFile(new File("src/main/resources/eugen-cart.json"));
        realItem = new RealItem();
        realItem.setPrice(10);
        total = cart.getTotalPrice() + realItem.getPrice() + realItem.getPrice() * TAX;
        cart.addRealItem(realItem);
    }

    @Test
    public void testCalculationWhileAddingRealItem() {
        Assertions.assertEquals(total, cart.getTotalPrice(), "Total value is not correct");
    }

    @Test
    public void testCalculationWhileDeletingRealItem() {
        total = cart.getTotalPrice() - realItem.getPrice() - realItem.getPrice() * TAX;
        cart.deleteRealItem(realItem);
        Assertions.assertEquals(total, cart.getTotalPrice(), "Total value is not correct");
    }
}
