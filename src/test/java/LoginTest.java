import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MailPage;

@Epic("Login Tests Epic")
@Feature("Invalid Login Features")
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
    @Story("User tries to login the system with invalid username and invalid password.")
    @Description("Invalid Login Test with Invalid Username and Invalid Password.")
    void loginTest() {

        Assertions.assertEquals(LOGIN, mailPage.getAccountName(), "Login failed");
        takeScreenshot("user_logged.png");
    }

    @Test
    void logoutTest() {
        mailPage.clickAccountIcon();
        mailPage.clickLogOutButton();
        Assertions.assertTrue(loginPage.isEnterButtonDisplayed(), "Log Out failed");
    }
}