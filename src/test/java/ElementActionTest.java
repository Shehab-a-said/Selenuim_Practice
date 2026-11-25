import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class ElementActionTest {

    //WebDriver driver = new ChromeDriver(); it is gonna be separated
    WebDriver driver; // this part is here So all methods in the class can access the same driver instance

    By username = By.id("inputUsername");    //id Locator
    //By username = new ByChained(By.id("loginForm"), By.id("inputUsername")); //ByChained Locator

    By password = By.id("inputPassword");   //id Locator
    //By password = By.cssSelector("[type=\"password\"]");  //CSS Locator

    //By loginFields = new ByAll(By.id("inputUsername"), By.id("inputPassword")); //ByAll Locator

    By loginButton = By.tagName("button");  //tagName Locator
    //By loginButton = RelativeLocator.with(By.tagName("button")).below(password); // RelativeLocator (below)

    By uploadFile = By.id("regularFileInput");

    //Test Runner
    @Test
    public void testCase() {
        driver = new ChromeDriver();  //open Chrome Browser //this part is here So the actual browser only launches when the test runs

        maximizeWindow();    //Called Function to Max Window
        navigateTo("https://aa-practice-test-automation.vercel.app/index.html"); //Called Function to open Link

        // WebElement username = driver.findElement(By.id("inputUsername"));
        //username.sendKeys("admin");
        //***** Stale Element Reference Exception *****//

        findElement(username).sendKeys("Ahmed"); //wrong username
        findElement(username).clear();  // let's clear it

        findElement(username).sendKeys("admin"); //add the correct username //using wrapping method below
        findElement(password).sendKeys("admin"); //using wrapping method below
        driver.findElement(loginButton).click(); //NOT using wrapping method below

    }

    @Test
    public void UploadFileTC() {
        driver = new ChromeDriver();
        maximizeWindow();
        navigateTo("https://aa-practice-test-automation.vercel.app/index.html");
        findElement(username).sendKeys("admin");
        findElement(password).sendKeys("admin");
        driver.findElement(loginButton).click();

        navigateTo("https://aa-practice-test-automation.vercel.app/Pages/file-operations/uploadFile.html");

        //findElement(uploadFile).sendKeys("D:\\Testing\\Testing Documents\\Automation Code\\Automation sessions Nezam Code\\Selenium    \\src\\test\\resources\\test.txt"); //Absolute PATH IS Wrong don't do that
        String userDirectory = System.getProperty("user.dir"); //user.dir is a variable = each usr directory path (Not fixed)
        //System.out.println("userDirectory"); // this print just to show me (not needed in the code) what user directory returns --> userDirectory --> D:\Testing\Testing Documents\Automation Code\Automation sessions Nezam Code\Selenium
        //File.separator --> //
        findElement(uploadFile).sendKeys(userDirectory + File.separator + "src\\test\\resources\\test.txt");
    }


    //wrapping method --> to stop writing driver.findElement(..) in @test method just findElement(..)
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    //Method to open Link
    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    //Method to Maximize Window
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

}


