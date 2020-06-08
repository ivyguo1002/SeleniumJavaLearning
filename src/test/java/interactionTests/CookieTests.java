package interactionTests;

import base.BaseTests;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertFalse;

public class CookieTests extends BaseTests {
    @Test
    public void deleteCookie(){

        String cookieToDelete = "optimizelyBuckets";
        driver.manage().deleteCookieNamed(cookieToDelete);
        var cookies = driver.manage().getCookies();
        assertFalse(isCookieExisting(cookieToDelete, cookies));
    }

    private boolean isCookieExisting(String cookieToDelete, Set<Cookie> cookies) {
        for(Cookie cookie : cookies){
            if(cookie.getName().equals(cookieToDelete))
                return true;
        }
        return false;
    }
}
