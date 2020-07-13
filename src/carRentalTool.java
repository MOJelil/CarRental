import java.util.Scanner;

public class carRentalTool {
	/**
	 * This is Java's main method entry point of this program The program uses
	 * constant and variables Program name Pay Stub 2 main method to play with swing
	 * 
	 * @param args this default parm
	 * 
	 */
	public static void main(String[] args) {
		// Variable
		String strName = "";
		String strCustPhnNumber = "";
		String strCustEmail = "";
		int intDaysRented[];
		int intVehiculeRented = 0;
		int intIndex = 0;
		String strChoice = "";
		int intChoice1 = 0;
		double dblTotalRental[];
		String strEndorsment;
		double dblTotalRentalAmount = 0;
		int intCounter = 1;

		do {
			System.out.printf("----------------------------------------------------------------------");
			System.out.printf("Vehicle Rental Tool\n");
			System.out.printf("Rent Now \n");
			System.out.printf("(Enter QUIT for name to quit)\n");
			System.out.printf("----------------------------------------------------------------------\n");

			// Get the customer name
			strName = GetName();
			if (strName.contentEquals("QUIT")) {
				// End program
				System.out.println("Vehicle Rental Tool\n");
				break;
			}
			// Customer phone number
			strCustPhnNumber = GetCustPhneNumber();

			// Customer Email
			strCustEmail = GetCustEmail();

			// Number of Vehicles the customer wants to rent
			intVehiculeRented = GetTotVehicleRened();
			// Create an array
			String strChosenVehicle[];
			strChosenVehicle = new String[intVehiculeRented];
			// Total number of days the vehicle being rented
			intDaysRented = GetTotRentalDays(strChosenVehicle, intVehiculeRented);

			// Vehicle chosen by customer
			strChosenVehicle = GetVechileType(strChosenVehicle, intVehiculeRented, strChoice, intChoice1);
			// Validate MotoCycle
			strEndorsment = ValidatePermit(strChosenVehicle);
			if (strEndorsment.equalsIgnoreCase("No")) {
				System.out.println(
						"Due to lack of endorsment on your driver license we will decline renting you a motorcycle.");
				System.out.println("The program will close now\n");
				break;
			}

			// Does the trailer have another Vehicle
			intChoice1 = Validtrailer(strChosenVehicle, intChoice1);

			// Save the total rental amount
			dblTotalRentalAmount = Print(strChosenVehicle, strName, intChoice1, intDaysRented, intVehiculeRented);
			intCounter = 1;
		} while (intCounter < 0 && intCounter > 1);
		System.out.println("\n The total of your rental is  : $" + dblTotalRentalAmount);
		System.out.println("\t \t Thank you for stopping by, Come again");

	}

	/**
	 * Get the name of the customer
	 * 
	 * @return customer name
	 */
	public static String GetName() {
		Scanner Userinput = new Scanner(System.in);
		String strCustomerName = "";
		// Get Employee Information
		System.out.println("Get Customer Information \n");
		System.out.println("Please enter Customer Name");
		strCustomerName = Userinput.nextLine();
		strCustomerName = strCustomerName.toUpperCase();
		return strCustomerName;
	}

	/**
	 * Getting the customer phone number
	 * 
	 * @return customer phone number
	 */
	public static String GetCustPhneNumber() {
		Scanner Userinput = new Scanner(System.in);
		String strPhoneNo = "";
		String strPhonePattern = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
		String strValidate = ""; // by default
		// Do while # is incorrect
		do {
			System.out.println("Please enter Your Phone Number ");
			strPhoneNo = Userinput.nextLine();
			// Validate
			if (strPhoneNo.matches(strPhonePattern)) {
				strValidate = "True";// Validate
			} else {
				System.out.printf("Please enter a phone Number following this pattern\n"
						+ "(###)-###-#### or ###-###-#### or ########## \n");
				strValidate = "False";
			}
		} while (strValidate.equalsIgnoreCase("False"));
		return strPhoneNo;
	}

	/**
	 * Collect customer email address
	 * 
	 * @return customer email address
	 */
	public static String GetCustEmail() {
		Scanner Userinput = new Scanner(System.in);
		String strCustEmailAddress = "";
		String strValidateEmail = "[a-zA-Z][a-zA-Z0-9]*@[a-zA-Z][a-zA-Z0-9]*\\.[a-zA-Z]{2,6}";
		String strValidate = "False"; // by default
		// Phone number
		do {
			System.out.println("Please enter Your Email Address ");
			strCustEmailAddress = Userinput.nextLine();
			// Validate email
			if (strCustEmailAddress.matches(strValidateEmail)) {
				strValidate = "True";// Validate
			} else {
				System.out.printf("You entered an invalid email address. Please try again\n");
				strValidate = "False";// Validate
			}
		} while (strValidate.equalsIgnoreCase("False"));
		return strCustEmailAddress;
	}

