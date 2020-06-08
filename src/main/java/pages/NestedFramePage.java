package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramePage {

    private final WebDriver driver;
    private String topFrameName = "frame-top";

    private String bottomFrameName = "frame-bottom";
    private String leftFrameName = "frame-left";


    public NestedFramePage(WebDriver driver) {
        this.driver = driver;
    }

    public NestedFramePage switchToFrame(String frameName){
        driver.switchTo().frame(frameName);
        return this;
    }

    public NestedFramePage switchToParent(){
        driver.switchTo().parentFrame();
        return this;
    }

    public String getFrameText(){
        return driver.findElement(By.tagName("body")).getText();
    }

    public String getTopLeftFrameText(){
        switchToFrame(topFrameName);
        switchToFrame(leftFrameName);
        String text = getFrameText();
        switchToParent();
        switchToParent();
        return text;
    }

    public String getBottomFrameText(){
        switchToFrame(bottomFrameName);
        String text = getFrameText();
        switchToParent();
        return text;
    }

}
