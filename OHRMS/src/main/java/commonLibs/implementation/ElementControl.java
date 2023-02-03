package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementControl {
	WebDriver driver;

	public ElementControl(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickElement(WebElement element) {
		element.click();
	}
	
	public void clear(WebElement element) {
		element.clear();
	}
	
	public void settext(WebElement element, String text) {
		element.sendKeys(text);
	}
	public boolean isenabled(WebElement element) {
		 return element.isEnabled();
	}
	
	public boolean isDisplayed(WebElement element) {
		 return element.isDisplayed();
	}
	public void acceptAlert() {
		 driver.switchTo().alert().accept();
	}
	public void dismissalert() {
		driver.switchTo().alert().dismiss();
	}
	public String  gettextFromAlert() {
		return driver.switchTo().alert().getText();
	}
	
	
	public void selectviavisibletext(WebElement element,String text) {
		Select seldropdown=new Select(element);
		seldropdown.selectByVisibleText(text);
	}
}

