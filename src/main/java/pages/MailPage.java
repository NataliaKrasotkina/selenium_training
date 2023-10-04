package pages;

import org.openqa.selenium.By;


public class MailPage extends BasePage {
    private final static By ACCOUNT_NAME = By.xpath("//a[contains(@class, 'user-account_left' )]/span[@class='user-account__name']");
    private final static By ACCOUNT_ICON = By.xpath("//a[contains(@class, 'user-account_left' )]/span[@class='user-account__name']/..");
    private final static By LOGOUT_BUTTON = By.xpath("//a[@aria-label='Log out']");

    public void clickLogOutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
    }

    public void clickAccountIcon() {
        driver.findElement(ACCOUNT_ICON).click();
    }

    public String getAccountName() {
        return driver.findElement(ACCOUNT_NAME).getText();
    }
}