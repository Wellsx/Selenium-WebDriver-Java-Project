package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;
    // import HomePage
    protected HomePage homePage;
    @BeforeClass // runs before each test class
    public void setUp(){
        //setup webdriver location
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        // wait for 30 seconds until it finds the element
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // wait for a certain amount of time for pages to load
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        // wait for asynchronous actions
        //driver.manage().timeouts().scriptTimeout()
        // navigate to homepage before each test
        goHome();
        // pass the driver to HomePage
        homePage = new HomePage(driver);
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }
    @AfterClass // runs after tests
    public void testCleanUp(){
        driver.quit();
    }

}



