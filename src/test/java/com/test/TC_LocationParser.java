package com.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.assignment.LocationParser.ParserUtils;

public class TC_LocationParser {
	
	 @Test(priority = 0)
	    public void testGetCities_ValidCountryAndState() {
	        List<String> cities = ParserUtils.getCities("India", "Maharashtra");
	        Assert.assertEquals(cities.size(), 3);
	        Assert.assertTrue(cities.contains("Pune"));
	    }

	    @Test(priority = 1)
	    public void testGetCities_InvalidState() {
	        List<String> cities = ParserUtils.getCities("India", "InvalidState");
	        Assert.assertTrue(cities.isEmpty());
	    }

	    @Test(priority = 2)
	    public void testGetCountryAndStateByCity_ValidCity() {
	        String result = ParserUtils.getCountryAndStateByCity("Munich");
	        Assert.assertEquals(result, "Germany - Bavaria");
	    }

	    @Test(priority = 3)
	    public void testGetCountryAndStateByCity_InvalidCity() {
	        String result = ParserUtils.getCountryAndStateByCity("Atlantis");
	        Assert.assertEquals(result, "Not Found");
	    }
	}
	