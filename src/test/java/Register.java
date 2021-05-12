import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register {

    private WebDriver driver;

    @Before
    public void initialization() {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void RegisterWithValidCredentialsAndSubscribe(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title = 'Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Laura");
        driver.findElement(By.id("lastname")).sendKeys("Marry");
        driver.findElement(By.id("email_address")).sendKeys("marry1@gmail.com");
        driver.findElement(By.id("password")).sendKeys("hello1234");
        driver.findElement(By.id("confirmation")).sendKeys("hello1234");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("[title = 'Register'] span span")).click();
    }

    @After
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
