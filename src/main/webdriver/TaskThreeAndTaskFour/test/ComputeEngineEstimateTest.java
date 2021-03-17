import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ComputeEngineEstimateTest {
    private WebDriver driver;

    @BeforeClass
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void computeEngineEstimateTest() {
        String term = "Google Cloud Platform Pricing Calculator";
        new CloudGoogleMainPage(driver)
                .openPage()
                .searchAndClickTerm(term)
                .fillTheForm("4", "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS",
                        "Regular", "N1", "n1-standard-8 (vCPUs: 8, RAM: 30GB)", "2x375 GB", "Frankfurt");
    }

    @AfterClass
    public void browserClose() {
        driver.quit();
    }
}
