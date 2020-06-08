package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressPage {
    private WebDriver driver;
    private By inputField = By.id("target");
    private By resultText = By.id("result");

    public KeyPressPage(WebDriver driver) {
        this.driver = driver;
    }

    public KeyPressPage enterText(String text){
        driver.findElement(inputField).sendKeys(text);
        return this;
    }

    public KeyPressPage enterPi(){
        driver.findElement(inputField).sendKeys(Keys.chord(Keys.ALT), "p");
        return this;
    }

    public String getResult(){
        return driver.findElement(resultText).getText();
    }

}
