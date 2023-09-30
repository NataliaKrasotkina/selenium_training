import configuration.DriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MailPage;

import java.io.File;

public class BaseTest {
    private WebDriver driver;
    private final static String MAIL_URL = "https://mail.yandex.com";
    public static final String SCREENSHOTS_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\";

    protected LoginPage loginPage;
    protected MailPage mailPage;

    @BeforeEach
    void setup() {
        driver = DriverManager.getInstance();
        loginPage = new LoginPage();
        driver.get(MAIL_URL);
    }

    protected void takeScreenshot(String fileName) {
        TakesScreenshot screen = (TakesScreenshot) driver;
        File srcFile = screen.getScreenshotAs(OutputType.FILE);
        File destFile = new File(SCREENSHOTS_PATH + fileName);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @AfterEach
    void cleanup() {
        DriverManager.quit();
    }
}