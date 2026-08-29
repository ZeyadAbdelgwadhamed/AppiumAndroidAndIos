import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragDrop extends BaseTest {



    @Test
    public void userCanDragDrop(){
//        driver.findElement(AppiumBy.accessibilityId("Views")).click();
//        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();

//        Activity activity=new Activity("io.appium.android.apis","io.appium.android.apis.view.DragAndDropDemo}\n" +
//                "  mFocusedApp=ActivityRecord{5a0ca42 u0 io.appium.android.apis/.view.DragAndDropDemo t112}");
//
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
                "intent", "io.appium.android.apis/.view.DragAndDropDemo"
        ));

//        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
//                "component", "io.appium.android.apis/.view.DragAndDropDemo"
//        ));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement element=driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_1\"]"));

        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 710,
                "endY", 627
        ));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String text= driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        DeviceRotation landScap=new DeviceRotation(0,0,90);
        driver.rotate(landScap);
        Assert.assertEquals(text,"Dropped!");

    }
}
