package shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VirtualItemTest {

    @Test
    public void setSizeOnDiskTest() {
        double sizeOnDisk = 6;

        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setSizeOnDisk(sizeOnDisk);

        Assertions.assertEquals(sizeOnDisk, virtualItem.getSizeOnDisk(), "SizeOnDisk value is not correct");
    }
}