import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumActions {
    WebDriver driver;
    By rightClick = By.cssSelector("button#riClickBtn");
    By avatar = By.cssSelector("[alt='User Avatar']");
    By doubleClick = By.cssSelector("button#dblClickBtn");
    By drag = By.cssSelector("img#dragImage");
    By drop = By.cssSelector("div#dropZone");


    @Test //Right Click
    public void contextClickTC() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://aa-practice-test-automation.vercel.app/index.html");
        driver.findElement(By.id("inputUsername")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).sendKeys("admin");
        driver.findElement(By.tagName("button")).click();
        driver.get("https://aa-practice-test-automation.vercel.app/Pages/mouse-keyboard/mouse.html");

        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(rightClick)).perform();

        ((RemoteWebDriver) driver).resetInputState();

    }

    @Test //Hovering
    public void HoverTC() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(avatar)).perform();

        ((RemoteWebDriver) driver).resetInputState();
    }

    @Test //Double Click
    public void DoubleClickTC() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://aa-practice-test-automation.vercel.app/index.html");
        driver.findElement(By.id("inputUsername")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).sendKeys("admin");
        driver.findElement(By.tagName("button")).click();
        driver.get("https://aa-practice-test-automation.vercel.app/Pages/mouse-keyboard/mouse.html");

        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(doubleClick)).perform();

        ((RemoteWebDriver) driver).resetInputState();

    }

    @Test //Drag And Drop
    public void DragAndDropTC() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://aa-practice-test-automation.vercel.app/index.html");
        driver.findElement(By.id("inputUsername")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).sendKeys("admin");
        driver.findElement(By.tagName("button")).click();
        driver.get("https://aa-practice-test-automation.vercel.app/Pages/mouse-keyboard/dragDrop.html");

        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(drag), driver.findElement(drop)).perform();

        ((RemoteWebDriver) driver).resetInputState();
    }

    @Test // Click And Hold
    public void ClickAndHoldTC() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://aa-practice-test-automation.vercel.app/index.html");
        driver.findElement(By.id("inputUsername")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).sendKeys("admin");
        driver.findElement(By.tagName("button")).click();
        driver.get("https://aa-practice-test-automation.vercel.app/Pages/mouse-keyboard/dragDrop.html");

        Actions actions = new Actions(driver);
        actions
                .clickAndHold(driver.findElement(drag))
                .moveToElement(driver.findElement(drop))
                .release()
                .perform();

        reset();

    }

    @Test // Keyboard Actions
    public void KeyboardKeys() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/key_presses");

        Actions actions = new Actions(driver);
        actions
                .keyDown(Keys.SHIFT) // To Make Write Capital
                .sendKeys(driver.findElement(By.id("target")), "shehab")
                .perform();  // SHEHAB

        reset();
    }

    @Test // Scroll Down
    public void ScrollingTC() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://aa-practice-test-automation.vercel.app/index.html");
        driver.findElement(By.id("inputUsername")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).sendKeys("admin");
        driver.findElement(By.tagName("button")).click();
        driver.get("https://aa-practice-test-automation.vercel.app/Pages/mouse-keyboard/scrolling.html");

        //driver.findElement(By.id("dropdown-toggle-btn")).click(); // fails - need to scroll

        Actions actions = new Actions(driver);
        actions.
                scrollToElement(driver.findElement(By.id("dropdown-toggle-btn"))).click().perform();
    }


    public void reset() {
        ((RemoteWebDriver) driver).resetInputState();
    }


}
