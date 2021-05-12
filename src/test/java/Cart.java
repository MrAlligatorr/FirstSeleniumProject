import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cart {

    private WebDriver driver;

    @Before
    public void initialization() {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void removeFirstItemFromCart() {
        driver.findElement(By.id("search")).sendKeys("ELIZABETH KNIT TOP");
        driver.findElement(By.cssSelector("[title='Search']")).click();
        driver.findElement(By.cssSelector(".actions [href*='tribeca']")).click();
        driver.findElement(By.cssSelector(".swatch-label img")).click();
        driver.findElement(By.cssSelector("#swatch67 .swatch-label")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons span span")).click();
        WebElement itemAdded1 = driver.findElement(By.cssSelector(".success-msg span"));
        Assert.assertEquals("TriBeCa Skinny Jean was added to your shopping cart.", itemAdded1.getText());
        driver.findElement(By.id("search")).sendKeys("ELIZABETH KNIT TOP");
        driver.findElement(By.cssSelector("[title='Search']")).click();
        driver.findElement(By.cssSelector(".actions [href*='knit']")).click();
        driver.findElement(By.cssSelector("#swatch21 img")).click();
        driver.findElement(By.cssSelector("#swatch80 .swatch-label")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons span span")).click();
        WebElement itemAdded2 = driver.findElement(By.cssSelector(".success-msg span"));
        Assert.assertEquals("Elizabeth Knit Top was added to your shopping cart.", itemAdded2.getText());
        driver.findElement(By.cssSelector(".first .a-center [title = 'Remove Item']")).click();
    }

    @Test
    public void checkout() {
        driver.findElement(By.id("search")).sendKeys("ELIZABETH KNIT TOP");
        driver.findElement(By.cssSelector("[title='Search']")).click();
        driver.findElement(By.cssSelector(".actions [href*='tribeca']")).click();
        driver.findElement(By.cssSelector(".swatch-label img")).click();
        driver.findElement(By.cssSelector("#swatch67 .swatch-label")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons span span")).click();
        WebElement itemAdded1 = driver.findElement(By.cssSelector(".success-msg span"));
        Assert.assertEquals("TriBeCa Skinny Jean was added to your shopping cart.", itemAdded1.getText());
        driver.findElement(By.cssSelector(".cart-totals span span")).click();
        WebElement checkout = driver.findElement(By.cssSelector("h1"));
        Assert.assertEquals("CHECKOUT", checkout.getText());
    }

    @After
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
