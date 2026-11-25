import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class JsExecutor {
    WebDriver driver;

    @Test //Scroll to Element Using JS Executor
    public void JsExecutorTC() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/");

        ((JavascriptExecutor) driver).
                executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("[target=\"_blank\"]")));

        //Casting driver to JavascriptExecutor --> So I can use JS Executor methods
        //arguments[0] --> first element in the list of elements
        //List of elements is --> the list of arguments after the script
        //scrollIntoView(true) --> scroll to that element

    }
}
