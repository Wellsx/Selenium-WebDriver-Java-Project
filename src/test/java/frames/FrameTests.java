package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwyg(){
        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();
        String text1 = "Hello ";
        String text2 = "World!";

        editorPage.setTextArea(text1);
        editorPage.increaseIndent();
        editorPage.setTextArea(text2);

        assertEquals(editorPage.getTextFromEditor(), text1+text2, "text doesnt match");
    }

    @Test
    public void testFrameText() {
        var nestedFramesPage = homePage.clickFrames().clickNestedFrames();
        assertEquals(nestedFramesPage.getLeftFrameText(), "LEFT", "Left text not found");
        assertEquals(nestedFramesPage.getBottomFrameText(), "BOTTOM", "Bottom text not found");
    }
}
