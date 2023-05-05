package shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VirtualItemTest {

    @Test
    public void testToString() {
        double sizeOnDisk = 6;
        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setSizeOnDisk(sizeOnDisk);
        Assertions.assertTrue(virtualItem.toString().contains("Size on disk: " + sizeOnDisk), "toString value is not correct");
    }
}