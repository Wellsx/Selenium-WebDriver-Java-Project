package base;

import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.CookieManager;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    private WebDriver driver;

    // import HomePage
    protected HomePage homePage;
    @BeforeClass // runs before each test class
    public void setUp(){
        //setup webdriver location
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
        // wait for 30 seconds until it finds the element
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // wait for a certain amount of time for pages to load
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        // wait for asynchronous actions
        //driver.manage().timeouts().scriptTimeout()
        // navigate to homepage before each test
        goHome();
        setCookie();
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

    @AfterMethod
    public void recordFailure(ITestResult result){
        // cast driver to screenshot class
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            System.out.println("Screenshot taken: "+ screenshot.getAbsolutePath());
            try{
                Files.move(screenshot,
                        new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
    public CookieManager getCookieManager(){
        return new CookieManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true);
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("Test", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
}



