package com.assignment.LocationParser;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public interface IBaseInterface {
	public static final String PROJECT_PATH = new File("").getAbsolutePath();
	public static final String RESOURCE_PATH = new File("").getAbsolutePath() + "/src/main/resources";
	public final static String LOCATIONS_JSON_PATH = "./src/main/resources/locations.json";
	// Can add other generic paths to other files like screenshots, loggers and test
	// regression suites using above
	
	// Have defined these as final so these cannot be changed at any point during execution.
}