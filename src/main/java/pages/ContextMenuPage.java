package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    private WebDriver driver;
    private By box = By.id("hot-spot");
    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public ContextMenuPage rightClickInBox(){
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(box)).perform();
        return this;
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public ContextMenuPage alertClickAccept(){
        driver.switchTo().alert().accept();
        return this;
    }

//    public ContextMenuPage getJavascriptProperty(){
//        //driver.findElement(box).getScreenshotAs()
//    }
}
