package interactionTests;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class KeyPressTests extends BaseTests {

    @Test
    public void testKeyPress(){
        String result = new HomePage(driver)
                .clickKeyPress()
                .enterText("A" + Keys.BACK_SPACE)
                .getResult();
        assertTrue(result.contains("You entered: BACK_SPACE!"),
                "Result is wrong");
    }

}
