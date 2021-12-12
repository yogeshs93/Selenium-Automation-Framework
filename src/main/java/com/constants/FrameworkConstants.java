package com.constants;

import com.enums.ConfigProperties;
import com.utils.PropertyUtils;

public final class FrameworkConstants {


	private FrameworkConstants() {

	}
	private final static String RESOURCEPATH = System.getProperty("user.dir")+"/src/test/resources";
	private final static String CHROMEDRIVERPATH=RESOURCEPATH+"/executables/chromedriver.exe";
	private final static String CONFIGFILEPATH=RESOURCEPATH+"/config/config.properties";
	private final static int  EXPLICITWAIT = 10;
	private static final String JSONCONFIGFILEPATH = RESOURCEPATH + "/config/config.json";
	private static final String EXTENTREPORTFOLDERPATH = RESOURCEPATH+"/extent-test-output/index.html";
	private static String extentReportFilePath = "";
	
	
	
	public static String getExtentReportFilePath() throws Exception {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}


	private static String createReportPath() throws Exception {
		if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH+"/index.html";
		}
	}


	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}



	public static String getChromeDriver() {
		return CHROMEDRIVERPATH;
	}

	public static String getJsonconfigfilepath() {
		return JSONCONFIGFILEPATH;
	}

}
