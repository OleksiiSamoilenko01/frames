package framesTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import java.util.List;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameTest extends BaseTestClass {
    String URL = "https://the-internet.herokuapp.com/nested_frames";

    @Test
    public void allFrames(){
        driver.get(URL);
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        String body = driver.findElement(By.xpath("//body[contains(text(),\"LEFT\")]")).getText();
        Assert.assertEquals(body, "LEFT");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        String middle = driver.findElement(By.xpath("//body/div[@id = \"content\"]")).getText();
        Assert.assertEquals(middle, "MIDDLE");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");

        String right = driver.findElement(By.xpath("//body[contains(text(),\"RIGHT\")]")).getText();
        Assert.assertEquals(right, "RIGHT");

    }

}
