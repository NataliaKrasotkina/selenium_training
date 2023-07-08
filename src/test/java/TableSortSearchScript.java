import io.github.bonigarcia.wdm.WebDriverManager;
import model.Entry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static pages.TableSortSearchPage.*;


public class TableSortSearchScript {
    private WebDriver driver;
    private List<Entry> entries;
    private final static String ROWS_PER_PAGE = "10";
    private final static int AGE_LIMIT = 37;
    private final static int SALARY_LIMIT = 300000;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }

    @Test
    public void testSelectList() {
        driver.get(TABLE_URL);
        WebElement dropdown = driver.findElement(SELECT_LIST);
        Select select = new Select(dropdown);
        select.selectByVisibleText(ROWS_PER_PAGE);
        List<WebElement> rows = driver.findElements(TABLE_ROWS);
        entries = getEntries(AGE_LIMIT, SALARY_LIMIT, rows);

        while (driver.findElements(DISABLED_NEXT_BUTTON).size() == 0) {
            driver.findElement(NEXT_BUTTON).click();
            rows = driver.findElements(TABLE_ROWS);
            entries.addAll(getEntries(AGE_LIMIT, SALARY_LIMIT, rows));
        }
    }

    private List<Entry> getEntries(int age, int salary, List<WebElement> rows) {
        List<Entry> entries = new ArrayList<>();
        for (WebElement row : rows) {
            Entry entry = getEntry(row);
            if (entry.getAge() > age && entry.getSalary() <= salary) {
                entries.add(getEntry(row));
            }
        }

        return entries;
    }

    private Entry getEntry(WebElement row) {
        List<WebElement> cells = row.findElements(By.xpath("./td"));
        String name = cells.get(NAME_COLUMN_INDEX).getText();
        String position = cells.get(POSITION_COLUMN_INDEX).getText();
        String office = cells.get(OFFICE_COLUMN_INDEX).getText();
        int age = Integer.parseInt(cells.get(AGE_COLUMN_INDEX).getText());
        int salary = Integer.parseInt(cells.get(SALARY_COLUMN_INDEX).getAttribute("data-order"));

        return new Entry(name, position, office, age, salary);
    }
}