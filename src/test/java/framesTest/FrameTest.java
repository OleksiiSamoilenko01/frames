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
                {"frame-top","frame-left", "LEFT"},
                {"frame-top","frame-middle", "MIDDLE"},
                {"frame-top","frame-right", "RIGHT"}
        };
    }

    @Test(dataProvider = "frameData" )
    public void allFrames(String top, String frame, String expectedResult){
        driver.get(URL);
        driver.switchTo().frame(top);
        driver.switchTo().frame(frame);

        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, expectedResult);

    }

}
