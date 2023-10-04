package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = ".Button2_view_default.Button2_size_m")
    private WebElement enterButton;
    @FindBy(id = "passp-field-login")
    private WebElement loginInput;
    @FindBy(css = ".passp-login-form [type='submit']")
    private WebElement login_buttonUsernameForm;
    @FindBy(css = ".AuthPasswordForm [type='submit']")
    private WebElement loginButtonUPasswordForm;
    @FindBy(name = "passwd")
    private WebElement passwordInput;


    public void clickEnterButton() {
        enterButton.click();
    }

    public void enterTextToLoginField(String login) {
        loginInput.sendKeys(login);
    }

    public void clickLoginButtonUserNameForm() {
        login_buttonUsernameForm.click();
    }

    public MailPage clickLoginButtonPasswordForm() {
        loginButtonUPasswordForm.click();
        return new MailPage();
    }

    public void enterTextToPasswordField(String password) {
        passwordInput.sendKeys(password);
    }

    public MailPage login(String login, String password) {
        clickEnterButton();
        enterTextToLoginField(login);
        clickLoginButtonUserNameForm();
        enterTextToPasswordField(password);
        return clickLoginButtonPasswordForm();
    }

    public boolean isEnterButtonDisplayed() {
        return isElementDisplayed(enterButton);
    }
}