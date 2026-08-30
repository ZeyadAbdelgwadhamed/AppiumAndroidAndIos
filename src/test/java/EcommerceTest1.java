import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class EcommerceTest1 extends BaseTest{

    @Test
    public void userCanSignInApp(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Egypt\")"));
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Egypt\"]\n")).click();
    }
}
