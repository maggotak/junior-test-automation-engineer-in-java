package org.epam.learn.java.webdriver.task34.page;

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
    private final static String NUMBER_OF_GPU_SELECT_XPATH = "//*[@id='select_container_397']//*[contains(text(), '%s')]/..";
    private final static String GPU_TYPE_SELECT_XPATH = "//*[@id='select_container_399']//*[contains(text(), '%s')]/..";
    private final static String LOCAL_SSD_SELECT_XPATH = "//*[@id='select_container_358']//*[contains(text(), '%s')]/..";
    private final static String DATA_CENTER_LOCATION_SELECT_XPATH = "//*[@id='select_container_95']//*[contains(text(), '%s')]/..";
    private final static String COMMITTED_USAGE_SELECT_XPATH = "//*[@id='select_container_102']//*[contains(text(), '%s')]/..";

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

    @FindBy(id = "select_value_label_394")
    WebElement numberOfGPU;

    @FindBy(id = "select_value_label_356")
    WebElement localSSD;

    @FindBy(id = "select_value_label_395")
    WebElement GPUType;

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

    @FindBy(xpath = "//*[@class='md-raised md-primary cpc-button md-button md-ink-ripple'][contains(text(), 'Send Email')]")
    WebElement sendEmail;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorPage computeEngineOptionSelect() {
        switchToFrame(driver);
        computeEngineTitle.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage numberOfInstancesSelect(String number) {
        numberOfInstances.sendKeys(number);
        return this;
    }

    public GoogleCloudPricingCalculatorPage operatingSystemSelect(String system) {
        operatingSystem.click();
        waitForElement(WAITING_TIME, String.format(OPERATING_SYSTEM_SELECT_XPATH, system)).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage machineClassSelect(String machineClass) {
        vMClass.click();
        waitForElement(WAITING_TIME, String.format(MACHINE_CLASS_SELECT_XPATH, machineClass)).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage machineSeriesSelect(String series) {
        machineSeries.click();
        waitForElement(WAITING_TIME, String.format(MACHINE_SERIES_SELECT_XPATH, series)).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage machineTypeSelect(String type) {
        machineType.click();
        waitForElement(WAITING_TIME, String.format(MACHINE_TYPE_SELECT_XPATH, type)).click();
        return this;
    }


    public GoogleCloudPricingCalculatorPage addGPU(String number, String type) {
        addGPUCheckbox.click();

        numberOfGPU.click();
        waitForElement(WAITING_TIME, String.format(NUMBER_OF_GPU_SELECT_XPATH, number)).click();

        GPUType.click();
        waitForElement(WAITING_TIME, String.format(GPU_TYPE_SELECT_XPATH, type)).click();

        return this;
    }


    public GoogleCloudPricingCalculatorPage localSSDSelect(String ssd) {
        localSSD.click();
        waitForElement(WAITING_TIME, String.format(LOCAL_SSD_SELECT_XPATH, ssd)).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage datacenterLocationSelect(String location) {
        datacenterLocation.click();
        waitForElement(WAITING_TIME, String.format(DATA_CENTER_LOCATION_SELECT_XPATH, location)).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage committedUsageSelect(String usage) {
        committedUsage.click();
        waitForElement(WAITING_TIME, String.format(COMMITTED_USAGE_SELECT_XPATH, usage)).click();
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
        emailEstimateInput.sendKeys(Keys.LEFT_CONTROL + "v");
        sendEmail.click();
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
        return costPerMonth.getText();
    }

    private GoogleCloudPricingCalculatorPage switchToFrame(WebDriver driver) {
        new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
        return this;
    }

}


