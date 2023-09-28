package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final static By ENTER_BUTTON = By.cssSelector(".Button2_view_default.Button2_size_m");
    private final static By LOGIN_INPUT = By.id("passp-field-login");
    private final static By LOGIN_BUTTON = By.id("passp:sign-in");
    private final static By PASSWORD_INPUT = By.name("passwd");


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

    public boolean isEnterButtonPresent() {
        return driver.findElements(ENTER_BUTTON).size() > 0;
    }

    public void login(String login, String password) {
        clickEnterButton();
        enterTextToLoginField(login);
        clickLoginButton();
        enterTextToPasswordField(password);
        clickLoginButton();
    }
}
