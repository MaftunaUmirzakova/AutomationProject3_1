import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DuotifyDemo {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");

        String title = driver.getTitle();
        //if(title.equals("Welcome to Duotify!")){
//            System.out.println("Correct");
//        } else{
//            System.out.println("Incorrect");
//        }
        Assert.assertEquals(title, "Welcome to Duotify!");

    }




}
