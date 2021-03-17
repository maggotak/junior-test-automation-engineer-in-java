import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPricingCalculatorPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='name ng-binding' and text()='Compute Engine']")
    WebElement computeEngineTitle;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.quantity']")
    WebElement numberOfInstancesToFill;

    @FindBy(xpath = "//*[@class='flex md-input-has-value']")
    WebElement operatingSystemSelect;

    @FindBy(xpath = "//*[@class='md-input-has-placeholder flex md-input-has-value']")
    WebElement vMClassSelect;

    @FindBy(xpath = "//*[@class='md-input-has-placeholder flex md-input-has-value']/*[contains(text(), 'Series')]/..")
    WebElement seriesSelect;

    @FindBy(id = "select_value_label_62")
    WebElement machineTypeSelect;

    @FindBy(xpath = "//*[@class='md-input-has-placeholder md-input-has-value flex']")
    WebElement localSSDSelect;

    @FindBy(xpath = "//*[@class='layout-row']//*[contains(text(), 'Datacenter location')]")
    WebElement datacenterLocationSelect;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorPage fillTheForm(String numberOfInstances, String operatingSystem, String machineClass,
                                                        String series, String type, String ssd, String datacenterLocation) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        computeEngineTitle.click();
        numberOfInstancesToFill.sendKeys(numberOfInstances);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        operatingSystemSelect.click();
        driver.findElement(By.xpath("//md-option/div[contains(text(), '" + operatingSystem+ "')]/..")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        vMClassSelect.click();
        driver.findElement(By.xpath("//*[@id='select_container_83']//*[contains(text(), '" + machineClass + "')]/..")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        seriesSelect.click();
        driver.findElement(By.xpath("//*[@id='select_container_91']//*[contains(text(), '" + series + "')]/..")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        machineTypeSelect.click();
        driver.findElement(By.xpath("//*[@id='select_container_93']//*[contains(text(), '" + type + "')]/..")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        localSSDSelect.click();
        driver.findElement(By.xpath("//*[@id='select_container_358']//*[contains(text(), '" + ssd + "')]/..")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        datacenterLocationSelect.click();
        driver.findElement(By.xpath("//*[@id='select_container_95']//*[contains(text(), '" + datacenterLocation + "')]/..")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

}
