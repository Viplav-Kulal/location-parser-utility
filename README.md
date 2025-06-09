# Location Parser Utility

This utility provides methods to parse a hierarchical location JSON file containing countries, states, and cities. It allows querying cities by country and state, and reverse lookup of country and state by city name. The project includes :

- A reusable utility class (`ParserUtils`)
- Centralized path management via an interface (`IBaseInterface`)
- Logging using Log4j2
- TestNG-based parameterized test cases

The JSON structure is nested and hierarchical (countries → states → cities), and we need to search/filter inside those nested arrays, it’s simpler and more flexible to get the whole list as Java objects (List<Map<>>) and then iterate/filter.
JsonPath lets you extract nodes by simple paths (like $.countries[0].states[0].cities), but in this case, you need to dynamically find the country and state objects that match input parameters (country name, state name, city name). This is why, in the logic, explicit looping is done instead of simple JsonKey access.


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

##  Design Highlights (from Code Comments)

###  Static JSON Initialization

- `ParserUtils` loads and parses the JSON only **once** using a `static` block.
- This ensures the JSON is read once and remains available application-wide, improving performance and resource usage.

## Path Centralization
 - IBaseInterface defines constants to manage commonly used paths like the project root and the JSON file location.
 - Using constants keeps file path logic centralized and consistent across the project.

## Exception Handling & Logging
- Errors during JSON parsing or data lookup are caught and logged using Log4j2.
- This avoids hard crashes and ensures traceability through console or log files.
- If no matching data is found, the methods return Collections.emptyList() or "Not Found" instead of null.
- This makes error handling easier and avoids NullPointerException.


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

![Repo Views](https://komarev.com/ghpvc/?username=Viplav-kulal&repo=https://github.com/Viplav-Kulal/location-parser-utility.git&color=blue)



