import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CheckBoxAndRadioButton {
    WebDriver driver;
    By Ahly = By.id("ahly-checkbox");
    By Zamalek = By.id("zamalek-checkbox");
    By NoFan = By.id("nofan-checkbox");

    By gradSchool = By.id("gradschool-radio");
    By college = By.id("college-radio");
    By highSchool = By.id("highschool-radio");


    @Test
    public void checkBoxTC() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://aa-practice-test-automation.vercel.app/index.html");
        driver.findElement(By.id("inputUsername")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).sendKeys("admin");
        driver.findElement(By.tagName("button")).click();
        driver.get("https://aa-practice-test-automation.vercel.app/Pages/basic-actions/checkbox_Radio.html");

        //Scrolling Down
        new Actions(driver).moveToElement(driver.findElement(NoFan)).click().perform();

        System.out.println(driver.findElement(Ahly).isSelected()); //F
        driver.findElement(Ahly).click();
        System.out.println(driver.findElement(Ahly).isSelected()); // T
        System.out.println(driver.findElement(NoFan).isSelected()); // T

    }

    @Test
    public void RadioButtonTC() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://aa-practice-test-automation.vercel.app/index.html");
        driver.findElement(By.id("inputUsername")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).sendKeys("admin");
        driver.findElement(By.tagName("button")).click();
        driver.get("https://aa-practice-test-automation.vercel.app/Pages/basic-actions/checkbox_Radio.html");

        //Scrolling Down
        new Actions(driver).scrollToElement(driver.findElement(gradSchool)).click().perform();

        System.out.println(driver.findElement(college).isSelected()); //f
        driver.findElement(highSchool).click();
        System.out.println(driver.findElement(highSchool).isSelected());  //t
        System.out.println(driver.findElement(gradSchool).isSelected());  //f

    }
}
