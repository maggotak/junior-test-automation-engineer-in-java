package webdriver;

import org.epam.learn.java.webdriver.task34.driver.DriverSingleton;
import org.epam.learn.java.webdriver.task34.model.MachineParameters;
import org.epam.learn.java.webdriver.task34.page.CloudGoogleMainPage;
import org.epam.learn.java.webdriver.task34.page.GoogleCloudPricingCalculatorPage;
import org.epam.learn.java.webdriver.task34.page.TemporaryMailPage;
import org.epam.learn.java.webdriver.task34.service.MachineParametersCreator;
import org.epam.learn.java.webdriver.task34.util.TestListener;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Set;

@Listeners({TestListener.class})
public class ComputeEngineEstimateByMailTest {
    private WebDriver driver;

    @BeforeClass
    public void browserSetup() {
        driver = DriverSingleton.getDriver();
    }

    @Test
    public void computeEngineEstimateTest() {
        String term = "Google Cloud Platform Pricing Calculator";

        MachineParameters parameters = MachineParametersCreator.fromTestDataProperty();

        GoogleCloudPricingCalculatorPage pricingCalculatorPage = new CloudGoogleMainPage(driver)
                .openPage()
                .searchAndClickTerm(term)
                .computeEngineOptionSelect()
                .numberOfInstancesSelect(parameters.getNumberOfInstances())
                .operatingSystemSelect(parameters.getOperatingSystem())
                .machineClassSelect(parameters.getMachineClass())
                .machineSeriesSelect(parameters.getMachineSeries())
                .machineTypeSelect(parameters.getMachineType())
//                .addGPU(parameters.getNumberOfGPU(), parameters.getTypeOfGPU())
//                .localSSDSelect(parameters.getLocalSSD())
                .datacenterLocationSelect(parameters.getDatacenterLocation())
                .committedUsageSelect(parameters.getCommittedUsage())
                .addToEstimate();


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
        pricingCalculatorPage
                .emailEstimate()
                .fillAndSendEmail();

        driver.switchTo().window(mail);
        String costFromEmail = page.getCostFromEmail();

        Assert.assertTrue(costFromGoogle.contains(costFromEmail));
    }

    @AfterClass
    public void browserClose() {
        DriverSingleton.closeDriver();
    }
}
