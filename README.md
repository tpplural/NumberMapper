# Mapping numbers (and their divisors) to predefined text

This is a simple Spring Boot application, that accepts as input category and numbers (in range from 1 to 20), and responds with numbers and
corresponding mapped divisors.

## Usage
The application can be built using maven (mvn package) or run directly in IDE of choice (ThetaskApplication.java beeing the entry point).
When started, it listens on port 8082, and accepts GET requests under /mapping.
Two request parameters are expected:
* category decides which category will be used for mapping
* val - number in range 1-20, can be specified nultiple times

There are 10 categories defined :
*  Furniture
*  Toys
*  Animals
*  Weapons
*  Transformers
*  Poultry
*  Poets
*  Minerals
*  Oxymorons
*  Simpletons


## Example:
'''
http://localhost:8082/mapping?val=12&val=2&category=Furniture
'''
