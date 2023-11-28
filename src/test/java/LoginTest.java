import configuration.MyTestWatcher;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
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

    @Test
    @Description("Test Description: This test attempts to log into the website using a login and a password. Fails if any error happens.")
    @TmsLink("ID=1")
    void loginTest() {
        mailPage.verifyAccountName(LOGIN);
    }

    @Test
    @Description("Test Description: This test attempts to log out from the website. Fails if any error happens.")
    @TmsLink("ID=2")
    void logoutTest() {
        mailPage.clickAccountIcon();
        mailPage.clickLogOutButton();
        loginPage.verifyEnterButton();
    }
}