package interactionTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {
    @Test
    public void testContextMenu(){
        ContextMenuPage contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickInBox();
        assertEquals(contextMenuPage.getAlertText(), "You selected a context menu", "message incorrect");
        contextMenuPage.alertClickAccept();
    }
}
