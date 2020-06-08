package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private final WebDriver driver;
    private By paragraphs = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    public InfiniteScrollPage scrollToParagraph(int index){
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        while(getNumberOfParagraphsPresent() < index){
            jsExecutor.executeScript(script);
        }
        return this;
    }

    private int getNumberOfParagraphsPresent() {
       return driver.findElements(paragraphs).size();
    }
}
