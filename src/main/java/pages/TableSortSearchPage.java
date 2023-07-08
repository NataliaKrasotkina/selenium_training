package pages;

import org.openqa.selenium.By;

public class TableSortSearchPage {
    public final static String TABLE_URL = "https://demo.seleniumeasy.com/table-sort-search-demo.html";
    public final static By SELECT_LIST = By.xpath("//select[@name='example_length']");
    public final static By TABLE_ROWS = By.xpath("//tr[@role='row' and @class]");
    public final static By NEXT_BUTTON = By.xpath("//a[@class='paginate_button next']");
    public final static By DISABLED_NEXT_BUTTON = By.xpath("//a[@class='paginate_button next disabled']");
    public final static int NAME_COLUMN_INDEX = 0;
    public final static int POSITION_COLUMN_INDEX = 1;
    public final static int OFFICE_COLUMN_INDEX = 2;
    public final static int AGE_COLUMN_INDEX = 3;
    public final static int SALARY_COLUMN_INDEX = 5;
}
