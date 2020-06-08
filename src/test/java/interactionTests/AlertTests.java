package interactionTests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AlertTests extends BaseTests {
    @Test
    public void testAlertAccept(){
        AlertPage alertPage= new HomePage(driver).clickJavascriptAlert();
        String message = alertPage.triggerAlert().alertGetAlertMessage();
        assertTrue(message.contains("I am a JS Alert"), "message is incorrect");
        alertPage.alertClickAccept();
        Assert.assertEquals(alertPage.getResult(), "You successfuly clicked an alert", "Results text incorrect");
    }

    @Test
    public void testAlertDismiss(){
        AlertPage alertPage = new HomePage(driver).clickJavascriptAlert();
        alertPage.triggerConfirm().alertClickDismiss();
        assertEquals(alertPage.getResult(), "You clicked: Cancel", "messsage is incorrect");
    }

    @Test
    public void testAlertInput(){
        AlertPage alertPage = new HomePage(driver).clickJavascriptAlert();
        alertPage.triggerPrompt().alertSetInput("Rocks").alertClickAccept();
        assertEquals(alertPage.getResult(), "You entered: Rocks", "message is incorrect");
    }
}
