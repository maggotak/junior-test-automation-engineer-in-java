package org.epam.learn.java.webdriver.task34.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TemporaryMailPage extends AbstractPage {
    private final static String HOMEPAGE_URL = "https://10minutemail.com/";
    private final static String VIDEO = "//*[@class='adsbyvli videoslider']";
    private final static String TEMP_MAIL_ADDRESS_XPATH = "//*[@id='mail_address']";
    private final static String INBOX_MESSAGES_XPATH = "//*[@class='message_top']";
    private final static int WAIT_TIME_FOR_EMAIL = 30;
    private final static int WAITING_TIME = 10;
    private final static Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@class='quote']//*[contains(text(), 'USD')]")
    WebElement costInEmail;

    public TemporaryMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TemporaryMailPage openPage() {
        driver.get(HOMEPAGE_URL);
        logger.info("Temporary mail page opened");
        return this;
    }

    public TemporaryMailPage getTemporaryEmail() {
        waitForElement(WAITING_TIME, VIDEO);
        driver.findElement(By.xpath(TEMP_MAIL_ADDRESS_XPATH)).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "c"));
        logger.info("Temporary mail received");
        return this;
    }

    public String getCostFromEmail() {
        waitForElement(WAIT_TIME_FOR_EMAIL, INBOX_MESSAGES_XPATH).click();
        return costInEmail.getText();
    }

}
