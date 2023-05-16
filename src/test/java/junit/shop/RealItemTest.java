package junit.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.RealItem;

public class RealItemTest {

    @Test
    public void testToString() {
        double weight = 12;
        RealItem realItem = new RealItem();
        realItem.setWeight(weight);
        Assertions.assertTrue(realItem.toString().contains("Weight: " + weight), "toString value is not correct");
    }
}
