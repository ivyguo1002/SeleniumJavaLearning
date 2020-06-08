package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import util.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseTests {
    public WebDriver driver;
    public HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        //1 - Maximize the window
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }
    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
//    public void setUp(){
//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/");
//        //1 - Maximize the window
//        driver.manage().window().maximize();
//
//        //2 - Fullscreen mode
//        driver.manage().window().fullscreen();
//
//        //3 - Specific width (show Chrome iPhoneX emulator)
//        Dimension size = new Dimension(375, 812);
//        driver.manage().window().setSize(size);
//
//        System.out.println(driver.getTitle());
//        driver.quit();
//    }
//
//    public void elementPractice(){
//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/");
//        driver.manage().window().maximize();
//        WebElement shiftContentLink = driver.findElement(By.linkText("Shifting Content"));
//        shiftContentLink.click();
//        WebElement menuElementLink = driver.findElement(By.partialLinkText("Menu"));
//        menuElementLink.click();
//        List<WebElement> elementList = driver.findElements(By.tagName("li"));
//        System.out.println(elementList.size());
//        driver.quit();
//    }
//    public static void main(String args[]){
//        BaseTests test = new BaseTests();
//        test.elementPractice();
//    }


}
