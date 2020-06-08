package interactionTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.InfiniteScrollPage;
import pages.LargeAndDeepDomPage;

public class JavascriptTests extends BaseTests {
    @Test
    public void testScrollToView() throws InterruptedException {
        LargeAndDeepDomPage largeAndDeepDomPage = homePage.clickLargeAndDeepDom();
        largeAndDeepDomPage.scrollToTable();
        Thread.sleep(3000);
    }

    @Test
    public void testScrollTo() throws InterruptedException {
        InfiniteScrollPage infiniteScrollPage = homePage.clickInfiniteScroll();
        infiniteScrollPage.scrollToParagraph(4);
        Thread.sleep(3000);
    }

    @Test
    public void testSetAttribute(){
        //DropdownPage dropdownPage = homePage.clickDropDown();

    }
}
