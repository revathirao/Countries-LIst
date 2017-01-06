package ch18_pr1_countriesList;

import java.util.Scanner;

public class Validator {
	
	public static int getInt(Scanner sc, String prompt)
    {
        boolean isValid = false;
        int i = 0;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getIntwithinRange(Scanner sc, String prompt,
    int min, int max)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            i = getInt(sc, prompt);
            if (i <= min)
                System.out.println(
                    "Error! Number must be greater than " + min);
            else if (i >= max)
                System.out.println(
                    "Error! Number must be less than " + max);
            else
                isValid = true;
        }
        return i;
    }
    
    public static String getStringCountry(Scanner sc, String prompt) {

		boolean isvalid = false;
		String inputCountry = "";
		while (isvalid == false) {
			System.out.println(prompt);
			inputCountry = sc.nextLine();

			if (!inputCountry.equals(""))
				isvalid = true;
			else
				System.out.println("Error! You must enter a name.");

		} // while
		return inputCountry;
	}


}
