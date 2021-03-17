import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleMainPage {
    private final static String HOMEPAGE_URL = "https://cloud.google.com/";
    private WebDriver driver;

    @FindBy(xpath = "//input[@aria-label='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='gsc-webResult gsc-result']//*[text()='Google Cloud Platform Pricing Calculator']")
    WebElement linkToGoogleCloudCalculator;

    public CloudGoogleMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleMainPage openPage() {
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
        return this;
    }

    public GoogleCloudPricingCalculatorPage searchAndClickTerm(String term) {
        searchButton.sendKeys(term);
        searchButton.sendKeys("\n");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(linkToGoogleCloudCalculator));
        linkToGoogleCloudCalculator.click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }


}
