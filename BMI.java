//BMI calculator
//Written by Michael Robison
//CS 3250
//Program 01
/*-----------------------------------------*/
/*/Program will ask user to input a value represending their wieght in pounds, then ask for height in feet, the print out the calculated body mass index and the category they fall under, and will loop forever until "quit" is input*/
import java.util.Scanner;

public class BMI
{
	//final declarations
	static final int TWELVE = 12; 
	static final int BMI_CONST = 703;
	static final double[] RANGE = {18.49, 24.99, 29.99, 34.99, 39.99};
	static final String[] CATAGORIES = {"underweight", "normal", "overweight", "obesity (Class 1)", "obesity (Class 2)", "morbid obesity"};

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in); //scanner object to read user input
		double height = 0; 
		double weight = 0;
		String input = ""; //only used if user fails to input a doublewhen prompted
		
quit: //if user inputs "quit" at anytime, break here
		while (true)
		{
/*--------------------------------------------------------------------------*/
//get weight block
			
			System.out.print("How much do you weight (in pounds)?  ");
			while (!sc.hasNextDouble())//if user does not input a double
			{
				input = sc.next(); 
		
				if(input.equals("quit")) //break if "quit"
				{
					break quit;
				}
					
				System.out.print("\nError: That input in invalid\n\nHow much do you weight (in pounds)? "); //otherwise an invalid input was input
			}
			
			weight = sc.nextDouble(); //read in a number as a double
/*--------------------------------------------------------------------------*/
//get height block
			System.out.print("\nHow tall are you? (in feet)? ");
			while(!sc.hasNextDouble())//repeat input validation as above, but for height
			{
				input = sc.next();

				if(input.equals("quit"))
				{
					break quit;
				}

				else
				{
					System.out.print("\nError: That input in invalid\n\nHow tall are you? (in feet)? ");
				}

			}
		
			height = sc.nextDouble(); //store number input as double

			double bmi = calc(weight, height); //call calc function and store result
			bmi = Math.round(100 * bmi) / 100d; //round the number to be output to two decimal places
			System.out.println("\nYour BMI is:" + bmi + ", " + CATAGORIES[catagorize(bmi)] + "\n");//print the final output, including the calculated BMI and the catagory
		}
			

	}	

	public static double feetToInches(double _feet)
	{
		return _feet * TWELVE;
	}

	public static double calc(double _weight, double _height)
	{
		double inchHeight = feetToInches(_height);
		return (_weight * BMI_CONST) / (inchHeight * inchHeight);
	}

	public static int catagorize(double _bmi)
	{
		int i = 0;
		while(RANGE[i] <= _bmi && i < (RANGE.length - 1))
		{
			i++;
		}
		return i;
	}
}
