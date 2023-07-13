package pages;

import org.openqa.selenium.By;

public class RefreshPage {
    public final static String DOWNLOAD_PROGRESS_URL = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";
    public final static By DOWNLOAD_BUTTON = By.xpath("//button[@class='btn btn-block btn-primary']");
    public final static By PROGRESS_CIRCLE = By.xpath("//div[@class='prog-circle']");
}
