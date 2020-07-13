
public class MotoCycle extends vehicle {

	public void HowToDrive() {
		System.out.println("\t The MotoCycle is driven by Handle bars");
	}

	/**
	 * Set all the class properties
	 */
	public void Initialize(String strName, int intNumberOfWheels, int intNumberOfMPG) {
		SetName(strName);
		SetNoOfWheels(intNumberOfWheels);
		SetNumberOfMPG(intNumberOfMPG);
	}

	/**
	 * Initializing the constructor with every option
	 */
	public MotoCycle() {
		Initialize("", 0, 0);
	}

	/**
	 * Initializing the constructor with every option
	 */
	public MotoCycle(String strName) {
		Initialize(strName, 0, 0);
	}

	/**
	 * Initializing the constructor with every option
	 */
	public MotoCycle(String strName, int intNumberOfWheels) {
		Initialize(strName, intNumberOfWheels, 0);
	}

	/**
	 * Initializing the constructor with every option
	 */
	public MotoCycle(String strName, int intNumberOfWheels, int intNumberOfMPG) {
		Initialize(strName, intNumberOfWheels, intNumberOfMPG);
	}

	public void Print() {
		System.out.println("\t MotoCycle Name                 :" + GetName());
		System.out.println("\t Number of MotoCycle wheels     :" + GetNoOfWheels());
		System.out.println("\t Number of MPG                  :" + GetNumberOfMPG());

		// Methods
		HowToDrive();

	}
}
