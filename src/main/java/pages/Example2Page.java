package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Example2Page {
    private WebDriver driver;
    private By startBtn = By.cssSelector("#start button");

    public Example2Page(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isStartButtonDisplayed(){
        return driver.findElement(startBtn).isDisplayed();
    }
}
