import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;


public class ComputeEngineEstimateByMailTest {
    private WebDriver driver;

    private final static int NUMBER_OF_INSTANCES = 4;
    private final static String OPERATING_SYSTEM = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    private final static String MACHINE_CLASS = "Regular";
    private final static String MACHINE_SERIES = "N1";
    private final static String MACHINE_TYPE = "n1-standard-8";
    private final static int NUMBER_OF_GPU = 1;
    private final static String TYPE_OF_GPU = "NVIDIA Tesla V100";
    private final static String LOCAL_SSD = "2x375";
    private final static String DATACENTER_LOCATION = "Frankfurt";
    private final static String COMMITTED_USAGE = "1 Year";

    @BeforeClass
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void computeEngineEstimateTest() {
        String term = "Google Cloud Platform Pricing Calculator";
        GoogleCloudPricingCalculatorPage pricingCalculatorPage = new CloudGoogleMainPage(driver)
                .openPage()
                .searchAndClickTerm(term)
                .computeEngineOptionSelect()
                .numberOfInstancesSelect(NUMBER_OF_INSTANCES)
                .operatingSystemSelect(OPERATING_SYSTEM)
                .machineClassSelect(MACHINE_CLASS)
                .machineSeriesSelect(MACHINE_SERIES)
                .machineTypeSelect(MACHINE_TYPE)
                .addGPU(NUMBER_OF_GPU, TYPE_OF_GPU)
                .localSSDSelect(LOCAL_SSD)
                .datacenterLocationSelect(DATACENTER_LOCATION)
                .committedUsageSelect(COMMITTED_USAGE)
                .addToEstimate()
                .emailEstimate();


        String costFromGoogle = pricingCalculatorPage.getCostPerMonth();
        String google = driver.getWindowHandle();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        Set<String> set = driver.getWindowHandles();
        set.remove(google);
        String mail = (String) set.toArray()[0];

        driver.switchTo().window(mail);

        TemporaryMailPage page = new TemporaryMailPage(driver)
                .openPage()
                .getTemporaryEmail();

        driver.switchTo().window(google);
        pricingCalculatorPage.fillAndSendEmail();

        driver.switchTo().window(mail);
        String costFromEmail = page.getCostFromEmail();

        System.out.println("from email = " + costFromEmail);
        System.out.println("from google = " + costFromGoogle);
        Assert.assertTrue(costFromGoogle.contains(costFromEmail));
    }

    @Test
    public void testMail() {

    }

    @AfterClass
    public void browserClose() {
        driver.quit();
    }
}
