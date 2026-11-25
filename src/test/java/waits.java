import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class waits {
    WebDriver driver;
    By startButton = By.tagName("button");
    By msg = By.cssSelector("#finish>h4");
    WebDriverWait wait;


    @Test
    public void WithoutWaitTC() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(startButton).click();
        String message = driver.findElement(msg).getText();
        System.out.println(message);
        //NoSuchElementException
    }

    @Test //implicit wait works
    public void implicitWaitTC1() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Global Wait
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(startButton).click(); // wait up to 5 sec
        String message = driver.findElement(msg).getText(); // wait up to another 5 sec
        System.out.println("Text inside Strat Button is --> " + message);
        // implicit Wait--> Only waits for presence in the DOM
        //in this case element isn't found in DOM until loader disappears
        // SO, it works and get massage because it waits until element's presence in DOM
    }

    @Test //implicit wait fails
    public void implicitWaitTC2() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Global Wait
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(startButton).click(); // wait up to 5 sec
        String message = driver.findElement(msg).getText(); // wait up to another 5 sec
        System.out.println("Text inside Strat Button is -->  " + message);
        //Again, implicit Wait--> Only waits for presence in the DOM
        //in this case element already found in DOM Before Click Start BUT it is hidden until loader finish --> so it will get you Empty Massage
        //it won't wait until loader finish and get massage
        //what really fails here is getText() because it is display:none until loader finish and become visible which exactly something implicit wait don't care about
    }

    @Test //Lambda Expression
    public void explicitWaitUsingLambdaExpressionTC1() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(startButton).click();

        wait.until(d -> driver.findElement(msg).isDisplayed()); //loop until up to 5 sec

        String message = driver.findElement(msg).getText();
        System.out.println("Text inside Strat Button is -->  " + message);
    }

    @Test //Lambda Expression
    public void explicitWaitUsingLambdaExpressionTC2() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(startButton).click();

        wait.until(d ->
                {
                    WebElement element = driver.findElement(msg);
                    return element.isDisplayed() && element.isEnabled();
                }
        );

        String message = driver.findElement(msg).getText();
        System.out.println("Text inside Strat Button is -->  " + message);
    }

    @Test //Expected Conditions
    public void explicitWaitUsingExpectedConditionsTC() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(startButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(msg)); //loop until up to 5 sec

        String message = driver.findElement(msg).getText();
        System.out.println("Text inside Strat Button is -->  " + message);
    }


    @Test // customization
    public void fluentWaitTC() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(startButton).click();

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class) //ignoring during the 5 sec //because element msg is not presence until loader finish
                .until(d -> driver.findElement(msg).isDisplayed());

        String message = driver.findElement(msg).getText();
        System.out.println("Text inside Strat Button is -->  " + message);
    }

    @Test
    public void pageLoadStrategyTC() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE); // Don't Wait for page to load --> so you must handle each wait
        driver = new ChromeDriver(chromeOptions);

        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        wait.until(ExpectedConditions.elementToBeClickable(startButton)); //Clickable = present + visible
        driver.findElement(startButton).click();

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class) //ignoring during the 5 sec //because element msg is not presence until loader finish
                .until(d -> driver.findElement(msg).isDisplayed());

        String message = driver.findElement(msg).getText();
        System.out.println("Text inside Strat Button is -->  " + message);
    }

}
