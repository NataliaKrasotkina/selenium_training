package testNG.shop;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import parser.JsonParser;
import shop.Cart;
import shop.RealItem;

import java.io.File;

@Test(groups = {"ExcludedTest"})
public class CartTest {

    private Cart cart;
    private RealItem realItem;
    private JsonParser jsonParser;
    private static final double TAX = 0.2;
    private double total;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        jsonParser = new JsonParser();
        cart = jsonParser.readFromFile(new File("src/main/resources/eugen-cart.json"));
        realItem = new RealItem();
        realItem.setPrice(10);
        total = cart.getTotalPrice() + realItem.getPrice() + realItem.getPrice() * TAX;
        cart.addRealItem(realItem);
    }

    @Test(groups = {"Group1"})
    public void testCalculationWhileAddingRealItem() {
        Assert.assertEquals(total, cart.getTotalPrice(), "Total value is not correct");
    }

    @Test(groups = {"Group1", "Group2"})
    public void testCalculationWhileDeletingRealItem() {
        total = cart.getTotalPrice() - realItem.getPrice() - realItem.getPrice() * TAX;
        cart.deleteRealItem(realItem);
        Assert.assertEquals(total, cart.getTotalPrice(), "Total value is not correct");
    }
}
