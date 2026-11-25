import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDowns {
    WebDriver driver;

    @Test
    public void dropDownTC() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        By dropdown = By.id("dropdown");
        new Select(driver.findElement(dropdown)).selectByIndex(2);

        //new Select(driver.findElement(dropdown)).selectByValue("2");
        //new Select(driver.findElement(dropdown)).selectByVisibleText("Option 2");
        //new Select(driver.findElement(dropdown)).selectByContainsVisibleText("1");
        // new Select(driver.findElement(dropdown)).deselectByIndex(2);
        //System.out.println(new Select(driver.findElement(dropdown)).getOptions());
        //System.out.println(new Select(driver.findElement(dropdown)).getOptions().size());
        //System.out.println(new Select(driver.findElement(dropdown)).getFirstSelectedOption());
    }
}
