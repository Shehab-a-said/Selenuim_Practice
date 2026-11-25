import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Alerts {
    WebDriver driver;
    By JSAlert = By.cssSelector("[onclick=\"jsAlert()\"]");
    By JSConfirm = By.cssSelector("[onclick=\"jsConfirm()\"]");
    By JSPrompt = By.cssSelector("[onclick=\"jsPrompt()\"]");

    @Test
    public void ClickConfirmToAlert() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(JSAlert).click();
        driver.switchTo().alert().accept(); // Result in UI -->  You successfully clicked an alert
    }

    @Test
    public void getMessageFromAlert() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(JSAlert).click();
        String TextInAlert = driver.switchTo().alert().getText();
        System.out.println(TextInAlert);  // Message in alert is printed in my terminal here
    }

    @Test
    public void ClickDismiss() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(JSConfirm).click();
        driver.switchTo().alert().dismiss();  // Result in UI -->  You clicked: Cancel
    }

    @Test
    public void SendKeysToPrompt() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(JSPrompt).click();
        driver.switchTo().alert().sendKeys("Shehab");
        driver.switchTo().alert().accept();  // Result in UI --> You entered: Shehab
    }
}
