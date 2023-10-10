import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FindingElements {
    public static void main(String[] args) throws InterruptedException{



        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");


        driver.findElement(By.name("q")).sendKeys("chatgpt", Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains("chatgpt") );



        Thread.sleep(1000);
    }
}
