package interactionTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.UploadFilePage;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {
    @Test
    public void testUploadFile(){
        UploadFilePage uploadFilePage = homePage.clickFileUpload();
        uploadFilePage.uploadFile("C:\\Ivy\\source\\Java\\WebDriver\\resources\\chromedriver.exe");
        assertEquals(uploadFilePage.getUploadedFile(), "chromedriver.exe", "uploaded file incorrect");
    }
}
