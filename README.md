# Location Parser Utility

This utility provides methods to parse a hierarchical location JSON file containing countries, states, and cities. It allows querying cities by country and state, and reverse lookup of country and state by city name.

##  Project Structure

<pre> 
LocationParser/
├── src/
│ ├── main/
│ │ └── java/com/assignment/LocationParser/
│ │ ├── ParserUtils.java
│ │ └── IBaseInterface.java
│ └── main/resources/
│ └── locations.json
│ └── test/
│ └── java/com/test/
│ └── TC_LocationParser.java
├── pom.xml
└── README.md
</pre>

## Features

- Get cities based on country and state.
- Get country and state based on a city.
- Built using:
  - **Java**
  - **RestAssured** (for JsonPath)
  - **Log4j2** (for logging)
  - **TestNG** (for unit testing)
  - **Maven** (for build and dependency management)

## How It Works
The ParserUtils class reads locations.json from the resources folder once using a static block and provides utility methods.

IBaseInterface defines the constant paths used in the project, including LOCATIONS_JSON_PATH.

## Test Cases
The TC_LocationParser class validates both positive and negative scenarios, such as:
- Valid country and state (expects cities).
- Invalid state (expects empty list).
- Valid city (expects correct country/state).
- Invalid city (expects "Not Found").
  

Build the project using:
<pre> mvn install </pre>

Run tests using:
<pre> mvn clean test </pre>


