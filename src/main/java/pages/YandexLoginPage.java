package pages;

import org.openqa.selenium.By;

public class YandexLoginPage {
    public final static By ENTER_BUTTON = By.cssSelector(".Button2.Button2_type_link.Button2_view_default.Button2_size_m");
    public final static By LOGIN_INPUT = By.id("passp-field-login");
    public final static By LOGIN_BUTTON = By.id("passp:sign-in");
    public final static By PASSWORD_INPUT = By.name("passwd");
    public final static By ACCOUNT_NAME = By.xpath("//a[contains(@class, 'user-account_left' )]/span[@class='user-account__name']");
}
