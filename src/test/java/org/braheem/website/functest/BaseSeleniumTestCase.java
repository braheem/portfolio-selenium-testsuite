package org.braheem.website.functest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseSeleniumTestCase {
	
	private static WebDriver driver = SeleniumTestSuite.getDriver();
	private static WebDriverWait wait = SeleniumTestSuite.getWait();
	private final String baseUrl = "http://braheem.org";
	
	public static enum PageId {
		Home("homeLink"),
		Projects("projectPageLink"),
		Skills("skillsPageLink"),
		Resume("resumePageLink"),
		About("aboutPageLink"),
		Contact("contactPageLink");
		
		private String pageLink;
		private PageId(String pageLink){
			this.pageLink = pageLink;
		}
		
		public String getValue(){
			return pageLink;
		}
	}
	
	
	/*
	 * method to click element selected by pageLink id,
	 * then wait for response element selected by pageElement id
	 */
	public void testPageLink(String pageLink, String pageElement){
		
		//navigate to web site
		driver.get(baseUrl);
		By byId = By.id(pageLink);
		
		wait.until(ExpectedConditions.elementToBeClickable(byId)).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pageElement)));
	}
	
	
	public boolean testSkillNameValue(String name, String value){
		
		WebElement skillEntry; 
		
		By byXpathName = By.xpath("//figcaption[text()='" + name + "']");
		WebElement figCaption = wait.until(ExpectedConditions.elementToBeClickable(byXpathName));
		String nameText = figCaption.getText();
		
		skillEntry = figCaption.findElement(By.xpath("../.."));
		WebElement skillBar = skillEntry.findElement(By.xpath("./div"));
		String barText = skillBar.getText();
		
		if (nameText.equals(name) && barText.equals(value)){
			return true;
		}
		return false;
	}
	
}
