package visualtests;

import base.BaseTests2;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VisualTests extends BaseTests2 {
    @Test
    public void testSearchByFullTitle(){
        String title = "Agile Testing";
        page.search(title);
        //Assert.assertTrue("Book not found: " + title, page.isBookVisible(title));
        validateWindow();
    }

    @Test
    public void testSearchByFullTitle_Element(){
        page.search("Agile Testing");
        validateElement(By.id("pid3"));
        Assert.assertEquals(
                1, page.getNumberOfVisibleBooks(), "Number of books returned");
    }

}
