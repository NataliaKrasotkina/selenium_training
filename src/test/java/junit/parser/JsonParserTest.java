package junit.parser;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import parser.JsonParser;
import parser.NoSuchFileException;
import parser.Parser;
import shop.Cart;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertAll;

public class JsonParserTest {

    private static final String EXPECTED_FILE_TEXT = "{\"cartName\":\"cart-to-write\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}";
    private static Parser parser;

    @BeforeAll
    public static void setUp() {
        parser = new JsonParser();
    }

    @Disabled
    @Test
    public void testWriteToFile() throws IOException {
        Cart cartToWrite = new Cart("cart-to-write");

        parser.writeToFile(cartToWrite);
        String actualFileText = Files.readString(Paths.get(String.format("src/main/resources/%s.json", cartToWrite.getCartName())));
        Assertions.assertEquals(EXPECTED_FILE_TEXT, actualFileText, "Written and read content is not equal");
    }

    @Test
    public void testReadFromFile() {
        String expectedName = "cart-to-read";
        Cart cartFromFile = parser.readFromFile(new File(String.format("src/test/resources/%s.json", expectedName)));
        assertAll(
                () -> Assertions.assertEquals(expectedName, cartFromFile.getCartName(), "Written and read content is not equal"),
                () -> Assertions.assertEquals(0.0, cartFromFile.getTotalPrice(), "Written and read content is not equal")
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void testException(int number) {
        String notExistingFileNameTemplate = "notExistingFileName";
        Assertions.assertThrows(NoSuchFileException.class, () -> {
            parser.readFromFile(new File(String.format("src/main/resources/%s%d.json", notExistingFileNameTemplate, number)));
        });
    }

    @AfterAll
    public static void clear() {
        try {
            Files.delete(Paths.get("src/main/resources/cart-to-write.json"));
        } catch (Exception ignore) {
        }
    }
}
