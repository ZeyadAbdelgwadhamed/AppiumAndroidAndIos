import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class Scroll extends BaseTest{

    @Test
    public void UserCanScroll(){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
//             userCanScrollByGoogleEngin("WebView");
             userCanScrollToPageEnd();

    }


}
