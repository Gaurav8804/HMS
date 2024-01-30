import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MockTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.prokabaddi.com/");
		driver.findElement(By.xpath("//span[text()='Teams']")).click();
		driver.findElement(By.xpath(" //div[@class='card-item dabang-delhi']/descendant::div[@class='btn btn-more']"))
				.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");

		driver.findElement(By.xpath(
				" //div[@widget-id='si-squad-widget-layout-01']/descendant::div[@class='squad-listing swiper-wrapper']/div[@class='squad-item swiper-slide']//p[text()='Ashu']/ancestor::a/following-sibling::div/descendant::span")).click();
//		wait.until(ExpectedConditions.elementToBeSelected(ele));
//		ele.click();
		String TMP = driver.findElement(By.xpath(" //div[@class='right-content-section']/descendant::p[text()='14']"))
				.getText();
		System.out.println("Total matches played" + " : " + TMP);
		String RSR = driver.findElement(By.xpath(" //div[@class='right-content-section']/descendant::p[text()='53%']"))
				.getText();
		System.out.println("Raid Strike rate" + " : " + RSR);
		String TSR = driver.findElement(By.xpath(" //div[@class='right-content-section']/descendant::p[text()='67%']"))
				.getText();
		System.out.println("Tackle Strike Rate" + " : " + TSR);
		String TPE = driver.findElement(By.xpath(" //div[@class='right-content-section']/descendant::p[text()='147']"))
				.getText();
		System.out.println("Total Point Earned" + " : " + TPE);

	}

}
