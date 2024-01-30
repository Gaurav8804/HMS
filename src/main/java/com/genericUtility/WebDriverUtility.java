package com.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public Select select(WebElement ele) {
		Select drp = new Select(ele);
		return drp;
	}

	public Actions action(WebDriver driver) {
		Actions act = new Actions(driver);
		return act;
	}

	public WebDriverWait ExplicitWait(WebDriver driver, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}

	/**
	 * This method is used to maximize the browser
	 * 
	 * @param driver
	 */
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void implicitWait(WebDriver driver, int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	public void explicitElementToBreClickable(WebDriver driver, int sec, WebElement ele) {

		ExplicitWait(driver, sec).until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void explicitElementToBeSelected(WebDriver driver, int sec, WebElement ele) {

		ExplicitWait(driver, sec).until(ExpectedConditions.elementToBeSelected(ele));
	}

	public void elementToBeVisible(WebDriver driver, int sec, WebElement ele) {

		ExplicitWait(driver, sec).until(ExpectedConditions.visibilityOf(ele));
	}

	public void alertIsPresent(WebDriver driver, int sec) {

		ExplicitWait(driver, sec).until(ExpectedConditions.alertIsPresent());
	}

	public void selectByOPtions(WebElement ele, int index) {

		select(ele).selectByIndex(index);
	}

	public void selectByOPtions(WebElement ele, String value) {
		select(ele).selectByValue(value);

	}

	public void selectByOPtions(String text, WebElement ele) {

		select(ele).selectByVisibleText(text);
	}

	public void deSelectByOptions(WebElement ele, int index) {

		select(ele).deselectByIndex(index);
	}

	public void click(WebDriver driver) {
		action(driver).click().perform();

	}

	public void clickOnWebElement(WebDriver driver, WebElement ele) {

		action(driver).click(ele).perform();
	}

	public void contextClickOnWebElement(WebDriver driver, WebElement ele) {

		action(driver).contextClick(ele).perform();
	}

	public void contextClick(WebDriver driver) {

		action(driver).contextClick().perform();
	}

	public void moveToElement(WebDriver driver, WebElement ele) {

		action(driver).moveToElement(ele);
	}

	public void moveToElement(WebDriver driver, int x, int y) {

		action(driver).moveByOffset(x, y);
	}

	public void doubleClick(WebDriver driver) {

		action(driver).doubleClick();
	}

	public void doubleClickByWebElement(WebDriver driver, WebElement ele) {

		action(driver).doubleClick(ele);
	}

	public void dragAndDrop(WebDriver driver, WebElement src, WebElement tgt) {

		action(driver).dragAndDrop(src, tgt);
	}

	public void toHandleAlertPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public String toHandleAlertPopupwithtext(WebDriver driver) {
		String alerttext = driver.switchTo().alert().getText();
		return alerttext;
	}

	public void confirmationPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void notificationPopup() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
	}

	public void frame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void frameByName(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	public void frameByName(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}

	public void switchToImmediateParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public void switchToDefault(WebDriver driver) {
		driver.switchTo().defaultContent();

	}

	public void toSwitchChildWindow(WebDriver driver, String id) {
		driver.switchTo().window(id);
	}

	public void switchToDesiredWindow(WebDriver driver, String partiaWinlTitle) {
		Set<String> Winds = driver.getWindowHandles();
		for (String wind : Winds) {
			String Title = driver.switchTo().window(wind).getTitle();
			if (Title.contains(partiaWinlTitle)) {
				driver.switchTo().window(wind);
			}
		}
	}

	public String getScreenShot(WebDriver driver, String ScrenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		String path="./Screenshots/" + ScrenshotName + ".jpeg";
		File src = new File(path);
		org.openqa.selenium.io.FileHandler.copy(temp, src);
		
		return src.getAbsolutePath();
	}

	public void scrollAction(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.ScrollBy(x,y)");
	}

}
