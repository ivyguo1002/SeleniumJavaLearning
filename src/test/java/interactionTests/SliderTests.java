package interactionTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SliderPage;

import static org.testng.Assert.assertEquals;

public class SliderTests extends BaseTests {
    @Test
    public void testSlider1(){
        SliderPage sliderPage = new HomePage(driver).clickHorizontalSlider();
        sliderPage.moveSliderByArrowKey("4");
        assertEquals(sliderPage.getSliderValue(), "4", "slider value is incorrect");
    }

    @Test
    public void testSlider2(){
        SliderPage sliderPage = new HomePage(driver).clickHorizontalSlider();
        sliderPage.moveSliderByDragging("4");
        assertEquals(sliderPage.getSliderValue(), "4", "slider value is incorrect");
    }
}
