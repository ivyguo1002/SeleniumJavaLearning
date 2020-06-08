package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadFilePage {
    private WebDriver driver;
    private By inputFileField = By.id("file-upload");
    private By uploadBtn = By.id("file-submit");
    private By uploadedFile = By.id("uploaded-files");

    public UploadFilePage(WebDriver driver) {
        this.driver = driver;
    }


    public UploadFilePage uploadFile(String absolutePath) {
        driver.findElement(inputFileField).sendKeys(absolutePath);
        driver.findElement(uploadBtn).click();
        return this;
    }

    public String getUploadedFile()
    {
        return driver.findElement(uploadedFile).getText();
    }
}
