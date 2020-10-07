package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailGlue 
{
	public RemoteWebDriver driver ;
	public  Scenario s;
	WebDriverWait w;
	@Before
	public void scenario1(Scenario x)
	{
		this.s=x; 
	}
	@Given("^Launch Gmailsite$")
	public void OpenBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver","E:\\batch 244\\chromedriver.exe");
		driver=new ChromeDriver();

		//driver.get("https://www.gmail.com");
	}
	@When ("^I Open Gmail Website$") 
	public void gmailsite() throws Exception 
	{
		driver.get("https://www.gmail.com");
		s.write("Web Page Sucessfull Launched"); 
	}

	@Then("^Page Title is \"(.*)\"$")

	public void pagetitle (String et) // expected
	{
		// actial
		String at=driver.getTitle()	;
		if(at.equalsIgnoreCase(et))
		{
			System.out.println("Test is passed");	 
		}
		else
		{
			System.out.println("Test is failed");
		}
	}
	@And("^click uid next$")
	public void uidnext()
	{
		driver.findElement(By.xpath("//*[@class='VfPpkd-RLmnJb']7")).click();
	}

	@And("^click pwd next$")
	public void uidnextpassword()
	{
		driver.findElement(By.xpath("//*[@class='VfPpkd-RLmnJb']")).click();
	}
	@And("^Close site$")
	public void closesite()
	{
		driver.quit();
		s.write("Close site");

	}

	@When("^Enter User id \"(.*)\" Value$")
	public void user_Id(String uid) throws Exception
	{
		driver.findElement(By.name("identifier")).sendKeys(uid);
		Thread.sleep(5000);  
	}
	@Then("^validate user Output for \"(.*)\"Criteria$")
	public void criteria(String c) throws  Exception
	{
		try
		{
			if(c.equalsIgnoreCase("valid") && driver.findElement(By.name("password")).isDisplayed())
			{
				s.write("Userid Test passed for valid Uer ");
				System.out.println("valid password is passed");
			}
			else if(c.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'Google Account')])[2]|(//*[contains(text(),'Enter')])[2]")).isDisplayed())
			{
				s.write("userid Test  passed for invalid User");
				System.out.println("Invalid password is passed");
			}
			/*else if(c.equalsIgnoreCase("blank")&& driver.findElement(By.xpath("//*[text()='Enter a password']")).isDisplayed())
			{
				s.write("userid Test  passed for blank User");
				System.out.println("Blank Password Test is passed");
			}*/
			else
			{
				s.write(" Test Terminated");	
			}
		}
		catch(Exception ex)
		{
			s.write("Error Occur terminated");
		}
		Thread.sleep(5000);
	}

	@When ("^Enter Password id \"(.*)\"Value")
	public void password (String pwd)
	{
		try
		{
			if(driver.findElement(By.name("password")).isDisplayed())
			{
				driver.findElement(By.name("password")).sendKeys(pwd);
				s.write("user id is valid and password also");
				Thread.sleep(5000);
			}
			else
			{
				System.out.println("System id is invalid");
				s.write("user id is valid and password also");
			}
		}
		catch(Exception e)
		{
			s.write("User Id is Terminated");
		}
	}

	// paasword validation criteria

	@When("^validate Password Output for\"(.*)\"Critera$")
	public void passwordcriteria(String c) 
	{
		try
		{
			if(c.equalsIgnoreCase("valid")&&driver.findElement(By.xpath("//*[text()='Compose']")).isDisplayed())
			{
				s.write("Valid password Test is passed"); 
			}
			else if(c.equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("//*[text()='Enter a password']|//*[contains(text(),'Wrong password')]")).isDisplayed())
			{
				s.write("Password test for invalid password");
			}
			else
			{
				s.write("password test");
			}
		}
		catch (Exception ex)
		{
			s.write(" password Test Terminated in cath block"); 
		}
	}
}


