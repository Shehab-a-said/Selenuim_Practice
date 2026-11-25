import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DynamicLocators {
    WebDriver driver;
    // WebDriverWait wait;

    @Test
    public void DynamicLocatorTC() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--start-maximized");
        driver = new ChromeDriver(options);

        // wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://jqueryui.com/");

        ChooseCategory("OpenJS Foundation");
        ChooseSubCategory("Join");
    }

    public void ChooseCategory(String category) {
        //wait.until(driver -> driver.findElement(By.xpath("//ul[@class=\"links\"] //li //a[.=\"" + category + "\"]")).isEnabled());

        new Actions(driver).moveToElement(driver.findElement(By.xpath("//ul[@class=\"links\"] //li //a[.=\"" + category + "\"]"))).perform();
    }

    public void ChooseSubCategory(String subCategory) {
        driver.findElement(By.xpath("//a[.=\"" + subCategory + "\"]")).click();

    }

}
