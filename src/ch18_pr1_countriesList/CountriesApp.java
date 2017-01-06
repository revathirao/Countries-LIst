package ch18_pr1_countriesList;

import java.util.ArrayList;
import java.util.Scanner;

/**
* The CountriesApp program implements an application that
* simply displays countries list stored in the file. It also allows the user to add and save the countries.
*
* @author  RR
* @version 1.0
* @since   2016-12-22 
*/
public class CountriesApp {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Countries Maintenance application");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		CountriesTextFile countryFile = new CountriesTextFile();
		ArrayList<String> countries;
		String userChioce = "";
		int userInput = 0;
		
		//prints the command menu
		System.out.println("Command Menu");
		System.out.println("1- List countries");
		System.out.println("2- Add a country");
		System.out.println("3- Exit");
		System.out.println();

		while (!userChioce.equalsIgnoreCase("exit")) {
			userInput = Validator.getInt(sc,"Enter menu number: ");
			System.out.println();
			
			if (userInput == 1) {
				countries = countryFile.getCountries();
				
				for (String stList : countries) {
					System.out.println(stList);
				}
				
			} else if (userInput == 2) {
				String countryEntered = Validator.getStringCountry(sc,
						"Enter country");
				
				countryFile.addCountry(countryEntered);
				countryFile.saveCountries();
				System.out.println("This country has been saved.");
				
			} else {
				userChioce = "exit";
				System.out.println("Goodbye");
			}

		}

	}

}
