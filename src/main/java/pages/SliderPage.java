package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderPage {
    private WebDriver driver;
    private double sliderMinValue = 0.0;
    private double sliderMaxValue = 5.0;

    private By slider = By.cssSelector(".sliderContainer input");
    private By sliderValue = By.id("range");

    public SliderPage(WebDriver driver) {
        this.driver = driver;
    }
/*
Horizontal Slider
Set the focus on the slider (by clicking on it) and use the arrow keys to move it right and left. Or click and drag the slider with your mouse. It will indicate the value of the slider to the right. range 0-5
 */
    public String getSliderValue(){
       return driver.findElement(sliderValue).getText();
    }

    public SliderPage moveSliderByArrowKey(String value){
        while(!getSliderValue().equals(value)){
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
        return this;
    }

    public SliderPage moveSliderByDragging(String value){
        double sliderWidth = driver.findElement(slider).getSize().width;
        int pixelsToMove = (int)(sliderWidth / (sliderMaxValue - sliderMinValue) * (Double.parseDouble(value) - sliderMinValue));
        Actions actions = new Actions(driver);
        //actions.clickAndHold(driver.findElement(slider)).moveByOffset(pixelsToMove, 0).release().perform();
        actions.clickAndHold(driver.findElement(slider)).moveByOffset(20, 0).release().perform();
        return this;
    }
}
