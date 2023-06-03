package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextMenuClick(){
        var contextMenu = homePage.clickContextMenu();
        contextMenu.rightClickContextBox();
        String text = contextMenu.getAlertText();
        assertEquals(text, "You selected a context menu", "Text doesn't match");
        contextMenu.clickAlertOk();
    }

}
