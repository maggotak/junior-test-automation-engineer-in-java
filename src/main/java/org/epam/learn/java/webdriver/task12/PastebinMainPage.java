package org.epam.learn.java.webdriver.task12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinMainPage {
    private final static String HOMEPAGE_URL = "https://pastebin.com";
    private WebDriver driver;

    @FindBy(id = "postform-text")
    WebElement textForm;

    @FindBy(id = "select2-postform-expiration-container")
    WebElement pasteExpirations;

    @FindBy(id = "select2-postform-format-container")
    WebElement pasteFormat;

    @FindBy(id = "postform-name")
    WebElement titleForm;

    @FindBy(xpath = "//*[text()='Create New Paste']")
    WebElement createNewPasteButton;

    public PastebinMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinMainPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));
        return this;
    }

    public PastebinMainPage createNewPaste(String text, String highlighting, String expiration, String title) {
        textForm.sendKeys(text);

        pasteFormat.click();
        driver.findElement(By.xpath("//li[text()='" + highlighting +"']")).click();

        pasteExpirations.click();
        driver.findElement(By.xpath("//li[text()='" + expiration +"']")).click();

        titleForm.sendKeys(title);
        createNewPasteButton.click();

        return this;
    }
}
