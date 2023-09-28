import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class YandexTest extends BaseTest {
    private final static String PASSWORD = "NK852456";
    private final static String LOGIN = "NatalliaKrasotkina";

    @BeforeEach
    public void login() {
        loginPage.login(LOGIN, PASSWORD);
    }

    @Test
    void loginTest() {
        Assertions.assertEquals(LOGIN, mailPage.getAccountName(), "Login failed");
    }

    @Test
    void logoutTest() {
        mailPage.clickAccountIcon();
        mailPage.clickLogOutButton();
        Assertions.assertTrue(loginPage.isEnterButtonPresent(), "Log Out failed");
    }
}