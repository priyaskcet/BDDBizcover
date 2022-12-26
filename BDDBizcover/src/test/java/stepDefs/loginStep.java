package stepDefs;


import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;

import pageObjs.LoginPageobj;
import pageObjs.Browsersetup;


public class loginStep {
	WebDriver driver;
	LoginPageobj login;
	WebDriverWait wait;
	Browsersetup browser;
	

	
	@AfterStep
	public void afterstepscreenshot(io.cucumber.java.Scenario sc) {
		System.out.println("This will run after scenario");
		
		if(sc.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png", "Failure-screenshot of "+sc.getName() );
		}else
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png",sc.getName());
		}
		}

@Given("User opens the shopping site")
public void user_opens_the_shopping_site() {

	System.setProperty("webdriver.chrome.driver","/Users/priyae/git/BizcoverBDD/LumaShopping/src/test/resources/Drivers/chromedriver");
	System.out.println("Ending into functionchrome");
	driver = new ChromeDriver();
	wait=new WebDriverWait(driver, Duration.ofSeconds(4000));
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	login=new LoginPageobj(driver,wait);	
	
		
}

@When("User is on login page")
public void user_click_on_SignIn_link() {
   
	login.click_signin_link();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
}


@Then("^User enters (.*) and (.*)$")
public void user_enters_username_and_password(String username, String password) {
	
	
	login.enter_login_email(username);
	login.enter_login_password(password);
	login.click_login_btn();
}

@Then("User selects Top-> Jackets from the dropdown")
public void user_selects_top_jackets_from_the_dropdown() {
	System.out.println("into top->jack func");
	login.select_mentops();
	login.select_menJackets();
}


@And("^User selects (.*) from Jackets$")
public void user_selects_a_from_jackets(String Jacketname ) {
	try {
		login.select_frommenJackets_list(Jacketname);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@Then("^User Selects the (.*) , (.*) and (.*)$")
public void user_selects_the_size_colour_and_quantity(String  Size, String Colour, int Quantity) throws Exception {
	login.Select_productSize(Size);
	login.Select_productColour(Colour);
	login.Select_productQuantity(Quantity);
	
}
@And("User Selects pants from mens bottom")
public void User_selects_pants_from_mens_bottom() {
	System.out.println("into top->jack func");
	login.select_menbottoms();
	login.select_menpants();
	
}


@Then("User clicks on Add to cart")
public void user_clicks_on_add_to_cart() {
	login.Addtocart();
	System.out.println("Added to cart");	
	
}

@And("^User selects (.*) from Pants$")
public void user_selects_Pantname_from_pants(String Pantname ) {
	try {
		login.select_frommenJackets_list(Pantname);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


@Then("^User select pant (.*), (.*) and (.*)$")
public void user_select_pant_black_and(int PSize, String Colour, int Quantity) throws Exception {
   
	login.Select_bottomproductSize(PSize);
	login.Select_productColour(Colour);
	login.Select_productQuantity(Quantity);
}
@And("^Go to cart verify (.*),(.*) and proceed to checkout$")
public void Go_to_cart_verify( String Jacketname, String Pantname) throws InterruptedException {
	
	Thread.sleep(1000);
	login.gotoCart(Jacketname,Pantname);
}
@Then("Place Order")
public void Place_Order( ) throws InterruptedException {
	
	login.placeOrder();
}



}