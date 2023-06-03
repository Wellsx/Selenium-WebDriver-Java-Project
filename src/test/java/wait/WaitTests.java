package wait;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {

    @Test
    public void testWaitUntilHidden(){
        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(), "Hello World!", "Loaded text incorrect");
    }
    @Test
    public void testWaitUntilHiddenFluently(){
        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStartFluent();
        assertEquals(loadingPage.getLoadedText(), "Hello World!", "Loaded text incorrect");

    }
    @Test
    public void testWaitUntilElementLocated(){
        var loadingPage = homePage.clickDynamicLoading().clickExample2();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(), "Hello World!", "Loaded text not found");
    }
}
