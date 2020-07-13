public class vehicle {
	// Properties/variables
	public String m_strName = "";
	public int m_intWheels = 0;
	private int m_intNumOfMPG = 0;

	/**
	 * Set Name
	 */
	public void SetName(String strNewName) {

		m_strName = strNewName;
	}

	/**
	 * Get Name
	 */
	public String GetName() {

		return m_strName;
	}

	/**
	 * setNumber Of Wheels
	 */
	public void SetNoOfWheels(int intNumberOfWheels) {

		m_intWheels = intNumberOfWheels;
	}

	/**
	 * Get Number Of Wheels
	 */
	public int GetNoOfWheels() {
		return m_intWheels;
	}

	/**
	 * Set Number Of MPG
	 */
	public void SetNumberOfMPG(int intNumberOfMPG) {
		m_intNumOfMPG = intNumberOfMPG;
	}

	/**
	 * GetNumberOfMPG Abstract: GetNumber Of MPG
	 */
	public int GetNumberOfMPG() {
		return m_intNumOfMPG;
	}

}