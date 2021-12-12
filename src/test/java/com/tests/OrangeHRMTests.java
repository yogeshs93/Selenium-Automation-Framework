package com.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.OrangeHRMLoginPage;

public final class OrangeHRMTests extends BaseTest{
	
	private OrangeHRMTests() {
	}
	@Test(dataProvider = "LoginTestDataProvider")
	public void loginLogoutTest(String username , String password) {
		
		
		
		OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
		
		
		
		
		String title = ohlp.enterUserame(username).enterPassword(password).clickLogin()
		.clickWelcome().clickLogout().getTitle();
		
		Assertions.assertThat(title)
		          .isEqualTo("OrangeHRM");
		
	}
	@DataProvider(name="LoginTestDataProvider",parallel=true)
	public Object[][] getData(){
		
		return new Object[][] {
			{"Admin","admin123"},
			{"Admin","admin1234"}
			/*{"Admin","admin123"},
			{"admin","admin"}*/
		};
		}
	

}
