package pages;

import configuration.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexLoginPage {
    @FindBy(css = ".Button2_view_default.Button2_size_m")
    private WebElement enterButton;
    @FindBy(id = "passp-field-login")
    private WebElement loginInput;
    @FindBy(id = "passp:sign-in")
    private WebElement loginButton;
    @FindBy(name = "passwd")
    private WebElement passwordInput;
    @FindBy(xpath = "//a[contains(@class, 'user-account_left' )]/span[@class='user-account__name']")
    private WebElement accountName;
    @FindBy(xpath = "//a[contains(@class, 'user-account_left' )]/span[@class='user-account__name']/..")
    private WebElement accountIcon;
    @FindBy(xpath = "//a[@aria-label='Log out']")
    private WebElement logoutButton;

    private String enterButtonCss = ".Button2_view_default.Button2_size_m";

    private WebDriver driver;

    public YandexLoginPage() {
        driver = DriverManager.getInstance();
        PageFactory.initElements(driver, this);
    }

    public void clickEnterButton() {
       enterButton.click();
    }

    public void enterTextToLoginField(String login) {
        loginInput.sendKeys(login);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void enterTextToPasswordField(String password) {
        passwordInput.sendKeys(password);
    }

    public String getAccountName() {
        return accountName.getText();
    }

    public void clickLogOutButton() {
        logoutButton.click();
    }

    public void clickAccountIcon() {
        accountIcon.click();
    }

    public boolean isEnterButtonPresent() {
        return driver.findElements(By.cssSelector(enterButtonCss)).size() > 0;
    }
}