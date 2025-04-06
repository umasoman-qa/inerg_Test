package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class basePage {

    WebDriver driver;

    public basePage(WebDriver driver) {
        this.driver = driver;
    }

    // Function to select a state from the dropdown
    public static void selectState(WebElement stateDropdown, String stateName) {
        Select select = new Select(stateDropdown);
        select.selectByValue(stateName);
    }
}

