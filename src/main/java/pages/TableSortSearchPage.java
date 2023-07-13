package pages;

import org.openqa.selenium.By;

public class TableSortSearchPage {
    public final static String TABLE_SORT_SEARCH_URL = "https://demo.seleniumeasy.com/table-sort-search-demo.html";
    public final static By SELECT_LIST = By.xpath("//select[@name='example_length']");
    public final static By TABLE_ROWS = By.cssSelector("tbody tr");
    public final static By NEXT_BUTTON = By.cssSelector(".next");
    public final static By NAME_COLUMN = By.xpath(".//td[1]");
    public final static By POSITION_COLUMN = By.xpath(".//td[2]");
    public final static By OFFICE_COLUMN = By.xpath(".//td[3]");
    public final static By AGE_COLUMN = By.xpath(".//td[4]");
    public final static By SALARY_COLUMN = By.xpath(".//td[6]");
}
