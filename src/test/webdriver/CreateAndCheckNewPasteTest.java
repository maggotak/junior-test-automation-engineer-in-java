
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class CreateAndCheckNewPasteTest {
    private WebDriver driver;
    private String title;
    private String text;

    @BeforeClass
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        title = "how to gain dominance among developers";
        text = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
    }

    @Test
    public void createNewPasteTest() {
        new PastebinMainPage(driver)
                .openPage()
                .createNewPaste(text, "Bash", "10 Minutes", title);
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains(title));

        SoftAssert softAssert = new SoftAssert();

        String receivedTitle = driver.getTitle();
        String colorViolet = driver.findElement(By.xpath("//*[text()='git config']")).getCssValue("color");
        String colorRed = driver.findElement(By.xpath("//*[contains(text(),'New Sheriff in Town')]")).getCssValue("color");
        String receivedText = driver.findElement(By.xpath("//textarea[@class='textarea']")).getText();

        softAssert.assertEquals(receivedTitle.replace(" - Pastebin.com", ""), title);
        softAssert.assertNotEquals(colorRed, colorViolet);
        softAssert.assertEquals(receivedText, text);
        softAssert.assertAll();
    }

    @AfterClass
    public void browserClose() {
        driver.quit();
    }
}
