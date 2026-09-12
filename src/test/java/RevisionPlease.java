import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class RevisionPlease extends BaseTest{

    @Test
    public void UserCanPayItems(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                        + ".scrollIntoView(new UiSelector().text(\"Egypt\"))"));
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Egypt\"]\n")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")).sendKeys("Zezo");
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnLetsShop\")")).click();

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                        + ".scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"));"
        ));

        driver.findElement(By.xpath(
                "//*[contains(@text,'Jordan 6 Rings')]"
                        + "/ancestor::android.view.ViewGroup[1]"
                        + "//*[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));


        int productList = driver.findElements(By.id("com.androidsample.generalstore:id/productImage")).size();
        for (int i=0; i<productList; i++  )
        {
            String productName=driver.findElements(By.id("com.androidsample.generalstore:id/productImage")).get(i).getText();
            if (productName.equalsIgnoreCase("Jordan 6 Rings")){
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();}
        }
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.FrameLayout\").instance(3)")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));

        String cardProductName=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        System.out.println(cardProductName);
        Assert.assertEquals(cardProductName,"Jordan 6 Rings");
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));


    }
}
