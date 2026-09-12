import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    AppiumDriverLocalService service;
    AndroidDriver driver;

    @BeforeClass
    public void startSession(){
        //Android
        // create android driver and start appium script
        // the same at ios if we need to start ios we need to create the ios driver have the appium server and
        service=new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("Pixel 9 Pro");
//        options.setApp("src//main//resources//ApiDemos-debug.apk");
        options.setApp("src/main/resources/General-Store.apk");

        driver =new AndroidDriver(service,options);
    }

    @AfterClass
    public void stopSession(){

        driver.quit();
        service.stop();
    }

    public void longPress(WebElement element,int duration ){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", 3000
        ));
    }

    public void userCanScrollByGoogleEngin(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"
        ));
    }

    public void userCanScrollToPageEnd(){
        boolean canScrollMore;
                 do {
                      canScrollMore =(Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                              "left", 200, "top", 200, "width", 200, "height", 200,
                              "direction", "down",
                              "percent", 3.0
                      ));
                   }
                 while(canScrollMore);
    }
}
