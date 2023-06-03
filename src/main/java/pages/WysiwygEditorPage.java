package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {

    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By increaseIndentButton = By.cssSelector("[title=\"Increase indent\"]");

    public WysiwygEditorPage(WebDriver driver){
        this.driver = driver;
    }

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea(); // exit out of iFrame
    }
    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea(); // exit out of iFrame
    }
    public void increaseIndent(){
        driver.findElement(increaseIndentButton).click();
    }
    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText(); // store text because we are in the iframe
        switchToMainArea(); // switch back to main to return text
        return text;
    }
    // switch to iFrame using .frame string method with ID
    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }
    // switch out of the iFrame
    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}
