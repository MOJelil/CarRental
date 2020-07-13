
public class car extends vehicle {
	/**
	 * Initialize the constructor without parameters
	 */
	public car() {
		Initialize("", 0, 0);
	}

	/**
	 * Initialize the constructor with parameters
	 */
	public car(String strName) {
		Initialize(strName, 0, 0);
	}

	/**
	 * Initialize the constructor with parameters
	 */
	public car(String strName, int intNumberOfWheels) {
		Initialize(strName, intNumberOfWheels, 0);
	}

	/**
	 * Initialize the constructor with parameters
	 */
	public car(String strName, int intNumberOfWheels, int intNumberOfMPG) {
		Initialize(strName, intNumberOfWheels, intNumberOfMPG);
	}

	// Properties/variables
	protected static String m_strType = "";

	/**
	 * SetType
	 */
	public static void SetType(String strNewType) {

		if (strNewType.equalsIgnoreCase("")) {
			strNewType = "Regular";
		} else {

			m_strType = strNewType;
		}
	}

	/**
	 * GetType
	 */

	public String GetType() {

		return m_strType;
	}

	/**
	 * How is this vehicle driven
	 */
	public void HowToDrive() {
		System.out.println("\t This Vehicle is driven by steering wheels");
	}

	/**
	 * MPG
	 */
	public void MPG() {
		GetNumberOfMPG();

		if (GetType().equalsIgnoreCase("Regular")) {

			System.out.println("\t The average gas consumption for this car is 28 MPG\n");
		} else {

			System.out.println("\t Tthe average gas consumption for this car is 32 MPG\n");
		}
	}

	/**
	 * Initialize the class properties
	 */
	public void Initialize(String strName, int intNumberOfWheels, int intNumberOfMPG) {

		SetName(strName);
		SetNoOfWheels(intNumberOfWheels);
		SetNumberOfMPG(intNumberOfMPG);
	}

	public void Print() {
		System.out.println("\t Vehicle Name                 :" + GetName());
		System.out.println("\t Number of vehicle wheels     :" + GetNoOfWheels());

		System.out.println(" \t Vehicle Type                  :" + GetType());

		HowToDrive();
		MPG();

	}

}
