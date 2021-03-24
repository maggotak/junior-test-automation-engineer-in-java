package org.epam.learn.java.webdriver.task34.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(int waitingTime, String xpath) {
        return new WebDriverWait(driver, waitingTime)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
}
