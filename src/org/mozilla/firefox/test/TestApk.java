package org.mozilla.firefox.test;

import java.util.ArrayList;

import com.robotium.solo.By;
import com.robotium.solo.Solo;
import com.robotium.solo.WebElement;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class TestApk extends ActivityInstrumentationTestCase2 {
	
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "org.mozilla.firefox.App";
	
	private static Class launcherActivityClass;
	static {
		try {
			launcherActivityClass = Class
					.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public TestApk() throws ClassNotFoundException {
		super(launcherActivityClass);
	}

	private Solo solo;

	@Override
	protected void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testClearHistory() {

		solo.clickOnText("BOOKMARKS");
		
		
		TextView url =  (TextView) solo.getView("org.mozilla.firefox:id/url_bar_title");
		
		solo.clickOnView(url);
		
		EditText urlEnabled =  (EditText) solo.getView("org.mozilla.firefox:id/url_edit_text");
		
		solo.clearEditText(urlEnabled);
		solo.enterText(urlEnabled, "https://www.google.com.ua/");
		solo.pressSoftKeyboardSearchButton();
		
//		solo.enterTextInWebElement(By.id("gs_htif0"), "and action");
		
		
//		boolean isResultsDisplayed = solo.waitForText("Results");
		
		ArrayList<WebElement> resultsElement = solo.getWebElements(By.xpath("//div[@class='result-count' and contains(text(),'Results')]"));
//		assertTrue("wrong count for 'resuts' ", resultsElement.size()==1);
		
		Log.d("array size ", String.valueOf(resultsElement.size()));
		
//		assertTrue("Expected text is not found", solo.searchText("Results"));
		
		//View page = (View) solo.getView("org.mozilla.firefox:id/plugin_container");
		
		//solo.clickOnView(page);
		
		//WebView web;
		//ArrayList<WebElement> views = solo.getCurrentWebElements();
		  
		//Log.d("views size ", String.valueOf(views.size()));
		  

		
		
		//solo.clickOnWebElement(By.textContent("Next"));
		
//		solo.clickOnWebElement(By.className("next"));
		
//		solo.clickOnWebElement(By.textContent("Robotium Tech"));
//		solo.clickOnWebElement(By.xpath("//a[text()='Robotium Tech']"), 0);
		solo.scrollDown();
		solo.scrollUp();
		
	}
	
	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}
}