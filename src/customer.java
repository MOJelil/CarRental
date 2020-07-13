public class customer {
	public String strName = "^[a-zA-Z][ ]*$";
	public String strAddress = "";
	public String strEmail = "";
	public String strPhoneNumber = "";

	public customer(String strName, String strAddress, String strEmail, String strPhoneNumber) {
		this.strName = strName;
		this.strAddress = strAddress;
		this.strEmail = strEmail;
		this.strPhoneNumber = strPhoneNumber;
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println("The name is:" + strName);
		System.out.println(" the address is " + strAddress);
		System.out.println(" The email is: " + strEmail);
		System.out.println(" The phone number is " + strPhoneNumber);
	}

}
