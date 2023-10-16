import com.github.javafaker.Faker;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SpotifyDemo {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[contains(text(),'Log in')]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Maftunacatering@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Spotify2023");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),\"Log In\")]")).click();
        Thread.sleep(2000);

       WebElement expected =driver.findElement(By.xpath("//div[@data-testid='placeholder-wrapper']"));
       Assert.assertTrue(expected.isDisplayed());

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(), 'Search')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys("Adele Hello");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class = \"_gB1lxCfXeR8_Wze5Cx9\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class=\"ButtonInner-sc-14ud5tc-0 gGxSiT encore-bright-accent-set\"]")).click();

        String songName = driver.findElement(By.xpath("//a[@aria-label='Now playing: Hello by Adele']")).getText();

        //Assert.assertEquals(songName, "Hello by Adele"); Could not implement this code


        driver.findElement(By.xpath("//div[@data-testid='placeholder-wrapper']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(), 'Log out')]")).click();

        Thread.sleep(2000);


        WebElement login1 = driver.findElement(By.xpath("//span[contains(text(), 'Log in')]"));
        System.out.println(login1.isDisplayed());

        driver.quit();
    }
}
