package interactionTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {
    @Test
    public void testExample2(){
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoading();
        dynamicLoadingPage.loadExample2();
        assertEquals(dynamicLoadingPage.getLoadedText(), "Hello World!", "loaded text is incorrect");
    }
}
