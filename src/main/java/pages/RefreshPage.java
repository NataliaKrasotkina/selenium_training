package pages;

import org.openqa.selenium.By;

public class RefreshPage {
    public final static String REFRESH_URL = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";
    public final static By DOWNLOAD_BUTTON = By.xpath("//button[@class='btn btn-block btn-primary']");
    public final static By PERCENT_TEXT = By.xpath("//div[@class='prog-circle']");
}
