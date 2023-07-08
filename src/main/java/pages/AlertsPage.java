package pages;

import org.openqa.selenium.By;

public class AlertsPage {
    public final static String ALERTS_URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";
    public final static By CLICK_FOR_PROMPT_BUTTON = By.xpath("//button[@onclick='myPromptFunction()']");
    public final static By CLICK_ME_CONFIRM_BUTTON = By.xpath("//button[@onclick='myConfirmFunction()']");
    public final static By TEXT_ON_CANCEL = By.xpath("//p[@id='confirm-demo']");
    public final static By TEXT_ON_ALERT = By.xpath("//p[@id='prompt-demo']");
}

