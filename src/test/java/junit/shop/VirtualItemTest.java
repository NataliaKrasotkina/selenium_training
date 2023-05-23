package junit.shop;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import shop.VirtualItem;

public class VirtualItemTest {

    @Test
    public void testToString() {
        double sizeOnDisk = 6;
        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setSizeOnDisk(sizeOnDisk);
        Assertions.assertTrue(virtualItem.toString().contains("Size on disk: " + sizeOnDisk), "toString value is not correct");
    }
}