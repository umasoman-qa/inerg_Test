package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;
import java.util.List;

public class covidTracker extends basePage {
    static WebDriver driver;

    public covidTracker(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    // Method to select state and verify chart visibility
    public static void selectStateAndVerifyChart(String stateName) throws InterruptedException {

//       WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
//       wait.until(ExpectedConditions.elementToBeClickable(stateDropdown));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement stateDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='data-filter-input']")));
        Select select = new Select(stateDropdown);
        select.selectByValue(stateName);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement lineChart = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='graph-representation'][2]")));

        selectState(stateDropdown, stateName);

    }

    // Method to print all data points from the line chart
    public static void printDataPoints() throws InterruptedException {


        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement svg = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='graph-representation'][2]")));
        // Scroll to the element using JavaScript (scroll to the graph section)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight/2);");

        // Verify the visibility of the line chart
        if (svg.isDisplayed()) {
            System.out.println("Line Chart is visible.");
        } else {
            System.out.println("Line Chart is not visible.");
        }

        List<WebElement> dataPoints = svg.findElements(By.cssSelector(".js-plotly-plot .scatter .points path"));

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.visibilityOfAllElements(dataPoints));
        System.out.println("Found " + dataPoints.size() + " data points");
        for (WebElement point : dataPoints) {
            String xValue = point.getAttribute("cx");
            String yValue = point.getAttribute("cy");
            System.out.println("Point : x=" + xValue + ", y=" + yValue);

        }

        }

    }

