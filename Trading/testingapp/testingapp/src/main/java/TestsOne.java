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
        //Arrange
        String google_expected = "https://www.google.co.uk/?gws_rd=ssl";
        String amazon_expected = "https://www.amazon.co.uk/";

        //Act
        GoToSite(google_expected);
        String google_actual = (driver.getCurrentUrl().toString());
        GoToSite(amazon_expected);
        String amazon_actual = (driver.getCurrentUrl().toString());

        //Assert
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

    private void GoToSite(String url){
        driver.navigate().to(url);
    }
}
