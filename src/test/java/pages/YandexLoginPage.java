package pages;

import org.openqa.selenium.By;

public class YandexLoginPage {
    public By enterButton = By.cssSelector(".Button2.Button2_type_link.Button2_view_default.Button2_size_m");
    public By loginInput = By.id("passp-field-login");
    public By loginButton = By.id("passp:sign-in");
    public By passwordInput = By.name("passwd");
    public String accountNameTemplate = "//span[text()='%s']";
}
