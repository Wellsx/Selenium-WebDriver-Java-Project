package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectFromDropDown(String option) {
        //dropdown is not a webelement
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        //store the list of web elements
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        //stream returns sequential stream of elements
        //map with lambda expression, once all text is collected store in a new List, a List of strings
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());

    }
    // helper method
    private Select findDropDownElement(){
        return new Select(driver.findElement(dropdown));
    }
}
