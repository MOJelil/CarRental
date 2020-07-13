public class trailer extends car {
	/**
	 * What is required to use the trailer
	 */
	public void HowToDrive() {
		System.out.println("\t This Trailer requires a 4x4 truck to be driven");
	}

	/**
	 * Setting up the class propreties
	 */
	public void Initialize() {
		SetType("trailer");
	}

	/**
	 * Trailer
	 */
	public trailer() {
		super();
	}

	/**
	 * Initializing the constructor with every option
	 * 
	 * @param strName
	 */
	public trailer(String strName) {
		super(strName);
		Initialize(); // Always call Initialize from every constructor
	}

	/**
	 * Initializing the constructor with every option
	 * 
	 * @param strName
	 * @param intNumberOfWheels
	 */
	public trailer(String strName, int intNumberOfWheels) {
		super(strName, intNumberOfWheels);
		Initialize();
	}

	/**
	 * Initializing the constructor with every option
	 * 
	 * @param strName
	 * @param intNumberOfWheels
	 * @param intNumberOfMPG
	 */
	public trailer(String strName, int intNumberOfWheels, int intNumberOfMPG) {
		super(strName, intNumberOfWheels, intNumberOfMPG);
		Initialize();
	}

	public void Print() {
		System.out.println("\t Car Name                       :" + GetName());
		System.out.println("\t Number of trailer wheels       :" + GetNoOfWheels());
		System.out.println("\t Number Car of MPG              :" + GetNumberOfMPG());
		System.out.println("\t trailer Type                   :" + GetType());

		// Methods
		HowToDrive();
	}
}