package interactionTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.NestedFramePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FrameTests extends BaseTests {
    @Test
    public void testFrame(){
        NestedFramePage nestedFramePage = homePage.clickNestedFrame();
        assertEquals(nestedFramePage.getTopLeftFrameText(), "LEFT", "text is incorrect");
        assertEquals(nestedFramePage.getBottomFrameText(), "BOTTOM", "text is incorrect");

    }
}
