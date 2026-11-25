import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Windows {
    WebDriver driver;
    By ClickHere = By.cssSelector(".example > a");
    By NewWindow = By.cssSelector("body > .example > h3");


    @Test // ERROR
    public void window() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(ClickHere).click();

        System.out.println(driver.findElement(NewWindow).getText());
        // NoSuchElementException --> because driver can not go to that new opened window
        // SO we must Handle Windows
    }

    @Test // Window is Handled
    public void windowHandling() {
        //driver = new ChromeDriver();
        // i will use incognito --> Mainly to close data window that open with me automatically
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); // no extensions, no saved session
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");

        //  Stores the main page (The internet) // So I can get back to it
        String parent = driver.getWindowHandle();

        driver.findElement(ClickHere).click(); // Click TO navigate to New Window

        // Next Line --> store 2 windows(The internet , New Window) The internet in index 0  & New Window in index 1
        String child = driver.getWindowHandles().toArray()[1].toString();

        driver.switchTo().window(child); // switch to that New Window
        System.out.println(driver.findElement(NewWindow).getText()); // Get Text from that New Window

        // Creating New Window --> not related to that test case i am just showing you how to do it
        // driver.switchTo().newWindow(WindowType.TAB).navigate().to("https://www.google.com/");


    }


}

