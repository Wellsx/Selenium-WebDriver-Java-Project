package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable(){
        homePage.clickLargeandDeepDom().scrollToTable();
    }
    @Test
    public void testScrollToFifthParagraph(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
    @Test
    public void testSetDropdownOptionTo2(){
        var dropDown = homePage.clickDropDown();
        dropDown.setDropdownOptions();
        String option1 = "Option 1";
        String option2 = "Option 2";
        dropDown.selectFromDropDown(option1);
        dropDown.selectFromDropDown(option2);
        var selectedOptions = dropDown.getSelectedOptions();
        assertEquals(selectedOptions.size(), 2, "Incorrect number of selections");
    }
}
