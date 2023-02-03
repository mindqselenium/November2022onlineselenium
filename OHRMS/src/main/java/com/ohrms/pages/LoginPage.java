package com.ohrms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	
	@CacheLookup
	@FindBy(name = "username")
	private WebElement usernamefield;

	@FindBy(name = "password")
	private WebElement passwordfield;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	private WebElement loginbutton;
	
	public LoginPage (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void logintoapplication(String username,String password) {
		elementcontrol.settext(this.usernamefield, username);
		elementcontrol.settext(this.passwordfield, password);
		elementcontrol.clickElement(loginbutton);
		
	}
}
