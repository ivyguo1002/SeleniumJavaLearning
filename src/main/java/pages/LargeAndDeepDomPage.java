package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage {
    private final WebDriver driver;
    private By table = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver driver) {
        this.driver = driver;
    }

    public LargeAndDeepDomPage scrollToView(WebElement element)
    {
        String script = "arguments[0].scrollIntoView()";
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript(script, element);
        return this;
    }

    public LargeAndDeepDomPage scrollToTable(){
        WebElement tableElement = driver.findElement(table);
        scrollToView(tableElement);
        return this;
    }
}
