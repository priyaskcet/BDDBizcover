package pageObjs;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;


public class Browsersetup {

	 protected WebDriver driver;
	WebDriverWait wait;
	LoginPageobj login;
	
	public void browsersetup(WebDriver driver) {
	    this.driver=driver;
			
	}

	
	
}
