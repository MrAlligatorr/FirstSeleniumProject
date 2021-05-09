import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    public void loginWithValidCredentials() {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("razvan@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("password");
        driver.findElement(By.id("send2")).click();

        driver.quit();
    }
}
