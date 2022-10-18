package stepdefinition;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomePageStepDef {
	//public static WebDriver driver = null;
	WebDriver driver = Hooks.driver;

	@When("If Product name is {string} add it to cart")
	public void if_Product_name_is_add_it_to_cart(String Product) {
		String Xpath= "//div[text()='"+Product+"']//following::button[1]";
		WebElement cart= driver.findElement(By.xpath(Xpath));
		cart.click();

	}

	@Then("I check the corresponing Product numbers in the cart as been increased to {int}")
	public void i_check_the_corresponing_Product_numbers_in_cart_as_been_increased_to(Integer i) {
		
		String Xpath1 = "//*[@id='shopping_cart_container']/a/span[text()='"+i+"']";
		boolean CartNum = driver.findElement(By.xpath(Xpath1)).isDisplayed();
		Assert.assertTrue(CartNum);
		System.out.println("Number of Products in cart:" + i);
	}
	
}
