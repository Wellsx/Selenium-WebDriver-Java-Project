package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
