import com.github.javafaker.Faker;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DuotifyDemo {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");

        String title = driver.getTitle();
        System.out.println(title);
        //if(title.equals("Welcome to Duotify!")){
//            System.out.println("Correct");
//        } else{
//            System.out.println("Incorrect");
//        }
//        Assert.assertEquals(title, "Welcome to Duotify!");
         WebElement signUpLink = driver.findElement(By.id("hideLogin"));
         signUpLink.click();


         Faker faker = new Faker();
        String userName = faker.name().username();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();


        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("email2")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("password2")).sendKeys(password);

        String fullName = firstName + lastName;



        driver.findElement(By.name("registerButton")).click();

        // Step 7: Verify URL after login
        Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/browse.php?");

        // Step 8: Verify first and last name in the left navigation bar
        String navBarName = driver.findElement(By.name("userLoggedIn")).getText();
        Assert.assertEquals(navBarName, firstName + " " + lastName);

        // Step 9: Click on the username and verify it on the main window
        driver.findElement(By.className("navBar__username")).click();
        String mainUsername = driver.findElement(By.id("username")).getText();
        Assert.assertEquals(mainUsername, userName);

        // Step 10: Click logout and verify the URL
        driver.findElement(By.id("logoutButton")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/register.php");

        // Step 11-12: Login and verify successful login
        // (Use the same username and password used during signup)
        driver.findElement(By.name("loginUsername")).sendKeys(userName);
        driver.findElement(By.name("loginPassword")).sendKeys(password);
        driver.findElement(By.name("loginButton")).click();

        // Wait for the page to load
        // Add appropriate wait here (e.g., WebDriverWait)

        // Step 13: Verify successful login by checking the home page text
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("You Might Also Like"));

        // Step 14: Logout and verify
        driver.findElement(By.className("navBar__username")).click();
        driver.findElement(By.id("logoutButton")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/register.php");

        // Close the browser
        driver.quit();
    }
}







