package parser;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import shop.Cart;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertAll;

public class JsonParserTest {
    private static Parser parser;

    @BeforeAll
    public static void setUp() {
        parser = new JsonParser();
    }

    @Disabled
    @Test
    public void testWriteToFile() {
        Cart cartToWrite = new Cart("cart-to-write");

        parser.writeToFile(cartToWrite);
        Cart cartFromFile = parser.readFromFile(new File(String.format("src/main/resources/%s.json", cartToWrite.getCartName())));

        Assertions.assertEquals(cartToWrite.getCartName(), cartFromFile.getCartName(), "Written and read content is not equal");
        Assertions.assertEquals(cartToWrite.getTotalPrice(), cartFromFile.getTotalPrice(), "Written and read content is not equal");
    }

    @Test
    public void testReadFromFile() {
        Cart expectedCart = new Cart("cart-to-read");

        Cart cartFromFile = parser.readFromFile(new File(String.format("src/main/resources/%s.json", expectedCart.getCartName())));
        assertAll(
                () -> Assertions.assertEquals(expectedCart.getCartName(), cartFromFile.getCartName(), "Written and read content is not equal"),
                () ->  Assertions.assertEquals(expectedCart.getTotalPrice(), cartFromFile.getTotalPrice(), "Written and read content is not equal")
        );
    }
   @ParameterizedTest
   @ValueSource (ints = {1, 2, 3, 4, 5, 6})
    public void testException(int number) {
        String notExistingFileNameTemplate = "notExistingFileName";
        Assertions.assertThrows(NoSuchFileException.class, () -> {
            parser.readFromFile(new File(String.format("src/main/resources/%s%d.json", notExistingFileNameTemplate, number)));
        });
    }

    @AfterAll
    public static void clear (){
        parser = null;
    }
}
