package testNG.parser;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import parser.JsonParser;
import parser.NoSuchFileException;
import parser.Parser;
import shop.Cart;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class JsonParserTest {

    private static final String EXPECTED_FILE_TEXT = "{\"cartName\":\"cart-to-write\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}";
    private static Parser parser;

    @BeforeClass(alwaysRun = true)
    public static void setUp() {
        parser = new JsonParser();
    }

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{{1}, {2}, {3}, {4}, {5}, {6}};
    }

    @Test(enabled = false)
    public void testWriteToFile() throws IOException {
        Cart cartToWrite = new Cart("cart-to-write");

        parser.writeToFile(cartToWrite);
        String actualFileText = Files.readString(Paths.get(String.format("src/main/resources/%s.json", cartToWrite.getCartName())));
        Assert.assertEquals(EXPECTED_FILE_TEXT, actualFileText, "Written and read content is not equal");
    }

    @Test(groups = {"Group1"})
    public void testReadFromFile() {
        String expectedName = "cart-to-read";
        Cart cartFromFile = parser.readFromFile(new File(String.format("src/test/resources/%s.json", expectedName)));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedName, cartFromFile.getCartName(), "Written and read content is not equal");
        softAssert.assertEquals(0.0, cartFromFile.getTotalPrice(), "Written and read content is not equal");
        softAssert.assertAll();
    }

    @Test(dataProvider = "data-provider")
    public void testException(int number) {
        String notExistingFileNameTemplate = "notExistingFileName";
        Assert.assertThrows(NoSuchFileException.class, () -> {
            parser.readFromFile(new File(String.format("src/main/resources/%s%d.json", notExistingFileNameTemplate, number)));
        });
    }

    @AfterClass
    public static void clear() {
        try {
            Files.delete(Paths.get("src/main/resources/cart-to-write.json"));
        } catch (Exception ignore) {
        }
    }
}
