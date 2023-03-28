package RevisionSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class iframeTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/package-summary.html");
        driver.manage().window().maximize();
        Thread.sleep(4000);
        //Changer iframe
        driver.switchTo().frame(0);//1 er iframe
        driver.findElement(By.linkText("org.openqa.selenium")).click();
        Thread.sleep(4000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("packageFrame");
        driver.findElement(By.linkText("WebDriver")).click();
        driver.switchTo().defaultContent();
        WebElement myFrame = driver.findElement(By.name("classFrame"));
        Thread.sleep(4000);
        driver.switchTo().frame(myFrame);
        Thread.sleep(4000);
//        driver.findElement(By.linkText("Help")).click();
        driver.findElement(By.xpath("/html/body/header/nav/div[1]/div[1]/ul/li[8]")).click();

        Thread.sleep(4000);
        driver.quit();
    }

}
