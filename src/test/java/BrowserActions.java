import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserActions {

    WebDriver driver;

    // Test Runner
    @Test
    public void testCase() {
        driver = new ChromeDriver();               // open Chrome browser

        //GetLink("https://www.google.com"); //open google
        //GetLink("https://www.bing.com");

        navigateTo("https://www.google.com");  // open google
        //navigateTo("https://www.bing.com");

        //navigateBack();
        //navigateForward();
        //refresh();

        //maximizeWindow();
        //minimizeWindow();
        //setWindowPosition(100, 100);
        //setWindowSize(430, 932);
        //fullWindowScreen();

        getCurrentURL();
        getPageTitle();
        //getPageSource();
        getWindowHandle();

        //closeCurrentTab();
        //closeAllTabs();

    }

    /* **************************************************************************** */

    /* public void GetLink(String url) {
       driver.get(url);
    } */

    //Navigation methods
    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    /* *********************************************************** */

    //Manage browser window methods
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void minimizeWindow() {
        driver.manage().window().minimize();
    }

    public void setWindowPosition(int w, int l) {
        //Point point = new Point(50,50);  --> Point is a Class
        driver.manage().window().setPosition(new Point(w, l));
    }

    public void setWindowSize(int w, int l) {
        //Dimension dimension = new Dimension(50,50);  --> Dimension is a Class
        driver.manage().window().setSize(new Dimension(w, l));
    }

    public void fullWindowScreen() {
        driver.manage().window().fullscreen();
    }

    /* ********************************************************************* */

    //Methods to Get Information about web page
    public void getCurrentURL() {
        String url = driver.getCurrentUrl();
        System.out.println(" Current Url is " + url);
    }

    public void getPageTitle() {
        String title = driver.getTitle();
        System.out.println("page title is " + title);
    }

    public void getPageSource() {
        String src = driver.getPageSource();
        System.out.println("Page Source Code is \n" + src);
    }

    public void getWindowHandle() {
        String handle = driver.getWindowHandle();
        System.out.println("window handle is " + handle);
    }

    /* ******************************************************************************* */

    //Close method --> close current tab && quit ->> close all tabs
    public void closeCurrentTab() {
        driver.close();
    }

    public void closeAllTabs() {
        driver.quit();
    }

    /* ******************************************************************************** */

   
}
