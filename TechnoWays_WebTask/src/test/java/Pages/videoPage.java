package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Wait;

public class videoPage {
	
	WebDriver driver;
	
	public videoPage(WebDriver driver) {
		this.driver = driver;
	}


	
	By Title_DisplayedVideo_Loca = By.xpath("//*[@id='container']/h1/yt-formatted-string");
	
	public String GetVideoTitle() {
		
		Wait.visibiabilityOfElement(driver, Title_DisplayedVideo_Loca);
		String DisplayedVideoTitle=driver.findElement(Title_DisplayedVideo_Loca).getText();
		
		return DisplayedVideoTitle;
	}
}
