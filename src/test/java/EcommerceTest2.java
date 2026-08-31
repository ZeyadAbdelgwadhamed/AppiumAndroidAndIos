import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class EcommerceTest2 extends BaseTest{
    @Test
    public void UserCanPayItems(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                        + ".scrollIntoView(new UiSelector().text(\"Egypt\"))"
        ));
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Egypt\"]\n")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")).sendKeys("Zezo");
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnLetsShop\")")).click();
        int product= driver.findElements(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().text(\"Jordan 6 Rings\")")).size();

        int i;
        for (i=0; i<product; i++){

            String item= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Jordan 6 Rings\")")).getText();
            if(product) {}

                }

        }


    }
}
