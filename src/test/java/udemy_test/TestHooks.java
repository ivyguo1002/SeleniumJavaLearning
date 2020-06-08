package udemy_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestHooks {
    @BeforeMethod
    public void UseridGeneration()
    {
        System.out.println("This block executes before each Test");
    }
    @BeforeTest
    public void Cookies()
    {
        System.out.println("This block executes Before all  Testcases");
        //delete cookies
    }
    @AfterTest
    public void Cookiesclose()
    {
        System.out.println("This block executes after all  Testcases");
        //close the browesers
    }
    @AfterMethod
    public void Reportadding()
    {
        System.out.println("This block executes after each Test");
    }
    @Parameters({ "URL" , "APIKey"})
    @Test(groups={"smoke"})
    public void OpeningBrowser(String urlName, String apiKey)
    {
        //This opens the Browser
        System.out.println(urlName);
        System.out.println(apiKey);
        System.out.println("Executing Test 2");
        WebDriver driver;
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("resources/test.properties")));
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        var browserType = System.getProperty("browser");
        if (browserType.equals("chrome")){
            driver = new ChromeDriver();
        }
    }

    @Test(dataProvider = "getData")
    public void FlightBooking(String firstname, String password)
    {
        System.out.println("Executing Test 1");
        System.out.println(firstname);
        System.out.println(password);
    }

    @Test
    public void FlightCancel()
    {
        System.out.println("Executing Test Priority 2");
        Assert.fail();
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[2][2];
        data[0][0] = "firstusername";
        data[0][1] = "firstpassword";
        data[1][0] = "secondusername";
        data[1][1] = "secondpassword";
        return data;
    }
}
