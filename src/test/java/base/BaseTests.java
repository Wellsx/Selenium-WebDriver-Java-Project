package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.List;

public class BaseTests {

    private WebDriver driver;
    // import HomePage
    protected HomePage homePage;
    @BeforeClass // runs before each test class
    public void setUp(){
        //setup webdriver location
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
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



