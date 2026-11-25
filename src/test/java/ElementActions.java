import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import java.io.File;

public class ElementActions {

    WebDriver driver;

    By username = By.id("inputUsername");
    By password = By.id("inputPassword");
    By loginButton = RelativeLocator.with(By.tagName("button")).below(password);
    By uploadFile = By.id("regularFileInput");

    //Test Runner
    @Test
    public void loginTC() {
        driver = new ChromeDriver();
        maximizeWindow();
        navigateTo("https://aa-practice-test-automation.vercel.app/index.html");
        type(username, "admin");
        type(password, "admin");
        clicking(loginButton);
    }

    @Test
    public void UploadFileTC() {
        driver = new ChromeDriver();
        maximizeWindow();
        navigateTo("https://aa-practice-test-automation.vercel.app/index.html");
        type(username, "admin");
        type(password, "admin");
        clicking(loginButton);
        navigateTo("https://aa-practice-test-automation.vercel.app/Pages/file-operations/uploadFile.html");
        uploadFile(uploadFile, "src/test/resources/test.txt");
    }

    @Test
    public void isEnabledTC() {
        driver = new ChromeDriver();
        maximizeWindow();
        navigateTo("https://aa-practice-test-automation.vercel.app/index.html");
        System.out.println(findElement(username).isEnabled()); //true
    }

    @Test
    public void isDisplayedTC() {
        driver = new ChromeDriver();
        maximizeWindow();
        navigateTo("https://aa-practice-test-automation.vercel.app/index.html");
        System.out.println(findElement(username).isDisplayed()); //true
    }

    @Test
    public void getTextTC() {
        driver = new ChromeDriver();
        maximizeWindow();
        navigateTo("https://aa-practice-test-automation.vercel.app/index.html");
        type(username, "admin");
        type(password, "admin");
        clicking(loginButton);
        navigateTo("https://aa-practice-test-automation.vercel.app/Pages/about.html");
        By text = By.id("about-what-desc");
        //getText(text);
        String Text = findElement(text).getText();
        System.out.println(Text);

    }

    @Test
    public void shadowDomTC() {
        driver = new ChromeDriver();
        maximizeWindow();
        navigateTo("https://aa-practice-test-automation.vercel.app/index.html");
        type(username, "admin");
        type(password, "admin");
        clicking(loginButton);
        navigateTo("https://aa-practice-test-automation.vercel.app/Pages/form-controls/shadow-dom.html");

        By shadowHost = By.id("open-shadow-host");
        By input = By.id("open-input");
        driver.findElement(shadowHost).getShadowRoot().findElement(input).sendKeys("Shehab");

    }

    //wrapping method
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

  /*  public String getText(By by) {
        String Text = driver.findElement(by).getText();
        System.out.println(Text);
        return Text;
    } */

    public void clicking(By by) {
        driver.findElement(by).click();
    }

    public void clear(By by) {
        driver.findElement(by).clear();
    }

    public void type(By by, String text) {
        clear(by);
        driver.findElement(by).sendKeys(text);
    }

    public void uploadFile(By by, String filePath) {
        String userDirectory = System.getProperty("user.dir");
        System.out.println("userDirectory: " + userDirectory);
        findElement(by).sendKeys(userDirectory + File.separator + filePath);

    }

    //Method to open Link
    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

}

