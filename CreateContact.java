package week2.day2.assingments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver =new ChromeDriver(); 

		driver.get("http://leaftaps.com/opentaps");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		String text =driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);

		Thread.sleep(3000);

		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Contacts")).click();

		driver.findElement(By.linkText("Create Contact")).click();

		driver.findElement(By.id("firstNameField")).sendKeys("test");

		driver.findElement(By.id("lastNameField")).sendKeys("leaf");

		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("M");

		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("H");

		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("QA");

		driver.findElement(By.id("createContactForm_description")).sendKeys("Testing");

		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("abc@gmail.com");

		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")); 
		Select dd1 =new Select(state);
		dd1.selectByVisibleText("New York");

		driver.findElement(By.name("submitButton")).click();

		driver.findElement(By.linkText("Edit")).click();

		driver.findElement(By.id("updateContactForm_description")).clear();

		driver.findElement(By.id("updateContactForm_description")).sendKeys("TestLeaf");

		driver.findElement(By.xpath("//input[@name='submitButton']")).click();

		String Title = driver.getTitle();
		System.out.println(Title);


		driver.close();

	}

}