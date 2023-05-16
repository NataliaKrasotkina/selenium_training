package testNG.shop;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import shop.RealItem;

@Test(groups = { "IncludedTest" })
public class RealItemTest {

    @Test
    @Parameters({"value"})
    public void testToString(@Optional Double value) {
        double weight = 12;
        RealItem realItem = new RealItem();
        realItem.setWeight(weight);
        Assert.assertTrue(realItem.toString().contains("Weight: " + weight), "toString value is not correct");
    }
}
