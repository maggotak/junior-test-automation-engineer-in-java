import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TemporaryMailPage {
    private final static String HOMEPAGE_URL = "https://10minutemail.com/";
    private final static int WAIT_TIME_FOR_EMAIL = 30;
    private final static int WAITING_TIME = 10;
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='quote']//*[contains(text(), 'USD')]")
    WebElement costInEmail;

    public TemporaryMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public TemporaryMailPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public TemporaryMailPage getTemporaryEmail() {
        new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.elementToBeClickable(By.id("copy_address")))
                .click();
        return this;
    }

    public String getCostFromEmail() {
        new WebDriverWait(driver, WAIT_TIME_FOR_EMAIL)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='message_top']")))
                .click();
        return costInEmail.getText();
    }

}
