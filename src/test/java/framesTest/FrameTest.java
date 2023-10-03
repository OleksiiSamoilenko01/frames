package framesTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class FrameTest extends BaseTestClass {
    String URL = "https://the-internet.herokuapp.com/nested_frames";

    @DataProvider
    public Object[][] frameData() {
        return new Object[][] {
                {"frame-left", "LEFT"},
                {"frame-middle", "MIDDLE"},
                {"frame-right", "RIGHT"}
        };
    }

    @Test(dataProvider = "frameData" )
    public void allFrames(String frame, String expectedResult){
        driver.get(URL);
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame(frame);

        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, expectedResult);

    }

}
