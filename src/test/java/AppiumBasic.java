import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import net.bytebuddy.NamingStrategy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppiumBasic extends BaseTest{


    @Test
    public void startAppium(){

        //testing
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]")).click();
        String text = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(text,"WiFi settings");
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("zeyad");
        driver.findElement(AppiumBy.id("android:id/button1")).click();

    }

}
