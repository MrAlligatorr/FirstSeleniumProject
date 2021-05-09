import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register {

    public void RegisterWithValidCredentialsAndSubscribe(){
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Laura");
        driver.findElement(By.id("lastname")).sendKeys("Marry");
        driver.findElement(By.id("email_address")).sendKeys("marry@gmail.com");
        driver.findElement(By.id("password")).sendKeys("hello123");
        driver.findElement(By.id("confirmation")).sendKeys("hello123");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();

        driver.quit();
    }
}
