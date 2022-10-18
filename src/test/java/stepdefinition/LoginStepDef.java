package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {
	WebDriver driver = Hooks.driver;

	@Given("I have launched the application")
	public void i_have_launched_the_application() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		// Assertion

		boolean Title = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).isDisplayed();
		Assert.assertTrue(Title);
	}

	@When("I enter the Username as {string} and Password as {string}")
	public void i_enter_the_Username_as_and_Password_as(String UN, String PW) {
		WebElement UserName = driver.findElement(By.id("user-name"));
		UserName.sendKeys(UN);
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys(PW);

	}

	@When("I click on the Login Button")
	public void i_click_on_the_Login_Button() {
		WebElement LoginBtn = driver.findElement(By.id("login-button"));
		LoginBtn.click();

	}

	@Then("I should land on the home page")
	public void i_should_land_on_the_home_page() {

		// Assertion

		WebElement Error1 = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
		String ActError1 = Error1.getText();
		String ExpError1 = "PRODUCTS";
		Assert.assertEquals(ActError1, ExpError1);

		// Assertion using login link

		String ActUrl = driver.getCurrentUrl();
		String ExpUrl = "https://www.saucedemo.com/inventory.html";

		Assert.assertEquals(ActUrl, ExpUrl);

	}

	@When("I enter the correct username and passowrd")
	public void i_enter_the_correct_username_and_passowrd() {
		WebElement UserName = driver.findElement(By.id("user-name"));
		UserName.sendKeys("standard_user");
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("secret_sauce");

	}

	@When("I enter the incorrect username and passowrd")
	public void i_enter_the_incorrect_username_and_passowrd() {
		WebElement UserName = driver.findElement(By.id("user-name"));
		UserName.sendKeys("standard_user");
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("secret_password");
	}

	@Then("I should get the error message {string}")
	public void i_should_get_the_error_message(String ExpError2) {
		WebElement Error2 = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3"));
		String ActError2 = Error2.getText();
		Assert.assertEquals(ActError2, ExpError2);

	}
}
