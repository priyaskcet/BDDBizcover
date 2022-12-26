package stepDefs;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;

import io.cucumber.java.en.And;

import pageObjs.LumaPageobj;

public class LumaStep {
	WebDriver driver;
	LumaPageobj login;
	WebDriverWait wait;

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
	@After
	public void driverclose()
	{
	driver.close();}


@Given("User opens the shopping site")
public void user_opens_the_shopping_site() {

	System.setProperty("webdriver.chrome.driver","/Users/priyae/git/BizcoverBDD/LumaShopping/src/test/resources/Drivers/chromedriver");
	System.out.println("Ending into functionchrome");
	driver = new ChromeDriver();
	wait=new WebDriverWait(driver, Duration.ofSeconds(4000));
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();

	login=new LumaPageobj(driver,wait);	
	login.click_signin_link();
	
		
}

@When("User is on login page")
public void user_click_on_SignIn_link() {
	System.out.println("User is on Login Page");
	login.click_signin_link();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
}


@Then("^User enters (.*) and (.*)$")
public void user_enters_username_and_password(String username, String password) {
	System.out.println("User enters the username and password and login" );
	
	login.enter_login_email(username);
	login.enter_login_password(password);
	login.click_login_btn();
}

@Then("User selects Top-> Jackets from the dropdown")
public void user_selects_top_jackets_from_the_dropdown() {
	System.out.println("User Logged in to the application and ready to shop men jackets and pants");
	login.select_mentops();
	login.select_menJackets();
}


@And("^User selects (.*) from Jackets$")
public void user_selects_a_from_jackets(String Jacketname ) {
	try {
		System.out.println("User select " + Jacketname + "  from the listed jackets" );
		login.select_frommenJackets_list(Jacketname);
	} catch (Exception e) {
	
		e.printStackTrace();
	}
}

@Then("^User Selects the (.*) , (.*) and (.*)$")
public void user_selects_the_size_colour_and_quantity(String  Size, String Colour, int Quantity) throws Exception {
	System.out.println("User choose the colour , size and Quantity of Product");
	login.Select_productSize(Size);
	login.Select_productColour(Colour);
	login.Select_productQuantity(Quantity);
	
}
@And("User Selects pants from mens bottom")
public void User_selects_pants_from_mens_bottom() {
	System.out.println("User selects the pant");
	login.select_menbottoms();
	login.select_menpants();
	
}


@Then("User clicks on Add to cart")
public void user_clicks_on_add_to_cart() {
	login.Addtocart();
	System.out.println("Item Added to cart");	
	
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
public void user_select_pant_black_and(int PSize, String Colour, int PQuantity) throws Exception {
   System.out.println("User selects the pant size, colour, quantity");
	login.Select_bottomproductSize(PSize);
	login.Select_productColour(Colour);
	login.Select_productQuantity(PQuantity);
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


@And("Go to My orders")
public void Go_to_My_orders( ) throws Exception {
	System.out.println("User is on My orderspage ");
	login.goto_orders();
}

@Then("Verify for the order number")
public void Verify_order_number( ) throws InterruptedException {
	System.out.println("User Verifies the ordernumber in the table ");
	login.verify_orderid_ordersummary();

}
@Then("Logout")
public void logout( )  {
	System.out.println("User Logs out of the application ");
	login.click_logoutoption_link();

}

}