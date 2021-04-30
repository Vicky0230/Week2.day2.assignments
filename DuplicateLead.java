package week2.day2.assingments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);

		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.linkText("Find Leads")).click();

		driver.findElement(By.linkText("Email")).click();

		driver.findElement(By.name("emailAddress")).sendKeys("abc@gmail.com");

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		String LeadName = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])/a")).getText();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();

		driver.findElement(By.xpath("//a[@class='subMenuButton']")).click();

		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("Duplicate Lead")) {
			System.out.println("This page is Duplicate Lead");

		}
		else
		{
			System.out.println("The page title is not Duplicate Lead");

		}

		driver.findElement(By.name("submitButton")).click();

		String DupName = driver.findElement(By.id("viewLead_firstName_sp")).getText();

		if(LeadName.equals(DupName))
		{
			System.out.println("Created Duplicate Name");
		}
		else
		{
			System.out.println("No Duplicate Created");
		}
		driver.close();



	}
}

