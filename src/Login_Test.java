import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_Test {

    WebDriver driver;
    String username="e44a831a-65e6-4bf3-b6ed-24fbead9b438@gmail.com";
    String password="Rahasia";

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public  void exit(){
        driver.close();
    }

    @Test
    public void login_case() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("//div[contains(@class, 'header_user_info')]"));
        button.click();

        //Login with Invalid Username
        driver.findElement(By.xpath("//div[@class='form-group']/input[@id='email']")).sendKeys("ABC@gmail.com");
        driver.findElement(By.xpath("//div[@class='form-group']//input[@id='passwd']")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(@id,'SubmitLogin')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert alert-danger')]")).isDisplayed());
        driver.findElement(By.xpath("//div[@class='form-group']/input[@id='email']")).clear();
        driver.findElement(By.xpath("//div[@class='form-group']//input[@id='passwd']")).clear();
        Thread.sleep(2000);

        //Login with Invalid Password
        driver.findElement(By.xpath("//div[@class='form-group form-error']/input[@id='email']")).sendKeys(username);
        driver.findElement(By.xpath("//div[@class='form-group']//input[@id='passwd']")).sendKeys("Password123");
        driver.findElement(By.xpath("//button[contains(@id,'SubmitLogin')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert alert-danger')]")).isDisplayed());
        driver.findElement(By.xpath("//div[@class='form-group']/input[@id='email']")).clear();
        driver.findElement(By.xpath("//div[@class='form-group']//input[@id='passwd']")).clear();
        Thread.sleep(2000);

        //Login with Invalid Username & Password
        driver.findElement(By.xpath("//div[@class='form-group form-error']/input[@id='email']")).sendKeys("ABC@gmail.com");
        driver.findElement(By.xpath("//div[@class='form-group']//input[@id='passwd']")).sendKeys("Password123");
        driver.findElement(By.xpath("//button[contains(@id,'SubmitLogin')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert alert-danger')]")).isDisplayed());
        driver.findElement(By.xpath("//div[@class='form-group']/input[@id='email']")).clear();
        driver.findElement(By.xpath("//div[@class='form-group']//input[@id='passwd']")).clear();
        Thread.sleep(2000);

        //Login with valid Username & Password
        WebElement email = driver.findElement(By.xpath("//div[@class='form-group form-error']/input[@id='email']"));
        email.sendKeys(username);
        WebElement pass = driver.findElement(By.xpath("//div[@class='form-group']//input[@id='passwd']"));
        pass.sendKeys(password);
        driver.findElement(By.xpath("//button[contains(@id,'SubmitLogin')]")).click();

        //Verify UI My Account
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='columns']/div[1]/span[2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='center_column']/h1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[1]/a")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[2]/a")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[3]/a")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[4]/a")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='center_column']/div/div[2]/ul/li/a")).isDisplayed());
    }

    //Logout
    @Test
    public void logout() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='logout']")).click();
        Thread.sleep(2000);
    }
}