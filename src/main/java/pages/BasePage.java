package pages;

import configuration.DriverManager;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        driver = DriverManager.getInstance();
    }
}