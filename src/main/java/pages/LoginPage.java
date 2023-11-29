package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final static By ENTER_BUTTON = By.cssSelector(".Button2_view_default.Button2_size_m");
    private final static By LOGIN_INPUT = By.id("passp-field-login");
    private final static By LOGIN_BUTTON_USERNAME_FORM = By.cssSelector(".passp-login-form [type='submit']");
    private final static By LOGIN_BUTTON_PASSWORD_FORM = By.cssSelector(".AuthPasswordForm [type='submit']");
    private final static By PASSWORD_INPUT = By.name("passwd");


    public void clickEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
    }

    public void enterTextToLoginField(String login) {
        driver.findElement(LOGIN_INPUT).sendKeys(login);
    }

    public void clickLoginButtonUserNameForm() {
        driver.findElement(LOGIN_BUTTON_USERNAME_FORM).click();
    }

    public MailPage clickLoginButtonPasswordForm() {
        driver.findElement(LOGIN_BUTTON_PASSWORD_FORM).click();
        return new MailPage();
    }

    public void enterTextToPasswordField(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step ("Log in")
    public MailPage login(String login, String password) {
        clickEnterButton();
        enterTextToLoginField(login);
        clickLoginButtonUserNameForm();
        enterTextToPasswordField(password);
        return clickLoginButtonPasswordForm();
    }

    public boolean isEnterButtonDisplayed() {
        return isElementDisplayed(ENTER_BUTTON);
    }
    @Step ("Verify Enter Button")
     public void verifyEnterButton(){
         Assertions.assertTrue (isEnterButtonDisplayed(), "Log Out failed");
     }
}