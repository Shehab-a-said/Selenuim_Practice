import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Frames {
    WebDriver driver;
    By LeftFrame = By.xpath("//*[contains(text(),\"LEFT\")]");
    By MiddleFrame = By.id("content");
    By BottomFrame = By.xpath("//*[contains(text(),\"BOTTOM\")]");


    @Test
    public void NestedFrames() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver
                .switchTo().frame("frame-top")
                .switchTo().frame("frame-left");
        String LeftText = driver.findElement(LeftFrame).getText();
        System.out.println("Text in left Frame =  " + LeftText);

        driver
                .switchTo().defaultContent()
                .switchTo().frame("frame-top")
                .switchTo().frame("frame-middle");
        String MiddleText = driver.findElement(MiddleFrame).getText();
        System.out.println("Text in Middle Frame =  " + MiddleText);

        driver
                .switchTo().defaultContent()
                .switchTo().frame("frame-bottom");
        String BottomText = driver.findElement(BottomFrame).getText();
        System.out.println("Text in Bottom Frame =  " + BottomText);

    }

}
