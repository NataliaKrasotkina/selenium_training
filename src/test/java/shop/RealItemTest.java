package shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RealItemTest {

    @Test
    public void setWeightTest() {
        double weight = 12;

        RealItem realItem = new RealItem();
        realItem.setWeight(weight);

        Assertions.assertEquals(weight, realItem.getWeight(), "Weight value is not correct");

    }
}
