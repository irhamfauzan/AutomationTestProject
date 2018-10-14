
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;


public class SignUp_Test {

    WebDriver driver;

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
    public void sign_up_1() throws InterruptedException {
        // Click Sign in
        WebElement button = driver.findElement(By.xpath("//div[contains(@class, 'header_user_info')]"));
        button.click();

        // Verify Field Email is empty
        WebElement email_error = driver.findElement(By.xpath("//div[@class='form-group']/input[@id='email_create']"));
        email_error.sendKeys("xyz@gmail.com");
        email_error.clear();
        Thread.sleep(2500);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='form-group form-error']/input[@id='email_create']")).isDisplayed());

    }

    @Test
    public void sign_up_2() throws InterruptedException {
        // Click Sign IN
        WebElement button = driver.findElement(By.xpath("//div[contains(@class, 'header_user_info')]"));
        button.click();

        // Create Account With Invalid Email
        WebElement email = driver.findElement(By.xpath("//div[@class='form-group']/input[@id='email_create']"));
        email.sendKeys("ABC");
        WebElement createBtn = driver.findElement(By.xpath("//button[contains(@id,'SubmitCreate')]"));
        createBtn.click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id, 'create_account_error')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='form-group form-error']/input[@id='email_create']")).isDisplayed());

    }

    @Test
    public void sign_up_3() throws InterruptedException {
        // Click Sign IN
        WebElement button = driver.findElement(By.xpath("//div[contains(@class, 'header_user_info')]"));
        button.click();

        // Create Account
        WebElement email = driver.findElement(By.xpath("//div[@class='form-group']/input[@id='email_create']"));
        email.sendKeys("abc@gmail.com");
        WebElement createBtn = driver.findElement(By.xpath("//button[contains(@id,'SubmitCreate')]"));
        createBtn.click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id, 'create_account_error')]")).isDisplayed());
    }


    @Test
    public void sign_up_5() throws InterruptedException {
        // Click Sign Up
        WebElement button = driver.findElement(By.xpath("//div[contains(@class, 'header_user_info')]"));
        button.click();

        // Create Account
        WebElement email = driver.findElement(By.xpath("//div[@class='form-group']/input[@id='email_create']"));
        String uuid = UUID.randomUUID().toString();
        email.sendKeys(uuid + "@gmail.com");
        WebElement createBtn = driver.findElement(By.xpath("//button[contains(@id,'SubmitCreate')]"));
        Thread.sleep(1500);
        createBtn.click();
        Thread.sleep(5000);

        // Verify UI Create Account //
        //Label Create Account
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='page-heading']")).isDisplayed());
        // Label Your Personal Info
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[1]/h3")).isDisplayed());
        // Label Title
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='account-creation_form']/div[1]/div[1]/label")).isDisplayed());
        // Label First Name
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[1]/div[2]/label")).isDisplayed());
        // Label Last Name
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[1]/div[3]/label")).isDisplayed());
        // Label email
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[1]/div[4]/label")).isDisplayed());
        // Label Password
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[1]/div[5]/label")).isDisplayed());
        // Label Date of Birth
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[1]/div[6]/label")).isDisplayed());
        // Label Your Address
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[2]/h3")).isDisplayed());
        // Label First Name
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[2]/p[1]/label")).isDisplayed());
        // Label Last Name
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[2]/p[2]/label")).isDisplayed());
        // Label Company
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[2]/p[3]/label")).isDisplayed());
        // Label Address
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[2]/p[4]/label")).isDisplayed());
        // Label Address 2
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[2]/p[5]/label")).isDisplayed());
        // Label City
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[2]/p[6]/label")).isDisplayed());
        // Label State
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[2]/p[7]/label")).isDisplayed());
        // Label ZIP
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[2]/p[8]/label")).isDisplayed());
        // Label Country
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[2]/p[9]/label")).isDisplayed());
        // Additional Info
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[2]/p[10]/label")).isDisplayed());
        // Label Home Phone
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[2]/p[12]/label")).isDisplayed());
        // Label Mobile Phone
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[2]/p[13]/label")).isDisplayed());
        // Label Address Alias
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='account-creation_form']/div[2]/p[14]/label")).isDisplayed());

        //Select Gender
        String valueOfGender = "2"; //in this case, value is integer, it can be String in most of the cases.

        List<WebElement> RadioButtonList = driver.findElements(By.name("id_gender"));

        System.out.println("Total numer of Radio Buttons for gender field is: " + RadioButtonList.size());

        for (int i = 0; i < RadioButtonList.size(); i++) {
            String gend = RadioButtonList.get(i).getAttribute("value");
            if (gend.equalsIgnoreCase((valueOfGender))) {
                RadioButtonList.get(i).click();
                break;
            }
        }

        //Enter customer details
        WebElement firstname= driver.findElement(By.xpath("//div[@class='required form-group']/input[@id='customer_firstname']"));
        firstname.sendKeys("FirstName");
        WebElement lastname = driver.findElement(By.xpath("//div[@class='required form-group']/input[@id='customer_lastname']"));
        lastname.sendKeys("lastName");
        WebElement pass = driver.findElement(By.xpath("//div[@class='required password form-group']/input"));
        pass.sendKeys("Rahasia");

//        Select date of Birth
        Select sDate = new Select(driver.findElement(By.xpath("//*[@id='days']")));
        sDate.selectByVisibleText("2  ");

        Select sMonth = new Select(driver.findElement(By.xpath("//*[@id='months']")));
        sMonth.selectByVisibleText("May ");

        Select sYear = new Select(driver.findElement(By.xpath("//*[@id='years']")));
        sYear.selectByVisibleText("2015  ");

        //select required check boxes
        String newsLetterReq = "Yes";
        if (newsLetterReq.equalsIgnoreCase(newsLetterReq)) {
            driver.findElement(By.xpath(".//*[@id='newsletter']")).click();
        }

        String reciveSpclOffer = "Yes";
        if (reciveSpclOffer.equalsIgnoreCase(reciveSpclOffer)) {
            driver.findElement(By.xpath("//*[@id='optin']")).click();
        }

        //Fill address related details
        driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("AddressFP");
        driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys("AddressFK");
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("CompanyAddress");
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("AddressOne");
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("AnyWhere   ");

        Select sState = new Select(driver.findElement(By.xpath("//*[@id='id_state']")));
        sState.selectByVisibleText("Alaska");

        driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("40000");

        Select sCountry = new Select(driver.findElement(By.xpath("//*[@id='id_country']")));
        sCountry.selectByVisibleText("United States");

        driver.findElement(By.xpath("//*[@id='other']")).sendKeys("Additional Information");
        driver.findElement(By.xpath("//*[@id='phone']")).sendKeys("606204579");
        driver.findElement(By.xpath("//*[@id='phone_mobile']")).sendKeys("081384293191");
        driver.findElement(By.xpath("//*[@id='alias']")).sendKeys("Address Alias ");

        driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
        Thread.sleep(3000);

    }
}