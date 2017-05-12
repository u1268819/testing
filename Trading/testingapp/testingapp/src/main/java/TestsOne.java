import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by rtaylor on 09/05/2017.
 */
public class TestsOne {

    public static String driverPath = "C:/Users/rtaylor/Downloads/chromedriver_win32/";
    public static WebDriver driver;

    @BeforeClass
    public static void test() {
        System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void CreateEvent() {
        GoToGoogle();
        String expected = "https://www.google.co.uk/?gws_rd=ssl";
        String actual = driver.getCurrentUrl().toString();
        Assert.assertEquals(expected, actual);
    }

    @AfterClass
    public static void tearDown() {
        if(driver!=null) {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }
            driver.quit();
        }
    }

    public void GoToGoogle(){
        driver.navigate().to("http://www.google.co.uk");
    }


}
