import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShots {
    WebDriver driver;

    @Test //take screenshot for page
    public void TakeScreenShotForPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        // initialize the TakesScreenshot interface and cast the WebDriver instance to it
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Take the screenshot for page and store it as a file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Specify the destination path where the screenshot will be saved
        File FileDestination = new File("src/test/resources/screenshot.png");

        // Copy the screenshot to the destination path + Handle any exceptions that may occur during the file copy operation
        try {
            FileUtils.copyFile(srcFile, FileDestination);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }

    }

    //take screenshot for element
    @Test
    public void TakeScreenShotForElement() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        // TakesScreenshot screenshot = (TakesScreenshot) driver;
        // Not needed for element screenshot because WebElement has its own getScreenshotAs method
        // we have two different getscreenshotAs methods, one for WebDriver and one for WebElement.
        //same method name but different implementation for each interface

        File srcFile = driver.findElement(By.cssSelector("svg.ESTs9d")).getScreenshotAs(OutputType.FILE); //get screenshot for element and store it as a file
        File FileDestination = new File("src/test/resources/screenshotElement.png"); // Specify the destination path where the screenshot will be saved

        // Copy the screenshot to the destination path + Handle any exceptions that may occur during the file copy operation
        try {
            FileUtils.copyFile(srcFile, FileDestination);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