	/**
	 * Collect the total of days the vehicle will be rented
	 * 
	 * @param strChosenVehicle  chosent vehicule
	 * @param intVehiculeRented number of vehicule rented
	 * @return integer
	 */
	public static int[] GetTotRentalDays(String[] strChosenVehicle, int intVehiculeRented) {
		Scanner Userinput = new Scanner(System.in);
		int intNoOfRentalDays[];
		intNoOfRentalDays = new int[intVehiculeRented];

		int intIndex = 0;
		int intCounter = 1;

		for (intIndex = 0; intIndex < strChosenVehicle.length; intIndex += 1) {
			do {
				// Number Of Rental Days
				System.out.println("Please Enter Number of Rental Days for Vehicle " + intCounter);
				intNoOfRentalDays[intIndex] = Userinput.nextInt();
				intCounter += 1;
			} while (intNoOfRentalDays[intIndex] <= 0);
		}
		return intNoOfRentalDays;
	}

	/**
	 * Collect the total of vehicle that will be rented
	 * 
	 * @return the total of vehicle that will be rented
	 */
	public static int GetTotVehicleRened() {
		Scanner Userinput = new Scanner(System.in);
		int intNoOfVehiclesRent = 0;
		do {
			System.out.println("Please Enter Number of Vehicles to rent ");
			intNoOfVehiclesRent = Userinput.nextInt();
		} while (intNoOfVehiclesRent <= 0);
		return intNoOfVehiclesRent;
	}

	/**
	 * Collect vehicle type
	 * 
	 * @param strChosenVehicle  string for vehicule type
	 * @param intVehiculeRented vehicule rented
	 * @param strChoice         strinf for a choice
	 * @param intChoice1        integer
	 * @return vehicle type
	 */
	public static String[] GetVechileType(String strChosenVehicle[], int intVehiculeRented, String strChoice,
			int intChoice1) {
		Scanner Userinput = new Scanner(System.in);
		int intIndex = 0;
		int intCounter = 1;

		for (intIndex = 0; intIndex < strChosenVehicle.length; intIndex += 1) {
			System.out.println("What type of vehicle you want to rent today " + intCounter);
			System.out.println("Car, MotoCycle or Trailer only");
			System.out.println("Note: PLESE BE SURE TO TYPE THE VEHICULE NAME CORRECTLY TO GET THE CORRECT OUTPUT");
			strChosenVehicle[intIndex] = Userinput.nextLine();

			intCounter += 1;
		}

		return strChosenVehicle;
	}

	/**
	 * Validate if the customer has a legal endorsment to drive a motorcycle
	 * 
	 * @param strChosenVehicle chosen vehicule
	 * @return string of yes or no
	 */
	public static String ValidatePermit(String strChosenVehicle[]) {
		Scanner Userinput = new Scanner(System.in);
		int intIndex = 0;
		String strChoice = "";
		for (intIndex = 0; intIndex < strChosenVehicle.length; intIndex += 1) {
			if (strChosenVehicle[intIndex].equalsIgnoreCase("MotoCycle")) {
				System.out.println("Do you have a MotoCycle permit, Yes or No?");
				strChoice = Userinput.nextLine();
			}
		}
		return strChoice;
	}

	/**
	 * Confirm it is a trailer and the cutomer has the correct car to pull it
	 * 
	 * @param strChosenVehicle vehicule chosen
	 * @param intChoice1       choice
	 * @return and integer for a choice
	 */
	public static int Validtrailer(String strChosenVehicle[], int intChoice1) {
		Scanner Userinput = new Scanner(System.in);
		int intIndex = 0;
		for (intIndex = 0; intIndex < strChosenVehicle.length; intIndex += 1) {
			if (strChosenVehicle[intIndex].equalsIgnoreCase("trailer")) {
				do {
					System.out.println(
							"Do you have another Vehicle to drive the trailer" + "\n Enter 1 for Yes, 2 for No");
					intChoice1 = Userinput.nextInt();
				} while (intChoice1 < 1 || intChoice1 > 2);
			}
		}
		return intChoice1;
	}

