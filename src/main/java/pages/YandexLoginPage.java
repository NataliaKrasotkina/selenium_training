package pages;

import configuration.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexLoginPage {
    public final static By ENTER_BUTTON = By.cssSelector(".Button2_view_default.Button2_size_m");
    public final static By LOGIN_INPUT = By.id("passp-field-login");
    public final static By LOGIN_BUTTON = By.id("passp:sign-in");
    public final static By PASSWORD_INPUT = By.name("passwd");
    public final static By ACCOUNT_NAME = By.xpath("//a[contains(@class, 'user-account_left' )]/span[@class='user-account__name']");
    public final static By ACCOUNT_ICON = By.xpath("//a[contains(@class, 'user-account_left' )]/span[@class='user-account__name']/..");
    public final static By LOGOUT_BUTTON = By.xpath("//a[@aria-label='Log out']");


    private WebDriver driver;

    public YandexLoginPage() {
        driver = DriverManager.getInstance();
    }

    public void clickEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
    }

    public void enterTextToLoginField(String login) {
        driver.findElement(LOGIN_INPUT).sendKeys(login);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void enterTextToPasswordField(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public String getAccountName() {
        return driver.findElement(ACCOUNT_NAME).getText();
    }

    public void clickLogOutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
    }
    public void clickAccountIcon() {
        driver.findElement(ACCOUNT_ICON).click();
    }
    public boolean isEnterButtonPresent() {
        return driver.findElements(ENTER_BUTTON).size()>0;
    }
}