package slider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void testsHorizontalSlider(){
        var horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.moveSlider("4");
        assertEquals(horizontalSliderPage.getSliderValue(), "4", "Slider value is incorrect");
    }
}
