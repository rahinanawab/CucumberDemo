package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Steps {

    WebDriver driver;

    @Given("the user is on the nopCommerce login page")
    public void navigateToLoginPage() {
        driver = new ChromeDriver();
        //driver.get("https://demo.nopcommerce.com/");
        driver.get("https://tutorialsninja.com/demo");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().maximize();
        //driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
    }

    @When("the user enters valid credentials \\(username: {string}, password: {string})")
    public void the_user_enters_valid_credentials_username_password(String user, String pwd) {
        //driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(user);
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(user);
        //driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
    }

    @And("the user clicks on the Login button")
    public void the_user_clicks_on_the_login_button() {
        //driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Then("the user should be redirected to My Account page")
    public void the_user_should_be_redirected_to_my_account_page() {
        //boolean status = driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed();
        boolean status = driver.findElement(By.xpath("//a[normalize-space()='Account']")).isDisplayed();
        Assert.assertEquals(status,true);
    }

    @And("the user should see a message")
    public void the_user_should_see_a_message() {
        boolean txt = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
        Assert.assertTrue(txt);
        //boolean welcometext = driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).isDisplayed();
        //Assert.assertEquals(welcometext,"true");
        driver.quit();
    }

}
