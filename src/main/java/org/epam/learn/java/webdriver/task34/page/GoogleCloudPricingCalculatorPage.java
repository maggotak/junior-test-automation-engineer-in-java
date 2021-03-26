package org.epam.learn.java.webdriver.task34.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {
    private final static int WAITING_TIME = 10;
    private final static String OPERATING_SYSTEM_SELECT_XPATH = "//md-option/div[contains(text(), '%s')]/..";
    private final static String MACHINE_CLASS_SELECT_XPATH = "//*[@id='select_container_83']//*[contains(text(), '%s')]/..";
    private final static String MACHINE_SERIES_SELECT_XPATH = "//*[@id='select_container_91']//*[contains(text(), '%s')]/..";
    private final static String MACHINE_TYPE_SELECT_XPATH = "//*[@id='select_container_93']//*[contains(text(), '%s')]/..";
    private final static String NUMBER_OF_GPU_SELECT_XPATH = "//*[@id='select_container_400']//*[contains(text(), '%s')]/..";
    private final static String GPU_TYPE_SELECT_XPATH = "//*[@id='select_container_402']//*[contains(text(), '%s')]/..";
    private final static String LOCAL_SSD_SELECT_XPATH = "//*[@id='select_container_361']//*[contains(text(), '%s')]/..";
    private final static String DATA_CENTER_LOCATION_SELECT_XPATH = "//*[@id='select_container_95']//*[contains(text(), '%s')]/..";
    private final static String COMMITTED_USAGE_SELECT_XPATH = "//*[@id='select_container_102']//*[contains(text(), '%s')]/..";
    private final static String SEND_MAIL = "//*[@class='md-raised md-primary cpc-button md-button md-ink-ripple'][contains(text(), 'Send Email')]";
    private final static Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@class='md-tab ng-scope ng-isolate-scope md-ink-ripple md-active']")
    WebElement computeEngineTitle;

    @FindBy(id = "input_65")
    WebElement numberOfInstances;

    @FindBy(id = "select_value_label_58")
    WebElement operatingSystem;

    @FindBy(id = "select_value_label_59")
    WebElement vMClass;

    @FindBy(id = "select_value_label_61")
    WebElement machineSeries;

    @FindBy(id = "select_value_label_62")
    WebElement machineType;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.addGPUs']")
    WebElement addGPUCheckbox;

    @FindBy(id = "select_399")
    WebElement numberOfGPU;

    @FindBy(id = "select_401")
    WebElement GPUType;

    @FindBy(id = "select_360")
    WebElement localSSD;

    @FindBy(id = "select_value_label_63")
    WebElement datacenterLocation;

    @FindBy(id = "select_101")
    WebElement committedUsage;

    @FindBy(xpath = "//*[@name='ComputeEngineForm']//*[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    WebElement addToEstimate;

    @FindBy(id = "email_quote")
    WebElement emailToEstimate;

    @FindBy(xpath = "//*[@class='md-list-item-text ng-binding'][contains(text(), 'VM class')]")
    WebElement vMClassEstimate;

    @FindBy(xpath = "//*[@class='md-1-line md-no-proxy']/*[contains(text(), 'Instance type')]")
    WebElement instanceTypeEstimate;

    @FindBy(xpath = "//*[@class='md-1-line md-no-proxy']/*[contains(text(), 'Region')]")
    WebElement regionEstimate;

    @FindBy(xpath = "//*[@class='md-1-line md-no-proxy ng-scope']/*[contains(text(), 'SSD')]")
    WebElement localSSDEstimate;

    @FindBy(xpath = "//*[@class='md-1-line md-no-proxy ng-scope']/*[contains(text(), 'Commitment')]")
    WebElement commitmentTermEstimate;

    @FindBy(xpath = "//*[@class='md-title']/*[@class='ng-binding']")
    WebElement costPerMonth;

    @FindBy(xpath = "//*[@ng-model='emailQuote.user.email']")
    WebElement emailEstimateInput;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorPage computeEngineOptionSelect() {
        switchToFrame(driver);
        computeEngineTitle.click();
        logger.info("Compute Engine switching is complete");
        return this;
    }

    public GoogleCloudPricingCalculatorPage numberOfInstancesSelect(String number) {
        numberOfInstances.sendKeys(number);
        logger.info("Number of instances selection is complete");
        return this;
    }

    public GoogleCloudPricingCalculatorPage operatingSystemSelect(String system) {
        operatingSystem.click();
        waitForElement(WAITING_TIME, String.format(OPERATING_SYSTEM_SELECT_XPATH, system)).click();
        logger.info("Operating system selection is complete");
        return this;
    }

    public GoogleCloudPricingCalculatorPage machineClassSelect(String machineClass) {
        vMClass.click();
        waitForElement(WAITING_TIME, String.format(MACHINE_CLASS_SELECT_XPATH, machineClass)).click();
        logger.info("Virtual machine class selection is complete");
        return this;
    }

    public GoogleCloudPricingCalculatorPage machineSeriesSelect(String series) {
        machineSeries.click();
        waitForElement(WAITING_TIME, String.format(MACHINE_SERIES_SELECT_XPATH, series)).click();
        logger.info("Machine system selection is complete");
        return this;
    }

    public GoogleCloudPricingCalculatorPage machineTypeSelect(String type) {
        machineType.click();
        waitForElement(WAITING_TIME, String.format(MACHINE_TYPE_SELECT_XPATH, type)).click();
        logger.info("Machine type selection is complete");
        return this;
    }


    public GoogleCloudPricingCalculatorPage addGPU(String number, String type) {
        addGPUCheckbox.click();

        numberOfGPU.click();
        waitForElement(WAITING_TIME, String.format(NUMBER_OF_GPU_SELECT_XPATH, number)).click();

        GPUType.click();
        waitForElement(WAITING_TIME, String.format(GPU_TYPE_SELECT_XPATH, type)).click();
        logger.info("Number and type GPU selection is complete");
        return this;
    }


    public GoogleCloudPricingCalculatorPage localSSDSelect(String ssd) {
        localSSD.click();
        waitForElement(WAITING_TIME, String.format(LOCAL_SSD_SELECT_XPATH, ssd)).click();
        logger.info("Local SSD selection is complete");
        return this;
    }

    public GoogleCloudPricingCalculatorPage datacenterLocationSelect(String location) {
        datacenterLocation.click();
        waitForElement(WAITING_TIME, String.format(DATA_CENTER_LOCATION_SELECT_XPATH, location)).click();
        logger.info("Datacenter location selection is complete");
        return this;
    }

    public GoogleCloudPricingCalculatorPage committedUsageSelect(String usage) {
        committedUsage.click();
        waitForElement(WAITING_TIME, String.format(COMMITTED_USAGE_SELECT_XPATH, usage)).click();
        logger.info("Committed usage selection is complete");
        return this;
    }

    public GoogleCloudPricingCalculatorPage addToEstimate() {
        addToEstimate.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage emailEstimate() {
        switchToFrame(driver);
        emailToEstimate.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillAndSendEmail() {
        emailEstimateInput.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "v"));
        waitForElement(WAITING_TIME, SEND_MAIL).click();
        logger.info("Email sent");
        return this;
    }

    public String getVMClassEstimate() {
        return vMClassEstimate.getText();
    }

    public String getInstanceTypeEstimate() {
        return instanceTypeEstimate.getText();
    }

    public String getRegionEstimate() {
        return regionEstimate.getText();
    }
    public String getLocalSSDEstimate() {
        return localSSDEstimate.getText();
    }

    public String getCommitmentTermEstimate() {
        return commitmentTermEstimate.getText();
    }

    public String getCostPerMonth() {
        String textWithCost = costPerMonth.getText();
        return textWithCost.substring(textWithCost.indexOf("USD"), textWithCost.indexOf("USD") + 12);
    }

    private GoogleCloudPricingCalculatorPage switchToFrame(WebDriver driver) {
        new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
        return this;
    }

}


