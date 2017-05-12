import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestsOne {

    private static String driverPath = "C:/Users/rtaylor/Downloads/chromedriver_win32/";
    private static WebDriver driver;

    @BeforeClass
    public static void test() {
        System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void CreateEvent() {

        String google_expected = "https://www.google.co.uk/?gws_rd=ssl";
        String google_actual = (driver.getCurrentUrl().toString());

        String amazon_expected = "https://www.google.co.uk/?gws_rd=ssl";
        String amazon_actual = (driver.getCurrentUrl().toString());

        GoToGoogle();
        GoToAmazon();

        Assert.assertEquals(google_expected, google_actual);
        Assert.assertEquals(amazon_expected, amazon_actual);
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

    private void GoToGoogle(){
        driver.navigate().to("http://www.google.co.uk");
    }

    private void GoToAmazon(){
        driver.navigate().to("http://www.amazon.co.uk");
    }
}
