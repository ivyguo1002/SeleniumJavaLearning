package interactionTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EntryAdPage;

import static org.testng.Assert.assertEquals;

public class ModalTests extends BaseTests {
    @Test
    public void testModal() throws InterruptedException {
        EntryAdPage entryAdPage = homePage.clickEntryAd();
        Thread.sleep(3000);
        assertEquals(entryAdPage.getModalTitle(), "THIS IS A MODAL WINDOW", "title is wrong");
        entryAdPage.closeModal();
    }

}
