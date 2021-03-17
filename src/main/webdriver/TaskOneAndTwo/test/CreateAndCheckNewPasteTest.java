
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class CreateAndCheckNewPasteTest {
    private WebDriver driver;
    private String title;
    private String text;

    @BeforeClass
    public void browserSetup() {
        driver = new ChromeDriver();
        title = "how to gain dominance among developers";
        text = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
    }

    @Test
    public void createNewPasteTest() {
        new PastebinMainPage(driver)
                .openPage()
                .createNewPaste(text, "Bash","10 Minutes", title);
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains(title));
    }

    @Test
    public void titleCompareTest() {
        String receivedTitle = driver.getTitle();
        System.out.println(receivedTitle);
        Assert.assertEquals(receivedTitle.replace(" - Pastebin.com", ""), title);
    }

    @Test
    public void highlightingTest() {
        String colorViolet = driver.findElement(By.xpath("//*[text()='git config']")).getCssValue("color");
        String colorRed = driver.findElement(By.xpath("//*[contains(text(),'New Sheriff in Town')]")).getCssValue("color");
        System.out.println(colorRed);
        System.out.println(colorViolet);
        Assert.assertNotEquals(colorRed, colorViolet);
    }

    @Test
    public void textIsEqualTest() {
        String receivedText = driver.findElement(By.xpath("//textarea[@class='textarea']")).getText();
        Assert.assertEquals(receivedText, text);
    }

    @AfterClass
    public void browserClose() {
        driver.quit();
    }
}
