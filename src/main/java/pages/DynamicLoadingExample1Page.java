package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample1Page {

    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadingBar = By.id("loading");
    private By loadedText = By.id("finish");


    public DynamicLoadingExample1Page(WebDriver driver){
        this.driver = driver;
    }

    public void clickStart(){
        driver.findElement(startButton).click();
        // explicit wait WebDriverWait class takes driver and duration
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // wait.until ExpectedConditions class/ invisibilityOf waits for element to disappear
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingBar)));
    }
    public void clickStartFluent(){
        driver.findElement(startButton).click();
        // Fluent wait allows more flexibility by specifying more conditions
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5)) // timeout duration
                .pollingEvery(Duration.ofSeconds(1)) // polling frequency
                .ignoring(NoSuchElementException.class); // ignoring exceptions
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingBar)));
    }
    public String getLoadedText(){
        return driver.findElement(loadedText).getText();
    }
}
