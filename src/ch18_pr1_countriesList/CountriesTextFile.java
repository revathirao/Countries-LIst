package ch18_pr1_countriesList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
* The CountriesTextFile class allows user to read the list of countries as well as to add countries.
* @author  RR
* @version 1.0
* @since   2016-12-22 
*/
public class CountriesTextFile {

	private ArrayList<String> countries = null;
	private Path countriesPath = null;
	private File countriesFile = null;
	
	 /** 
	    * Class constructor.
	 */
	public CountriesTextFile() {
		countriesPath = Paths.get("c:\\Country1.txt");
		countriesFile = countriesPath.toFile();
		countries = this.getCountries();
	}
	/**
	 * This method gets the countries list
	 * @return countries
	 * @throws IOException  If an input or output 
	 * exception occurred
	 */
	public ArrayList<String> getCountries() {
		// if the customers file has already been read, don't read it again
		if (countries != null)
			return countries;

		countries = new ArrayList<>();

		if (Files.exists(countriesPath)) {

			try (BufferedReader input = new BufferedReader(new FileReader(
					countriesFile))) {
				// reasd all customers stored in the file into the array list
				String line = input.readLine();

				while (line != null) {
					countries.add(line);

					line = input.readLine();
				}
			}
			
			/**
			 *  @throws IOException  If an input or output 
             *  exception occurred
			 */
			catch (IOException e) {
				System.out.println(e);
				return null;
			}
		}
		return countries;
	}
	
	/**
	 * this method allows to save the countries  added to the existing list of countries.
	 * @param myCountry
	 * @return
	 */
	public boolean saveCountries() {

		try (PrintWriter out = new PrintWriter(new BufferedWriter(
				new FileWriter(countriesFile)))) {
			for (String sCountry : countries) {
				out.println(sCountry);
			}
			
		} catch (IOException e) {
			System.out.println(e);
			return false;
		   }
		return true;
	}
	
	/**
	 * this method allows to add countries to the existing list of countries.
	 * @param myCountry
	 * @return
	 */
	public boolean addCountry(String myCountry) {
		countries.add(myCountry);
		return this.saveCountries();
	}

}
