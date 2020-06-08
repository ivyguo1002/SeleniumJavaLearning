package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By emailTextBox = By.id("email");
    private By retrievePasswordBtn = By.id("form_submit");

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public EmailSentPage retrievePassword(String email) {
        driver.findElement(emailTextBox).sendKeys(email);
        driver.findElement(retrievePasswordBtn).click();
        return new EmailSentPage(driver);
    }
}
