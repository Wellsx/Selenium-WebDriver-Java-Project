package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DynamicLoadingPage {

    private WebDriver driver;
    private By example1 = By.xpath("/html/body/div[2]/div/div/a[1]");
    private By example2 = By.xpath("/html/body/div[2]/div/div/a[2]");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicLoadingExample1Page clickExample1(){
        driver.findElement(example1).click();
        return new DynamicLoadingExample1Page(driver);
    }
    public DynamicLoadingExample2Page clickExample2(){
        driver.findElement(example2).click();
        return new DynamicLoadingExample2Page(driver);
    }
    public DynamicLoadingExample2Page openExample2InNewTab(){
        Actions actions = new Actions(driver);
        WebElement link = driver.findElement(example2);
        actions.keyDown(Keys.CONTROL).click(link).perform();
        return new DynamicLoadingExample2Page(driver);

    }
}
