package pageObjs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LumaPageobj {

		 WebDriver driver;
		WebElement webelement;
		WebDriverWait wait;
		Actions action;
		String orderNumber;
		static double sum=0.0;

		By SignIn_link= By.xpath("//*[contains(text(),'Sign In')]");
		By login_email= By.xpath("//*[@id=\"email\"]");
		By login_password= By.xpath("//*[@id=\"pass\"]");
		By login_btn= By.xpath("//button[@class=\"action login primary\"]");
		By logout_options_click= By.xpath("//header/div[1]/div/ul/li[2]/span/button");
		By logout_btn= By.xpath("//a[contains(text(),'Sign Out')]");
		By btn_Myaccount= By.xpath("//*[@class=\"header links\"]/li/a[contains(text(),'My Account')]");
		By lnk_Myorders= By.xpath("//a[contains(text(),\"My Orders\")]");
		By myorders_table=By.xpath("//*[@id=\"my-orders-table\"]");
		By myorder_col=By.xpath("//*[@id=\"my-orders-table\"]/thead/tr/th");
		By myorder_row=By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr");
		
		
		By Home_Men= By.xpath("//a[@class='level-top ui-corner-all']//span[contains(text(),\"Men\")]");
		By Home_Men_Tops= By.xpath("//*[@id=\"ui-id-17\"]//span[contains(text(),\"Tops\")]");
		
		By Home_Men_Tops_Jackets= By.xpath("//*[@id=\"ui-id-19\"]//span[contains(text(),\"Jackets\")]");
		By Home_Men_Bottoms=By.xpath("//*[@id=\"ui-id-18\"]//span[contains(text(),\"Bottoms\")]");
		By Home_Men_Bottoms_pants=By.xpath("//*[@id=\"ui-id-23\"]//span[contains(text(),\"Pants\")]");
		
		By Home_Men_Jackets_list= By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li");
		By Jackets_total_items= By.xpath("//*[@id=\"toolbar-amount\"]");
		By Jackets_Sizes_list=By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div");
		By Pant_list=By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div");
		
		By Jackets_colour_list=By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div");
		By Jackets_quantity=By.xpath("//*[@id=\"qty\"]");
		By btn_Addtocart=By.xpath("//*[@id=\"product-addtocart-button\"]");
		By btn_cart=By.xpath("//*[@class=\"action showcart\"]");
		By btn_goto_Checkout=By.xpath("//*[@id=\"top-cart-btn-checkout\"]");
		By btn_checkout_Next=By.xpath("//*[@class=\"button action continue primary\"]");
		By btn_checkout_Placeorder=By.xpath("//*[@class=\"action primary checkout\"]");
		By get_ordernumber=By.xpath("//*[@class=\"order-number\"]");
		By get_getitemPrice=By.xpath("//*[@itemprop=\"offers\"]");
		
		
		
		public LumaPageobj(WebDriver driver,WebDriverWait wait)
		{
			this.driver=driver;
			this.wait=wait;
		
			
		}
		

		public void click_signin_link()
		{
			
			driver.navigate().to("https://magento.softwaretestingboard.com/");
			driver.findElement(SignIn_link).click();
		}
		public void enter_login_email(String username)
		{
			driver.findElement(login_email).sendKeys(username);
		}
		public void enter_login_password(String password)
		{
			driver.findElement(login_password).sendKeys(password);
		}
		public void click_login_btn()
		{
			driver.findElement(login_btn).click();
		}
		public void click_logoutoption_link()
		{
			driver.findElement(logout_options_click).click();
			driver.findElement(logout_btn).click();
		
		}
		public void select_mentops()
		{
			
			action = new Actions(driver);
			action.moveToElement(driver.findElement(Home_Men)).build().perform();
			action.moveToElement(driver.findElement(Home_Men_Tops)).build().perform();
			
			}
		public void select_menJackets()
		{
			
			
			action.moveToElement(driver.findElement(Home_Men_Tops_Jackets)).build().perform();
			driver.findElement(Home_Men_Tops_Jackets).click();
		}
		public void select_menbottoms()
		{
		
			action = new Actions(driver);
			action.moveToElement(driver.findElement(Home_Men)).build().perform();
			action.moveToElement(driver.findElement(Home_Men_Bottoms)).build().perform();
			
			}
		

		public void select_menpants()
		{
			
			
			action.moveToElement(driver.findElement(Home_Men_Bottoms_pants)).build().perform();
			driver.findElement(Home_Men_Bottoms_pants).click();
		}
		
		public void select_frommenJackets_list(String productname) throws Exception 
		{
			
			String itemsize = driver.findElement(Jackets_total_items).getText();
			String newitemsize = itemsize.replaceAll(" Items", "");
			int a = Integer. parseInt(newitemsize);
			
			for(int i=1;i<=a;i++)
			{
				
				String list_jackets_xpath="//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li["+i+"]";
				String C=driver.findElement(By.xpath(list_jackets_xpath)).getText();
				String[] arr = C.split("\n");
			
			    System.out.println(arr[0]);
			    System.out.println(productname);
				
				if(arr[0].equalsIgnoreCase(productname))
				{
				
				driver.findElement(By.xpath(list_jackets_xpath)).click();
				
					break;
				}		
			}
			
		}
		
		public void select_frommenpants_list(String productname) throws Exception 
		{
			
			String itemsize = driver.findElement(Jackets_total_items).getText();
			String newitemsize = itemsize.replaceAll(" Items", "");
			int a = Integer. parseInt(newitemsize);
			
			for(int i=1;i<=a;i++)
			{
				
				String list_pants_xpath="//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li["+i+"]";
				String C=driver.findElement(By.xpath(list_pants_xpath)).getText();
				String[] arr = C.split("\n");
			   
				
				if(arr[0].equalsIgnoreCase(productname))
				{
					 System.out.println("User selects the  "+productname);
				driver.findElement(By.xpath(list_pants_xpath)).click();
				
					break;
				}		
			}
			
		}
		public void sum_productprice_cart(int qantity)
		{
			System.out.println(driver.findElement(get_getitemPrice).getText());
			String price=driver.findElement(get_getitemPrice).getText();
			String price_split=price.replace("As low as", "");
			String price_removespace=price_split.replace("\n", "");
			String price_removedollar=price_removespace.replace("$", "");
		
			double price_final=Double.parseDouble(price_removedollar);
			
			double total=price_final*qantity;
			sum=sum+total;
			System.out.println("Price of the product : "+ total );
			System.out.println("Price in cart : "+sum);
			
		}
		public void Select_productSize(String siz)
		{
			
			
			 List<WebElement> sizeoptions_elements = driver.findElements(By.xpath("//*[@class=\"swatch-option text\"]"));
			int s= sizeoptions_elements.size();
			 
			sizeoptions_elements.get(0).getText();
			
			String b = sizeoptions_elements.get(0).getText();
			
			for (int i=1;i<=s;i++) {
				
			
				if(sizeoptions_elements.get(i).getText().equalsIgnoreCase(siz))
				{
					sizeoptions_elements.get(i).click();
					
					break;
				}}
			}
		
		public void Select_bottomproductSize(int siz)
		{
			
			
			 List<WebElement> sizeoptions_elements = driver.findElements(By.xpath("//*[@class=\"swatch-option text\"]"));
			int s= sizeoptions_elements.size();
		
			for(int j=0;j<s;j++)
			{
				int pantsize=Integer.parseInt(sizeoptions_elements.get(j).getText());
				System.out.println("Size of pant : "+pantsize);
				if(pantsize==siz)
				{
					sizeoptions_elements.get(j).click();
				}
				
			}
			
			
		}
		public void Select_productColour(String colour) throws Exception
		{
			 List<WebElement> coloroptions_elements = driver.findElements(By.xpath("//*[@class=\"swatch-option color\"]"));
				int c= coloroptions_elements.size();
				
				 	for(int j=0;j<c;j++)
				 	{
				        coloroptions_elements.get(j).getText();
				
						String shirtcolour= coloroptions_elements.get(j).getCssValue("background-color");
						String hexcolour=Color.fromString(shirtcolour).asHex();
//						System.out.println(shirtcolour);
//						System.out.println(hexcolour);
//						System.out.println(Color.fromString(colour).asHex());
//						System.out.println(Color.fromString(colour).asRgba());
					
					String Expcolour=Color.fromString(colour).asHex();
						
						if(hexcolour.equalsIgnoreCase(Expcolour))
						{
							coloroptions_elements.get(j).click();
						
					    }
				 	}		
		}
			
		public void Select_productQuantity(int quantity)
		
		{
			String quantity_str=Integer.toString(quantity);
			driver.findElement(Jackets_quantity).clear();
			driver.findElement(Jackets_quantity).sendKeys(quantity_str);
			
			 sum_productprice_cart(quantity);
			
		}
	public void Addtocart()
		
		{	
			driver.findElement(btn_Addtocart).click();
			select_mentops();
			select_menJackets();
			
		}
		
	public void gotoCart(String Jacketname, String Pantname)
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.findElement(btn_cart).click();
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		verify_product_in_cart(Jacketname,Pantname);
		driver.findElement(btn_goto_Checkout).click();
	}
	
	public void placeOrder() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(btn_checkout_Next)));
		Thread.sleep(4000);
		driver.findElement(btn_checkout_Next).click();
		Thread.sleep(4000);
		driver.findElement(btn_checkout_Placeorder).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(get_ordernumber)));
		orderNumber=driver.findElement(get_ordernumber).getText();
		System.out.println("Order number for order placed :"+orderNumber);
		
	
	
	}
	
	
	public void goto_orders() throws InterruptedException
	{
		Thread.sleep(50);
		driver.findElement(logout_options_click).click();
		
		driver.findElement(btn_Myaccount).click();
		Thread.sleep(50);
		driver.findElement(lnk_Myorders).click();
	}
	
	public void verify_orderid_ordersummary()
	{
		
		driver.findElement(myorders_table);
		
		List<WebElement> row = driver.findElements(myorder_row);
		
		List<WebElement> col = driver.findElements(myorder_col);
		
		for(int i=1;i<row.size();i++)
		{
			
			String cellvalue = driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr["+i+"]/td[1]")).getText();
			if (cellvalue.equalsIgnoreCase(orderNumber))
			{
			System.out.println("Placed order is listed in the My orders page : "+orderNumber);
			System.out.println("Order number for order placed :"+orderNumber);
			}
			
		}
		
	}	
	public void verify_product_in_cart(String jacketname, String pantname)
	{
		
		
		int total_items=driver.findElements(By.xpath("//*[@class=\"product-item-details\"]")).size();
		for(int i=0;i<total_items;i++)
		{
			String items=driver.findElements(By.xpath("//*[@class=\"product-item-details\"]")).get(i).getText();
			
			String[] items1 = items.split("\n");
			
			if(items1[0].equalsIgnoreCase(jacketname.replace("Jackshirt ", "Jackshirt")))
			{
			System.out.println("Correct products are added in the cart :"+items1[0]);
			}else{if(items1[0].equalsIgnoreCase(pantname.replace("Pant ", "Pant")))
				System.out.println("Correct products are added in the cart :"+items1[0]);
			}
			
		}	
	}
	}

	
	
	

