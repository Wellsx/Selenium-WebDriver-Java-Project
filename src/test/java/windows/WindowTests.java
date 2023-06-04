package windows;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class WindowTests extends BaseTests {

    @Test
    public void testOpenNewWindow(){
        var dynamicLoadingPage = homePage.clickDynamicLoading();
        var example2 = dynamicLoadingPage.openExample2InNewTab();
        getWindowManager().switchToNewWindow();
        example2.getStart();
        assertTrue(example2.getStart(), "Start button is not displayed");






    }
}
