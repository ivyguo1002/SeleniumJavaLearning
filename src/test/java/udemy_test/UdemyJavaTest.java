package udemy_test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class UdemyJavaTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testPractice1() {
        driver.get("https://www.cleartrip.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("RoundTrip")).click();
        driver.findElement(By.id("FromTag")).sendKeys("Auckland");
        driver.findElement(By.id("FromTag")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.id("FromTag")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("ToTag")).sendKeys("Wellington");
        driver.findElement(By.id("ToTag")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.id("ToTag")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("FromDate")).sendKeys("13/08/2020");
        driver.findElement(By.id("DepartDate")).sendKeys("Thu, 21 May, 2020");
        driver.findElement(By.id("ToDate")).sendKeys("14/08/2020");
        new Select(driver.findElement(By.id("Adults"))).selectByValue("2");
        new Select(driver.findElement(By.id("Childrens"))).selectByValue("2");
        new Select(driver.findElement(By.id("Infants"))).selectByValue("1");
        driver.findElement(By.id("MoreOptionsLink")).click();
        new Select(driver.findElement(By.id("Class"))).selectByValue("Business");
        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Air");
        driver.findElement(By.id("SearchBtn")).click();


    }

    @Test
    public void testCarts() throws InterruptedException {
// TODO Auto-generated method stub
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);
        addItems(driver, itemsNeeded);
        //implicit wait
        //driver.manage().timeouts().implicitlyWait();
        Wait<WebDriver> w = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        var wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
//explicit wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

    }

    public void addItems(WebDriver driver, String[] itemsNeeded) {
        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {
//Brocolli - 1 Kg
//Brocolli,    1 kg
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
//format it to get actual vegetable name
//convert array into array list for easy search
//  check whether name you extracted is present in arrayList or not-
            List itemsNeededList = Arrays.asList(itemsNeeded);
            if (itemsNeededList.contains(formattedName)) {
                j++;
//click on Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == itemsNeeded.length) {
                    break;

                }

            }

        }
    }

    @Test
    public void TestNewTab() {
        driver.get("http://qaclickacademy.com/practice.php");
        System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));// Limiting webdriver scope
        System.out.println(footerdriver.findElements(By.tagName("a")).size());
        //3-
        WebElement coloumndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(coloumndriver.findElements(By.tagName("a")).size());
        //4- click on each link in the coloumn and check if the pages are opening-
        for (int i = 1; i < coloumndriver.findElements(By.tagName("a")).size(); i++) {
            String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
            //Thread.sleep(5000L);
        }// opens all the tabs
        Set<String> abc = driver.getWindowHandles();//4
        Iterator<String> it = abc.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());

        }


    }

    @Test
    public void TestCalendar() {
        driver.get("https://www.path2usa.com/travel-companions");
//April 23
        driver.findElement(By.xpath(".//*[@id='travel_date']")).click();
        while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May")) {
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }
        List<WebElement> dates = driver.findElements(By.className("day"));
//Grab common attribute//Put into list and iterate
        int count = driver.findElements(By.className("day")).size();
        for (int i = 0; i < count; i++) {
            String text = driver.findElements(By.className("day")).get(i).getText();
            if (text.equalsIgnoreCase("21")) {
                driver.findElements(By.className("day")).get(i).click();
                break;
            }

        }
    }

    @Test
    public void TestTables() {
        // TODO Auto-generated method stub
        int sum = 0;
        driver.get("http://www.cricbuzz.com/live-cricket-scorecard/18970/pak-vs-sl-2nd-t20i-pakistan-v-sri-lanka-in-uae-2017");
        WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
        int rowcount = table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
        int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
        for (int i = 0; i < count - 2; i++) {
            String value = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
            int valueinteger = Integer.parseInt(value);
            sum = sum + valueinteger;//103
        }
//System.out.println(sum);
        String Extras = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
        int extrasValue = Integer.parseInt(Extras);
        int TotalSumValue = sum + extrasValue;
        System.out.println(TotalSumValue);
        String ActualTotal = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
        int ActualTotalVAlue = Integer.parseInt(ActualTotal);
        if (ActualTotalVAlue == TotalSumValue) {
            System.out.println("Count Matches");
        } else {
            System.out.println("count fails");
        }
    }

    @Test
    public void TestTablePractice() {
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        var table = driver.findElement(By.id("product"));
        var rows = table.findElements(By.tagName("tr"));
        System.out.println("number of rows: " + rows.size());
        var thirdRow = rows.get(2);
        var columns = thirdRow.findElements(By.tagName("td"));
        for (var column : columns) {
            System.out.println(column.getText() + "\n");
        }
    }

    @Test
    public void TestAutoComplete() throws InterruptedException {
        driver.get("https://www.ksrtc.in");
        driver.findElement(By.id("fromPlaceName")).sendKeys("BENG");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ARROW_DOWN);
        System.out.println(driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText());
//Javascript DOM can extract hidden elements
//because selenium cannot identify hidden elements - (Ajax implementation)
//investigate the properties of object if it have any hidden text
//JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //String script = "return document.getElementById(\"fromPlaceName\").value;";
        String script = "return document.getElementById(\"fromPlaceName\").getAttribute(\"value\");";
        String text = (String) js.executeScript(script);
        System.out.println(text);
        int i = 0;
//BENGALURU INTERNATION AIPORT
        while (!text.equalsIgnoreCase("BENGALURU INTATION AIPORT")) {
            i++;
            driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
            text = (String) js.executeScript(script);
            System.out.println(text);
            if (i > 10) {
                break;
            }

        }
        if (i > 10) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element  found");
        }
    }

    @Test
    public void TestManager() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //	driver.manage().deleteCookieNamed("sessionKey");
        //click on any link
        //login page- verify login url
        driver.get("http://google.com");
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.move(src, new File("resources/screenshots/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileUtils.moveFile(src, new File("C:\\Users\\rahul\\screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestSortTableColumn() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
        driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();

        List<WebElement> firstColList = driver.findElements(By.cssSelector("tr td:nth-child(2)"));
        ArrayList<String> originalList = new ArrayList<String>();
        for (int i = 0; i < firstColList.size(); i++) {
            originalList.add(firstColList.get(i).getText());
        }

        ArrayList<String> copiedList = new ArrayList<String>();

        for (int i = 0; i < originalList.size(); i++) {
            copiedList.add(originalList.get(i));
        }
//string
        Collections.sort(copiedList);

// Collections.reverse(copiedList);
        for (String s1 : originalList) {
            System.out.println(s1);
        }
        System.out.println("*******************");
        for (String s2 : copiedList) {
            System.out.println(s2);
        }
        Assert.assertTrue(originalList.equals(copiedList));
    }
    @Test
    public void TestGrid() {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome");
        dc.setPlatform(Platform.WINDOWS);
//dc.se
//Webdriver driver=new ChromeDriver();
        try{
            WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
        }catch(MalformedURLException e){
            e.printStackTrace();
        }

        driver.get("http://rediff.com");
//
    }
    @Test
    public void TestAppium() {
        File appDir = new File("resources");
        File app = new File(appDir, "ApiDemos.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "demo");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestReport(){

    }
}



