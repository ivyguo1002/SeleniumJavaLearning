package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage {
    private WebDriver driver;
    private By alertBtn = By.xpath("//button[contains(., 'Alert')]");
    private By confirmBtn = By.xpath("//button[contains(., 'Confirm')]");
    private  By promptBtn = By.xpath("//button[contains(., 'Prompt')]");
    private By result = By.id("result");
    @FindBy (xpath = "//button[contains(., 'Alert')]")
    WebElement alertButton;


    public AlertPage(WebDriver driver){
        this.driver = driver;
    }

    public AlertPage triggerAlert(){
        driver.findElement(alertBtn).click();
        return this;
    }
    public String alertGetAlertMessage(){
        return driver.switchTo().alert().getText();
    }
    public AlertPage alertClickAccept(){
        driver.switchTo().alert().accept();
        return this;
    }

    public String getResult(){
        return driver.findElement(result).getText();
    }

    public AlertPage triggerConfirm() {
        driver.findElement(confirmBtn).click();
        return this;
    }

    public AlertPage alertClickDismiss(){
        driver.switchTo().alert().dismiss();
        return this;
    }

    public AlertPage triggerPrompt() {
        driver.findElement(promptBtn).click();
        return this;
    }

    public AlertPage alertSetInput(String value){
        driver.switchTo().alert().sendKeys(value);
        return this;
    }
}
