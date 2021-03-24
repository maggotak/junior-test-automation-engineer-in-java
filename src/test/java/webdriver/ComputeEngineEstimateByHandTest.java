package webdriver;

import org.epam.learn.java.webdriver.task34.page.CloudGoogleMainPage;
import org.epam.learn.java.webdriver.task34.page.GoogleCloudPricingCalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ComputeEngineEstimateByHandTest {
    private WebDriver driver;

    private final static String NUMBER_OF_INSTANCES = "4";
    private final static String OPERATING_SYSTEM = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    private final static String MACHINE_CLASS = "Regular";
    private final static String MACHINE_SERIES = "N1";
    private final static String MACHINE_TYPE = "n1-standard-8";
    private final static String NUMBER_OF_GPU = "1";
    private final static String TYPE_OF_GPU = "NVIDIA Tesla V100";
    private final static String LOCAL_SSD = "2x375";
    private final static String DATACENTER_LOCATION = "Frankfurt";
    private final static String COMMITTED_USAGE = "1 Year";
    private final static String COST_BY_HAND = "Total Estimated Cost: USD 1,082.77 per 1 month";

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
                .addToEstimate();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(pricingCalculatorPage.getVMClassEstimate().contains(MACHINE_CLASS.toLowerCase()), "VM");
        softAssert.assertTrue(pricingCalculatorPage.getInstanceTypeEstimate().contains(MACHINE_TYPE), "Type");
        softAssert.assertTrue(pricingCalculatorPage.getRegionEstimate().contains(DATACENTER_LOCATION), "Region");
        softAssert.assertTrue(pricingCalculatorPage.getLocalSSDEstimate().contains(LOCAL_SSD), "SSD");
        softAssert.assertTrue(pricingCalculatorPage.getCommitmentTermEstimate().contains(COMMITTED_USAGE), "Commit");
        softAssert.assertEquals(pricingCalculatorPage.getCostPerMonth(), COST_BY_HAND, "Cost");

        softAssert.assertAll();
    }


    @AfterClass
    public void browserClose() {
        driver.quit();
    }
}
