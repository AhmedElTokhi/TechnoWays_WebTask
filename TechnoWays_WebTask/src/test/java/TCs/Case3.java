package TCs;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.videoPage;
import Pages.youtubePage;
import utils.ReadingPropertiesFile;
import utils.WebDriverFactory;

public class Case3 {
	WebDriver driver;
	ReadingPropertiesFile data;
	utils.LogInFile Logger = new utils.LogInFile(Case3.class);

	@Test
	public void SearchBy_SeleniumTutorial_Display10thVideo() {
		try {

			System.out.println("-------------\n:@Test Case3: SearchBy_SeleniumTutorial and Display 10th Video");
			Logger.WriteLog(" Line " + Thread.currentThread().getStackTrace()[1].getLineNumber()
					+ "-------------\\n:@Test Case3: SearchBy_SeleniumTutorial and Display 10th Video");

			youtubePage YT_P = new youtubePage(driver);
			videoPage VP_P = new videoPage(driver);

			YT_P.SearchByKeyword(data.GetKeyword1());

			YT_P.FilterResultType();

			String listVideoTitle = YT_P.SelectResultVideo(Integer.parseInt(data.GetCase3VideoNo()));
//		System.out.println("TC search list is: "+listVideoTitle); //for Test

			String DisplayedVideoTitle = VP_P.GetVideoTitle();
//		System.out.println("TC DisplayedVideoTitle is: "+DisplayedVideoTitle);//for Test

			assertTrue(listVideoTitle.toLowerCase().contains(DisplayedVideoTitle.toLowerCase()));
			System.out.println("-------------\n:Result: Case3 Pass successfully.\n-------------");
			Logger.WriteLog(" Line " + Thread.currentThread().getStackTrace()[1].getLineNumber()
					+ "-------------\\n:Result: Case3 Pass successfully.\\n-------------");

		} catch (Exception e) {
			e.printStackTrace();
			Logger.WriteLog(" Line " + Thread.currentThread().getStackTrace()[1].getLineNumber() + "\n", e);
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void Setup() throws IOException {
		try {

			System.out.println("-------------\n:@BeforeMethod");
			Logger.WriteLog(" Line " + Thread.currentThread().getStackTrace()[1].getLineNumber()
					+ "-------------\\n:@BeforeMethod");

			data = Common_Methods.Call_ReadPropFile();

			driver = WebDriverFactory.Driver_Path(data.GetBrowser(), "./WebDriver/");
			driver.get(data.GetURL());

		} catch (Exception e) {
			e.printStackTrace();
			Logger.WriteLog(" Line " + Thread.currentThread().getStackTrace()[1].getLineNumber() + "\n", e);
		}

	}

	@AfterMethod(alwaysRun = true)
	public void Teardown(ITestResult Result) throws IOException {
		try {

			System.out.println(":@AfterMethod");
			Logger.WriteLog(" Line " + Thread.currentThread().getStackTrace()[1].getLineNumber() + ":@AfterMethod");

			// Add time stamp to use it screenshot
			long TimeStamp = System.currentTimeMillis();

			if (!Result.isSuccess()) {
				utils.ScreenCapture.getFullScreenShot(driver, ".\\Screenshot\\Fail" + TimeStamp + ".png");
			}

			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			Logger.WriteLog(" Line " + Thread.currentThread().getStackTrace()[1].getLineNumber() + "\n", e);
		}

	}
}
