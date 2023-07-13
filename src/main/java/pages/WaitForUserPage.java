package pages;

import org.openqa.selenium.By;

public class WaitForUserPage {
    public final static String DATA_LOADING_URL = "https://demo.seleniumeasy.com/dynamic-data-loading-demo.html";
    public final static By GET_NEW_USER = By.xpath("//button[@class='btn btn-default']");
    public final static By USER_IMAGE = By.xpath("//img[contains(@src,'https://randomuser.me/api/portraits')]");
}