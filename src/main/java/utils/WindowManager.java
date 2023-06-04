package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowManager {

    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver){
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack(){
        navigate.back();
    }
    public void goForward(){
        navigate.forward();
    }
    public void refreshPage(){
        navigate.refresh();
    }
    public void goTo(String url){
        navigate.to(url);
    }
    public void switchToTab(String tabtitle){
        var windows = driver.getWindowHandles();

        System.out.println("Number of tabs: " +windows.size());
        System.out.println("Window handles:");
        windows.forEach(System.out::println);
        // loop through windows and list them
        for (String window : windows){
            System.out.println("Switching to window "+window);
            driver.switchTo().window(window);

            System.out.println("Current window title: "+ driver.getTitle());

            if (tabtitle.equals(driver.getTitle())){
                break;
            }
        }
    }

    public void switchToNewWindow() {
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        windowHandles.forEach(window -> {
            if (!window.equals(currentWindowHandle)) {
                driver.switchTo().window(window);
            }
        });
    }

}
