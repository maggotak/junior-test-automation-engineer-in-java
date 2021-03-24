package org.epam.learn.java.webdriver.task34.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TemporaryMailPage extends AbstractPage {
    private final static String HOMEPAGE_URL = "https://10minutemail.com/";
    private final static String COPY_ADDRESS_BUTTON_XPATH = "//*[@id='copy_address']";
    private final static String INBOX_MESSAGES_XPATH = "//*[@class='message_top']";
    private final static int WAIT_TIME_FOR_EMAIL = 30;
    private final static int WAITING_TIME = 10;

    @FindBy(xpath = "//*[@class='quote']//*[contains(text(), 'USD')]")
    WebElement costInEmail;

    public TemporaryMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TemporaryMailPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public TemporaryMailPage getTemporaryEmail() {
        waitForElement(WAITING_TIME, COPY_ADDRESS_BUTTON_XPATH).click();
        return this;
    }

    public String getCostFromEmail() {
        waitForElement(WAIT_TIME_FOR_EMAIL, INBOX_MESSAGES_XPATH).click();
        return costInEmail.getText();
    }

}
