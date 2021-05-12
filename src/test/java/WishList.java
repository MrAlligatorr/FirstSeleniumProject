import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishList {

    private WebDriver driver;

    @Before
    public void initialization() {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void addItemToWishlistBeforeLogin() {
        driver.findElement(By.cssSelector(".nav-5 .has-children")).click();
        driver.findElement(By.cssSelector("a.button")).click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();
        driver.findElement(By.id("email")).sendKeys("razvan@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("password");
        driver.findElement(By.id("send2")).click();
    }

    @Test
    public void addItemToWishListAfterLogIn() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title = 'Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("razvan@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("password");
        driver.findElement(By.id("send2")).click();
        WebElement welcomeText = driver.findElement(By.cssSelector(".hello strong"));
        Assert.assertEquals("Hello, Andreica Razvan Liviu!", welcomeText.getText());
        WebElement welcomeTextUp = driver.findElement(By.cssSelector("p.welcome-msg"));
        Assert.assertEquals("WELCOME, ANDREICA RAZVAN LIVIU!", welcomeTextUp.getText());
        driver.findElement(By.cssSelector(".nav-5 .has-children")).click();
        driver.findElement(By.cssSelector("a.button")).click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();
        WebElement confirmationText = driver.findElement(By.cssSelector(".success-msg span"));
        Assert.assertEquals("Slim fit Dobby Oxford Shirt has been added to your wishlist. Click here to continue shopping.", confirmationText.getText());
    }

    @After
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
