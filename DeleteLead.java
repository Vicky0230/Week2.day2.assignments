package week2.day2.assingments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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

		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.linkText("Find Leads")).click();
		//Thread.sleep(3000);

		driver.findElement(By.linkText("Phone")).click();

		driver.findElement(By.name("phoneNumber")).sendKeys("234");

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);

		String LeadId = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]")).getText();

		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		Thread.sleep(3000);


		driver.findElement(By.linkText("Delete")).click();
		//Thread.sleep(3000);

		driver.findElement(By.linkText("Find Leads")).click();
		//Thread.sleep(3000);

		driver.findElement(By.name("id")).sendKeys(LeadId);

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		String Text = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		System.out.println(Text);

		if(Text.contains("No records to display")) 
		{
			System.out.println("Lead is deleted");
		}
		else
		{
			System.out.println("Lead is not deleted");
		}

		driver.close();
	} 


}