	/**
	 * Display the vehicle details
	 * 
	 * @param strChosenVehicle  vehicule chosed
	 * @param intVehiculeRented vehicule rented
	 * @param intChoice1        choices
	 * @param intIndex          loop index
	 * @param intCounter        loop counter
	 */
	public static void VehicleInfo(String[] strChosenVehicle, int intVehiculeRented, int intChoice1, int intIndex,
			int intCounter) {
		String strVehicleType[];
		strVehicleType = new String[intVehiculeRented];

		for (intIndex = intIndex; intIndex < strChosenVehicle.length; intIndex += 1) {
			System.out.println(" Vechicle Type " + (intCounter) + " Information");
			if (strChosenVehicle[intIndex].equalsIgnoreCase("car")) {
				// Make instances for car
				car clsSedan = new car();
				car clsSedan1 = new car("Volkswagen or similar", 4, 0);
				car.SetType("Regular");
				clsSedan1.Print();
			} else if (strChosenVehicle[intIndex].equalsIgnoreCase("MotoCycle")) {
				MotoCycle clsHarley = new MotoCycle();
				MotoCycle clsHarley1 = new MotoCycle("MotoCycle", 2, 30);
				clsHarley1.Print();
			} else if (strChosenVehicle[intIndex].equalsIgnoreCase("trailer")) {
				trailer clstrailer = new trailer();
				trailer clstrailer1 = new trailer("Tructor", 6, 0);
				clstrailer1.Print();
				if (intChoice1 == 2) {
					System.out
							.println(" \n \t A car with a trailer hoock is required to be able to rent this trailer,\n"
									+ "\t we are adding automatically a car to your rental");
					// Make instances for car
					car clsFourbyFour = new car();
					car clsFourbyFour1 = new car("Rava4 limited", 4, 0);
					car.SetType("Sport");
					clsFourbyFour1.Print();
				} else if (intChoice1 == 1) {
					// do nothing
				}
			} else {
				System.out.println("Sorry we do not have this kind of car, Try again");
			}
			intCounter += 1;
			intIndex += 1;
			break;
		}
	}

	/**
	 * The total of the rental bill
	 * 
	 * @param intDaysRented     number of days rented
	 * @param intVehiculeRented number fo vehicule rented
	 * @param strChosenVehicle  vehicule chosen
	 * @param intChoice1        type fo choises
	 * @param intIndex          index for the loop
	 * @return double amount
	 */
	public static double[] TotalRental(int intDaysRented[], int intVehiculeRented, String[] strChosenVehicle,
			int intChoice1, int intIndex) {
		int intCounter = 1;
		double dblcarCostPerDay = 50f;
		double dblMotobikeCostPerDay = 70f;
		double dbltrailerCostPerDay = 100f;
		double dblTotalRental[];
		dblTotalRental = new double[intVehiculeRented];

		for (intIndex = intIndex; intIndex < strChosenVehicle.length; intIndex += 1) {

			if (strChosenVehicle[intIndex].equalsIgnoreCase("Car")) {
				dblTotalRental[intIndex] = dblcarCostPerDay * intDaysRented[intIndex];
			} else if (strChosenVehicle[intIndex].equalsIgnoreCase("MotoCycle")) {
				dblTotalRental[intIndex] = dblMotobikeCostPerDay * intDaysRented[intIndex];
			} else if (strChosenVehicle[intIndex].equalsIgnoreCase("Trailer")) {
				if (intChoice1 == 2) {
					// Vehicule cost to the trailer
					dblTotalRental[intIndex] = (dbltrailerCostPerDay * intDaysRented[intIndex])
							+ (dblcarCostPerDay * intDaysRented[intIndex]);

				} else {
					dblTotalRental[intIndex] = dbltrailerCostPerDay * intDaysRented[intIndex];
				}
			}
			intCounter += 1;
			break;
		}
		return dblTotalRental;
	}

	/**
	 * Print the bill details
	 * 
	 * @param strChosenVehicle  string type of vehicule
	 * @param strName           customer name
	 * @param intChoice1        choice
	 * @param intDaysRented     number of days rented
	 * @param intVehiculeRented number of vehicule rented
	 * @return double total amount
	 */
	public static double Print(String[] strChosenVehicle, String strName, int intChoice1, int intDaysRented[],
			int intVehiculeRented) {
		int intIndex = 0;
		int intCounter = 1;
		double dblTotalRental[];
		double dblTotalRentalAmount = 0;
		for (intIndex = 0; intIndex < strChosenVehicle.length; intIndex += 1) {
			System.out.println("---------------------------------------------------------------------");
			System.out.println("Rental Information for Vehicle " + intCounter);
			System.out.println("\t Customer Name               : " + strName);
			System.out.println("\t Type of Vehicle             : " + strChosenVehicle[intIndex]);
			// Total Rental
			dblTotalRental = TotalRental(intDaysRented, intVehiculeRented, strChosenVehicle, intChoice1, intIndex);
			System.out.println("\t Total Rental for vehicle " + intCounter + "  : $" + dblTotalRental[intIndex]);
			VehicleInfo(strChosenVehicle, intCounter, intChoice1, intIndex, intCounter);
			intCounter += 1;
			dblTotalRentalAmount += dblTotalRental[intIndex]; // Save Total rental
		}
		return dblTotalRentalAmount;
	}

}