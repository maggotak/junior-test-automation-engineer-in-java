import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPricingCalculatorPage {
    private WebDriver driver;
    private final static int WAITING_TIME = 10;

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
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorPage computeEngineOptionSelect() {
        new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
        computeEngineTitle.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage numberOfInstancesSelect(int number) {
        numberOfInstances.sendKeys(String.valueOf(number));
        return this;
    }

    public GoogleCloudPricingCalculatorPage operatingSystemSelect(String system) {
        operatingSystem.click();
        new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option/div[contains(text(), '" + system + "')]/.."))).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage machineClassSelect(String machineClass) {
        vMClass.click();
        new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='select_container_83']//*[contains(text(), '" + machineClass + "')]/.."))).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage machineSeriesSelect(String series) {
        machineSeries.click();
        new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='select_container_91']//*[contains(text(), '" + series + "')]/.."))).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage machineTypeSelect(String type) {
        machineType.click();
        new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='select_container_93']//*[contains(text(), '" + type + "')]/.."))).click();
        return this;
    }


    public GoogleCloudPricingCalculatorPage addGPU(int number, String type) {
        addGPUCheckbox.click();

        numberOfGPU.click();
        new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='select_container_397']//*[contains(text(), '" + number + "')]/.."))).click();

        GPUType.click();
        new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='select_container_399']//*[contains(text(), '" + type + "')]/.."))).click();
        return this;
    }


    public GoogleCloudPricingCalculatorPage localSSDSelect(String ssd) {
        localSSD.click();
        new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='select_container_358']//*[contains(text(), '" + ssd + "')]/.."))).click();

        return this;
    }

    public GoogleCloudPricingCalculatorPage datacenterLocationSelect(String location) {
        this.datacenterLocation.click();
        new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='select_container_95']//*[contains(text(), '" + location + "')]/.."))).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage committedUsageSelect(String usage) {
        committedUsage.click();
        new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='select_container_102']//*[contains(text(), '" + usage + "')]/.."))).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage addToEstimate() {
        addToEstimate.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage emailEstimate() {
        emailToEstimate.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillAndSendEmail() {
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
        emailEstimateInput.sendKeys(Keys.LEFT_CONTROL + "v");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

}


