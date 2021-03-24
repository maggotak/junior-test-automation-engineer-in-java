package org.epam.learn.java.webdriver.task34.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudGoogleMainPage extends AbstractPage {
    private final static String HOMEPAGE_URL = "https://cloud.google.com/";
    private final static String LINK_TO_GOOGLE_CLOUD_CALCULATOR_XPATH = "//*[@id='suggestion-product-0']";
    private final static int WAITING_TIME = 10;

    @FindBy(xpath = "//input[@aria-label='Search']")
    WebElement searchButton;

    public CloudGoogleMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleMainPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public GoogleCloudPricingCalculatorPage searchAndClickTerm(String term) {
        searchButton.sendKeys(term);
        waitForElement(WAITING_TIME, LINK_TO_GOOGLE_CLOUD_CALCULATOR_XPATH).click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }


}
