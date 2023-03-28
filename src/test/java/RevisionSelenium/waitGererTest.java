package RevisionSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waitGererTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        driver.manage().window().setSize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//Version 3
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Version 4 plus robuss
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement waituserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        waituserName.sendKeys("Admin");
//        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button")).click();

        driver.quit();

    }

}
