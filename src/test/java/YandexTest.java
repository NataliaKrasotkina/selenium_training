import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.YandexLoginPage;

import java.util.concurrent.TimeUnit;

public class YandexTest {
    private WebDriver driver;
    private String password = "NK852456";
    private String login = "NatalliaKrasotkina";
    private String mailUrl = "https://mail.yandex.com";
    private YandexLoginPage yandexLoginPage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        yandexLoginPage = new YandexLoginPage();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    void yandexTest() {
        driver.get(mailUrl);
        driver.findElement(yandexLoginPage.enterButton).click();
        driver.findElement(yandexLoginPage.loginInput).sendKeys(login);
        driver.findElement(yandexLoginPage.loginButton).click();
        driver.findElement(yandexLoginPage.passwordInput).sendKeys(password);
        driver.findElement(yandexLoginPage.loginButton).click();
        By accountName = By.xpath(String.format(yandexLoginPage.accountNameTemplate, login));
        Assertions.assertFalse(driver.findElements(accountName).isEmpty(), "Login failed");
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
