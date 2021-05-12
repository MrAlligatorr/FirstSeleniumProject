import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchItems {

    private WebDriver driver;

    @Before
    public void initialization() {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void filterItems() throws InterruptedException {
        driver.findElement(By.cssSelector(".nav-5 .has-children")).click();
        driver.findElement(By.cssSelector(".toolbar [title='Sort By'] :not(.toolbar-bottom option)")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[title='Sort By'] :not(.toolbar-bottom option):nth-child(2)")).click();
    }

    @Test
    public void addItemToCartWithoutStats() {
        driver.findElement(By.cssSelector(".nav-5 .has-children")).click();
        driver.findElement(By.cssSelector("a.button")).click();
        driver.findElement(By.cssSelector(".add-to-cart span span")).click();
        WebElement checkMandatoryColor = driver.findElement(By.id("advice-required-entry-attribute92"));
        Assert.assertEquals("This is a required field.", checkMandatoryColor.getText());
        WebElement checkMandatorySize = driver.findElement(By.id("advice-required-entry-attribute92"));
        Assert.assertEquals("This is a required field.", checkMandatorySize.getText());
    }

    @After
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
