package com.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;

import com.constants.FrameworkConstants;
import com.enums.ConfigProperties;
import com.utils.JsonUtils;
import com.utils.PropertyUtils;

public final class Driver {
	private Driver() {
		
	}
	
	public static void initDriver() throws Exception {
		if(Objects.isNull(DriverManager.getDriver())) {
		System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriver());
		DriverManager.setDriver( new ChromeDriver());
		DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
