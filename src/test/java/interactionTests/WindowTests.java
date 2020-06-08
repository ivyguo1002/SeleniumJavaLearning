package interactionTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;

import static org.testng.Assert.assertTrue;

public class WindowTests extends BaseTests {
    @Test
    public void testSwitchWindow(){
        var example2Page = homePage.clickDynamicLoading().openExample2InNewTab();
        getWindowManager().switchToNewTab();
        assertTrue(example2Page.isStartButtonDisplayed(), "start button not displayed");
    }
}
