package RevisionSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class dragAndDropTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();
        WebElement capitale = driver.findElement(By.id("box6"));
        WebElement pay = driver.findElement(By.id("box106"));
        Actions ac = new Actions(driver);
        ac.dragAndDrop(capitale,pay).perform();
        Thread.sleep(4000);

        WebElement capitale2 = driver.findElement(By.id("box7"));
        WebElement pay2 = driver.findElement(By.id("box107"));
        Actions ac2 = new Actions(driver);
        ac2.dragAndDrop(capitale,pay).perform();
        Thread.sleep(4000);
        driver.quit();

    }

}
