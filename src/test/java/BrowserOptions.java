import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BrowserOptions {
    WebDriver driver;

    @Test
    public void BrowserOptionsTC() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "incognito");
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
    }
}
