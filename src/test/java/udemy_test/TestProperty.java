package udemy_test;

import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;

public class TestProperty {
    @Test
    public void TestPropertySetting() throws IOException {
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("resources/test.properties")));
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        //System.out.println(props.getProperty("webdriver.chrome.driver"));
        System.out.println(System.getProperty("webdriver.chrome.driver"));

//        props.setProperty("testItem", "123");
//        FileOutputStream fos = new FileOutputStream(new File("resources/test.properties"));
//        props.store(fos, null);
    }
}
