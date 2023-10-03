package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MailPage extends BasePage {
    @FindBy(xpath = "//a[contains(@class, 'user-account_left' )]/span[@class='user-account__name']")
    private WebElement accountName;
    @FindBy(xpath = "//a[contains(@class, 'user-account_left' )]/span[@class='user-account__name']/..")
    private WebElement accountIcon;
    @FindBy(xpath = "//a[@aria-label='Log out']")
    private WebElement logoutButton;

    public void clickLogOutButton() {
        logoutButton.click();
    }

    public void clickAccountIcon() {
        accountIcon.click();
    }

    public String getAccountName() {
        return accountName.getText();
    }
}