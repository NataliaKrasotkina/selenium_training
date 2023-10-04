import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MailPage;


public class LoginTest extends BaseTest {
    private final static String PASSWORD = "NK852456";
    private final static String LOGIN = "NatalliaKrasotkina";

    protected LoginPage loginPage;
    protected MailPage mailPage;

    @BeforeEach
    public void login() {
        loginPage = new LoginPage();
        mailPage = loginPage.login(LOGIN, PASSWORD);
    }

    @Test
    void loginTest() {
        Assertions.assertEquals(LOGIN, mailPage.getAccountName(), "Login failed");
    }

    @Test
    void logoutTest() {
        mailPage.clickAccountIcon();
        mailPage.clickLogOutButton();
        Assertions.assertTrue(loginPage.isEnterButtonDisplayed(), "Log Out failed");
    }
}