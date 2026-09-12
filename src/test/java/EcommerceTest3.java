import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class EcommerceTest3 extends BaseTest{


    @Test
    public void userCanPayMoreThanOneItem() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                        + ".scrollIntoView(new UiSelector().text(\"Egypt\"))"));
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Egypt\"]\n")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")).sendKeys("Zezo");
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnLetsShop\")")).click();

        driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
        driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        int cardProduct=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();

        double totalPrice=0;
         for(int i=0; i<cardProduct; i++){
             String prePaying =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();

             double price = Double.parseDouble(prePaying.substring(1));
             totalPrice= price+totalPrice;

        }
         String CalculatedAmount= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/totalAmountLbl\")")).getText();
         double calculatedPrice= Double.parseDouble(CalculatedAmount.substring(1));
         Assert.assertEquals(calculatedPrice,totalPrice);
         



    }

}
