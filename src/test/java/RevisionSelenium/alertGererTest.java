package RevisionSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class alertGererTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        driver.manage().window().setSize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//       Declarer un objet alert
        Alert monAlerte = driver.switchTo().alert();
//        Accpeter l alert
        String textMonALerteCurrent = monAlerte.getText();
        String textMonALerte="I am a JS Alert";
        System.out.println("le texte de l'alerte " + textMonALerte);
//        Assert.assertEquals(textMonALerte,textMonALerteCurrent);
        monAlerte.accept();
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert monAlerte2 = driver.switchTo().alert();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//Version 3
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Version 4 plus robuss
//      Thread.sleep(4000);
        String textMonALerte2="Click for JS Confirm";
        System.out.println("le texte de l'alerte " + textMonALerte2);
        monAlerte2.dismiss();
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert monAlerte3 = driver.switchTo().alert();
        String textMonALerte3="Click for JS Prompt";
        System.out.println("le texte de l'alerte " + textMonALerte3);
        monAlerte3.sendKeys("test ");
        monAlerte3.accept();
        String textResultCurrent = driver.findElement(By.id("result")).getText();
        if (textResultCurrent.contains("You entered: test")){
            System.out.println("Le tests devrait etre  : ===" +textResultCurrent  );
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }

        driver.quit();

    }

}
