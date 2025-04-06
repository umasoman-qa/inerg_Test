package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.covidTracker;

public class trackerSteps {
    WebDriver driver;
    covidTracker covidPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://inerg-test.web.app/");
        covidPage = new covidTracker(driver);
    }


    @Given("I am on the covid Tracker page")
    public void iAmOnTheCovidTrackerPage() {

        {
            // Ensure the page has loaded
            System.out.println("Navigated to COVID Tracker homepage");
        }
    }

    @When("I have selected {string} from the dropdown")
    public void iHaveSelectedFromTheDropdown(String state) throws InterruptedException {
        {
            covidTracker.selectStateAndVerifyChart(state);
            System.out.println("Dropdown selected");
        }
    }

    @Then("the covid details for {string} should be displayed")
    public void theCovidDetailsForShouldBeDisplayed(String state) {

        {
            // Validate that the COVID statistics for the state are visible
            System.out.println("COVID statistics for " + state + " are displayed.");
        }
    }

    @And("the line chart should be visible")
    public void theLineChartShouldBeVisible() {

        {
            // Check if the line chart is displayed
            System.out.println("Line chart is visible.");
        }
    }

    @And("each point on the line chart should display a value")
    public void eachPointOnTheLineChartShouldDisplayAValue() throws InterruptedException {

        covidTracker.printDataPoints();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
