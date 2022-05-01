package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Wait;

public class youtubePage {
	WebDriver driver;
	String URL;

	public youtubePage(WebDriver driver) {
		this.driver = driver;
	}

	By Input_Txt_Search_Loca = By.cssSelector("input#search");
	By But_Search_Loca = By.xpath("//*[@id=\'search-icon-legacy\']/yt-icon");
	By Link_Filter_Loca = By.cssSelector("#button [class='style-scope ytd-toggle-button-renderer style-text']");
	By link_Video_Loca = By.xpath("//*[@id=\'label\' and @title=\'Search for Video\']");

	String Titile_Video_Part1 = "//ytd-video-renderer[";
	String Titile_Video_Part2 = "]/div[1]//div[1]/div/h3/a";

	public void SearchByKeyword(String Keyword) {

		Wait.Presence(driver, Input_Txt_Search_Loca);
		driver.findElement(Input_Txt_Search_Loca).click();
		driver.findElement(Input_Txt_Search_Loca).clear();
		driver.findElement(Input_Txt_Search_Loca).sendKeys(Keyword);

		Wait.visibiabilityOfElement(driver, But_Search_Loca);
		driver.findElement(But_Search_Loca).click();
	}

	public void FilterResultType() {

		Wait.visibiabilityOfElement(driver, Link_Filter_Loca);
		driver.findElement(Link_Filter_Loca).click();

		Wait.visibiabilityOfElement(driver, link_Video_Loca);
		driver.findElement(link_Video_Loca).click();

	}

	public String SelectResultVideo(int VideoNo) {

		// Define new locator based on entered number
		String video_Locator_newXPath = Titile_Video_Part1 + Integer.toString(VideoNo) + Titile_Video_Part2;
		By Video_Locator = By.xpath(video_Locator_newXPath);

		Wait.visibiabilityOfElement(driver, Video_Locator);
//		driver.findElement(video_Locator).getText();

		String listVideoTitle = driver.findElement(Video_Locator).getText();
		System.out.println("The video no " + VideoNo + " title is: " + listVideoTitle);

		driver.findElement(Video_Locator).click();

		return listVideoTitle;
	}
}
