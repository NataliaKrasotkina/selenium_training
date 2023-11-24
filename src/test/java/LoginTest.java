import configuration.MyTestWatcher;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.LoginPage;
import pages.MailPage;

@Epic("Login Tests Epic")
@Feature("Invalid Login Features")
@ExtendWith(MyTestWatcher.class)
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

    @Test()
    @Description("Test Description: This test attempts to log into the website using a login and a password. Fails if any error happens.")
    @TmsLink("ID=1")
    public void loginTest() {

        validateUserIsLoggedIn();
        takeScreenshot();
    }

    @Step("Validate user is logged in")
    private void validateUserIsLoggedIn() {
        Assertions.assertEquals(LOGIN, mailPage.getAccountName(), "Login failed");
    }

    @Step("Take Screenshot")
    private void takeScreenshot() {
        takeScreenshot("user_logged.png");
    }

    @Test
    @Description("Test Description: This test attempts to log out from the website. Fails if any error happens.")
    @TmsLink("ID=2")
    public void logoutTest() {
        logOutUser();
        validateUserIsLoggedOut();
    }

    @Step("Log out user")
    private void logOutUser() {
        mailPage.clickAccountIcon();
        mailPage.clickLogOutButton();
    }

    @Step("Validate user is logged in")
    private void validateUserIsLoggedOut() {
        Assertions.assertTrue(loginPage.isEnterButtonDisplayed(), "Log Out failed");
    }
}