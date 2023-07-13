import io.github.bonigarcia.wdm.WebDriverManager;
import model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static pages.TableSortSearchPage.*;


public class TableSortSearchScript {
    private WebDriver driver;
    private final static String ROWS_PER_PAGE = "10";
    private final static int AGE_LIMIT = 37;
    private final static int SALARY_LIMIT = 300000;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(TABLE_SORT_SEARCH_URL);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }

    @Test
    public void selectListTest() {
        WebElement dropdown = driver.findElement(SELECT_LIST);
        Select select = new Select(dropdown);
        select.selectByVisibleText(ROWS_PER_PAGE);
        System.out.println(collectEmployees(AGE_LIMIT, SALARY_LIMIT));
    }

    private List<Employee> collectEmployees(int ageLimit, int salaryLimit) {
        List<Employee> employees;
        List<WebElement> rows = driver.findElements(TABLE_ROWS);
        employees = getEntries(ageLimit, salaryLimit, rows);

        while (driver.findElement(NEXT_BUTTON).getAttribute("class").contains("disabled")) {
            driver.findElement(NEXT_BUTTON).click();
            rows = driver.findElements(TABLE_ROWS);
            employees.addAll(getEntries(AGE_LIMIT, SALARY_LIMIT, rows));

        }
        return employees;
    }

    private List<Employee> getEntries(int age, int salary, List<WebElement> rows) {
        List<Employee> entries = new ArrayList<>();
        for (WebElement row : rows) {
            Employee entry = getEntry(row);
            if (entry.getAge() > age && entry.getSalary() <= salary) {
                entries.add(entry);
            }
        }

        return entries;
    }

    private Employee getEntry(WebElement row) {
        String name = row.findElement(NAME_COLUMN).getText();
        String position = row.findElement(POSITION_COLUMN).getText();
        String office = row.findElement(OFFICE_COLUMN).getText();
        int age = Integer.parseInt(row.findElement(AGE_COLUMN).getText());
        int salary = Integer.parseInt(row.findElement(SALARY_COLUMN).getAttribute("data-order"));

        return new Employee(name, position, office, age, salary);
    }
}