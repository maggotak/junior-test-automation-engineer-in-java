package webdriver;

import org.epam.learn.java.webdriver.task12.PastebinMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewPasteTest {
    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void createNewPasteTest() {
        new PastebinMainPage(driver)
                .openPage()
                .createNewPaste("Hello from WebDriver", "None", "10 Minutes", "helloweb");
    }

    @AfterTest(alwaysRun = true)
    public void browserClose() {
        driver.quit();
    }
}
