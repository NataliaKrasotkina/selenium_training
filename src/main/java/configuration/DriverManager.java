package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class DriverManager {

    private static WebDriver instance;

    public static WebDriver getInstance() {
        if (instance == null) {
            WebDriverManager.chromedriver().setup();
            instance = new ChromeDriver();
            instance.manage().window().maximize();
            instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return instance;
    }
}
