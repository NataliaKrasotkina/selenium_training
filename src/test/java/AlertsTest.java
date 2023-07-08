import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static pages.AlertsPage.*;


public class AlertsTest {
    private WebDriver driver;
    private final static String ALERT_TEXT = "Press a button!";
    private final static String TEXT = "Natalia";
    private final static String EXPECTED_TEXT = "You have entered 'Natalia' !";


    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }

    @Test
    public void testJavaScriptConfirmBoxText() {
        driver.get(ALERTS_URL);
        driver.findElement(CLICK_ME_CONFIRM_BUTTON).click();
        Alert alert = driver.switchTo().alert();

        Assertions.assertEquals(ALERT_TEXT, alert.getText(), "Message is not correct");
        alert.accept();
    }

    @Test
    public void testJavaScriptConfirmBoxCancel() {
        driver.get(ALERTS_URL);
        driver.findElement(CLICK_ME_CONFIRM_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        Assertions.assertTrue(driver.findElement(TEXT_ON_CANCEL).isDisplayed(), "Message is not correct");

    }

    @Test
    public void testJavaScriptAlertBox() {
        driver.get(ALERTS_URL);
        driver.findElement(CLICK_FOR_PROMPT_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(TEXT);
        alert.accept();

        Assertions.assertEquals(EXPECTED_TEXT, driver.findElement(TEXT_ON_ALERT).getText(), "Message is not correct");

    }
}