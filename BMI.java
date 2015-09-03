import java.util.Scanner;

public class BMI
{
	static final int TWELVE = 12;
	static final int BMI_CONST = 703;
	static final double[] RANGE = {18.5, 24.99, 29.99, 34.99, 39.99};
	static final String[] CATAGORIES = {"underweight", "normal", "overweight", "obesity (Class 1)", "obesity (Class 2)", "morbid obesity"};

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		double height = 0;
		double weight = 0;
		String input = "";
		
quit:
		while (true)
		{
			
			System.out.print("How much do you weight (in pounds)?  ");

			while (!sc.hasNextDouble())
			{
				input = sc.next();
		
				if(input.equals("quit"))
				{
					break quit;
				}
					
				System.out.print("\nError: That input in invalid\n\nHow much do you weight (in pounds)? ");
			}
			
			weight = sc.nextDouble();

			System.out.print("\nHow tall are you? (in feet)? ");

			while(!sc.hasNextDouble())
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
		
			height = sc.nextDouble();

			double bmi = calc(weight, height);
			bmi = Math.round(100 * bmi) / 100d;
			System.out.println("\nYour BMI is:" + bmi + ", " + CATAGORIES[catagorize(bmi)] + "\n");
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
