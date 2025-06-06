package com.assignment.LocationParser;

import io.restassured.path.json.JsonPath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ParserUtils implements IBaseInterface {

	private static JsonPath jsonPath;
	// Created a static and initialzed it in the static block instead of
	// constructor, So that it will be initialised once only and can be used across
	// the project

	static {
		try {
			String jsonContent = new String(Files.readAllBytes(Paths.get(IBaseInterface.LOCATIONS_JSON_PATH)));
			jsonPath = new JsonPath(jsonContent);
		} catch (IOException e) {
			System.out.println("Failed to read or parse the JSON file");
			e.printStackTrace();
		}
	}

	private static final Logger logger = (Logger) LogManager.getLogger(ParserUtils.class);

	@SuppressWarnings("unchecked") // Added because we are casting json object to a List<Map> object
	public static List<String> getCities(String country, String state) {
		logger.info("Looking up cities for Country: " + country + " and State: " + state);
		try {
			List<Map<String, Object>> countries = jsonPath.getList("");
			for (Map<String, Object> c : countries) {
				if (country.equalsIgnoreCase((String) c.get("country"))) {
					List<Map<String, Object>> states = (List<Map<String, Object>>) c.get("states");
					for (Map<String, Object> s : states) {
						if (state.equalsIgnoreCase((String) s.get("state"))) {
							logger.info("List of cities found - " + (List<String>) s.get("cities"));
							return (List<String>) s.get("cities");
						}
					}
				}
			}
			logger.info("Country or State not found.");
		} catch (Exception e) {
			logger.error("Error while getting cities for Country: " + country + ", State: " + state);
			e.printStackTrace();
		}
		return Collections.emptyList(); // Returning an empty list if no city is found. This can be used for a further
										// test logic where no cities are returned and the data behavior changes further
										// clow.
	}

	@SuppressWarnings("unchecked")
	public static String getCountryAndStateByCity(String city) {
		try {
			logger.info("Looking up country and state for City: " + city);
			List<Map<String, Object>> countries = jsonPath.getList("");
			for (Map<String, Object> c : countries) {
				List<Map<String, Object>> states = (List<Map<String, Object>>) c.get("states");
				for (Map<String, Object> s : states) {
					List<String> cities = (List<String>) s.get("cities");
					if (cities.contains(city)) {
						logger.info("Found country : " +c.get("country")+ " and state : "+c.get("state"));
						return c.get("country") + " - " + s.get("state");
					}
				}
			}
			logger.info("City not found: " + city);
		} catch (Exception e) {
			logger.error("Error while getting country/state for City: " + city);
			e.printStackTrace();
		}
		return "Not Found";
	}
}
