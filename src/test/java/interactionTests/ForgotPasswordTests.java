package interactionTests;

import base.BaseTests;
import com.google.common.annotations.VisibleForTesting;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class ForgotPasswordTests extends BaseTests {
    @Test
    public void testForgotPassword(){
        HomePage homePage = new HomePage(driver);
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
        EmailSentPage emailSentPage = forgotPasswordPage.retrievePassword("TAU@example.com");
        assertTrue(emailSentPage.getMessage().contains("Your e-mail's been sent!"),
                "Email hasn't been sent");
    }



}
