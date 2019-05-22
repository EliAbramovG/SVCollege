package lesson3;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HWLogin {

	public static WebDriver driver;
	Actions builder = new Actions(driver);

	WebElement fName = driver.findElement(By.id("FNTB"));
	WebElement lName = driver.findElement(By.id("LNTB"));
	WebElement email = driver.findElement(By.cssSelector("input[id='EmailTB']"));
	WebElement pass = driver.findElement(By.id("PassTB"));
	WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
	// WebElement title= driver.findElement(By.id("header"));
	String titleFirst = "Sign-Up/Login Form";
	String titleSecond ="Index of D";
	String URL = "";

	@BeforeClass
	public static void openBrowser() {
		// Chrome Driver browser
		System.setProperty("webdriver.chrome.driver", "D://Jars//chromedriver.exe");
		driver = new ChromeDriver();
		
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///D:/SVCollege/Selenium/class3/signUp/signUp/index.html");
	}


	@Test
	public void test1_Enter_Just_First_Name() throws InterruptedException {
		fName.clear();
		fName.sendKeys("omer");
		submit.click();
		URL = driver.getTitle();
		try {
			assertEquals(URL, titleFirst);
			System.out.println("test 1 : Error, You need to fill all the fields");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	@Test
	public void test2_Enter_First_And_Last_Name() throws InterruptedException {
		fName.clear();
		fName.sendKeys("omer");
		lName.clear();
		lName.sendKeys("Kenig");
		submit.click();
		URL = driver.getTitle();
		try {
			assertEquals(URL, titleFirst);
			System.out.println("test 2 : Error, You need to fill all the fields");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	@Test
	public void test3_Enter_One_Letter_In_Email() throws InterruptedException {
		fName.clear();
		fName.sendKeys("omer");
		lName.clear();
		lName.sendKeys("Kenig");
		email.clear();
		email.sendKeys("aa@aa.com");
		submit.click();
		URL = driver.getTitle();
		try {
			assertEquals(URL, titleFirst);
			System.out.println("test 3 : Error, You need to enter full email");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	@Test
	public void test4_Enter_First_Last_Name_And_Email() throws InterruptedException {
		fName.clear();
		fName.sendKeys("omer");
		lName.clear();
		lName.sendKeys("Kenig");
		email.clear();
		email.sendKeys("aa@aa.com");
		submit.click();
		URL = driver.getTitle();
		try {
			assertEquals(URL, titleFirst);
			System.out.println("test 4 : Error, You need to fill all the fields");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	@Test
	public void test5_Sanity_Test() throws InterruptedException {
		fName.clear();
		fName.sendKeys("omer");
		lName.clear();
		lName.sendKeys("Kenig");
		email.clear();
		email.sendKeys("aa@aa.com");
		pass.clear();
		pass.sendKeys("aa");
		submit.click();
		URL = driver.getTitle();
		try {
			if (URL.contains(titleSecond))
			System.out.println("Good");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
}
