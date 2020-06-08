package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DynamicLoadingPage {
    private final WebDriver driver;
    private By example2Link = By.partialLinkText("Example 2");
    private By startBtn = By.cssSelector("#start button");
    private By result = By.id("finish");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicLoadingPage loadExample2(){
        driver.findElement(example2Link).click();
        driver.findElement(startBtn).click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(result));
        return this;
    }

    public String getLoadedText(){
        return driver.findElement(result).getText();
    }

    public Example2Page openExample2InNewTab(){
        var actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(driver.findElement(example2Link)).keyUp(Keys.CONTROL).perform();
        return new Example2Page(driver);
    }

}
