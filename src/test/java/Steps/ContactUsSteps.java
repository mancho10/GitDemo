package Steps;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactUsSteps {
	WebDriver driver;
	
	@Before
	public void setup() throws IOException
	{
		System.setProperty("webdriver.chrome.driver",Paths.get(System.getProperty("user.dir")).toRealPath() +"\\src\\test\\java\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS);
		
	}
	
	@After
	public void tearDown()
	{
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}

	@When("^I enter a valid first name$")
	public void i_enter_a_valid_first_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
		String ManiWinHandle=driver.getWindowHandle();
		Set<String> childWin=driver.getWindowHandles();
		
		for(String Child:childWin)
		{
			driver.switchTo().window(Child);
		}
		
		driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("Tom");
	}

	@When("^I enter a valid last name$")
	public void i_enter_a_valid_last_name(DataTable table) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		List<List<String>>data=table.raw();
		driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys(data.get(0).get(1));
	}

	@When("^I enter a valid email address$")
	public void i_enter_a_valid_email_address() throws Throwable {
	   
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("webdriveruniversity@outlook.com");
	}

	@When("^I enter a non valid first name$")
	public void i_enter_a_non_valid_first_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("Invalid FName");
	}

	@When("^I enter a non valid last name$")
	public void i_enter_a_non_valid_last_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys("Invalid LName");
	}
	@When("^I enter a non valid email address$")
	public void i_enter_a_non_valid_email_address() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("Invalid webdriveruniversity utlook.com");
	}

	@When("^I enter no comments$")
	public void i_enter_no_comments() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("no comment");
	}

	@Then("^the information should not be successfully be submitted via the contact us form$")
	public void the_information_should_not_be_successfully_be_submitted_via_the_contact_us_form() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //
	}

	@Then("^the user should also be notified of the problem$")
	public void the_user_should_also_be_notified_of_the_problem() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

@Given("^I access webdriveruniversity$")
public void i_access_webdriveruniversity() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.get("http://www.webdriveruniversity.com/");
}

@When("^I click on the contact us button$")
public void i_click_on_the_contact_us_button() throws Throwable {
	
	driver.findElement(By.id("contact-us")).click();
   
}

@When("^I enter comments$")
public void i_enter_comments(DataTable table) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	List<List<String>>data=table.raw();
	driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(data.get(0).get(0) +"\n");
	driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(data.get(0).get(1));
}

@When("^I click on the submit button$")
public void i_click_on_the_submit_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.cssSelector("input[value='SUBMIT']")).click();
}

@Then("^the information should successfully be submitted via the contact us form$")
public void the_information_should_successfully_be_submitted_via_the_contact_us_form() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}
	

}
