package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntryAdPage {
    private WebDriver driver;
    private By modalTitle = By.cssSelector(".modal-title h3");
    private By modalCloseLink = By.className("modal-footer");

    public EntryAdPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getModalTitle(){
        return driver.findElement(modalTitle).getText();
    }

    public EntryAdPage closeModal(){
        driver.findElement(modalCloseLink).click();
        return this;
    }
}
