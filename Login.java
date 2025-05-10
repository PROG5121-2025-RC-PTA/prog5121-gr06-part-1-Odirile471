public class Login{
	// Default constructor
    public Login() {
    }
	public boolean  checkUserName(String username){
		if(username.contains("_") && username.length() <= 5){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean  checkPasswordComplexity(String password){
		String capital = ".*[A-Z].*";//Checks capital letters
		String small = ".*[a-z].*";//Checks small letters
		String special = ".*[!@#$%^&*(),.?\":{}|<>].*";//Check special characters
		String digit = ".*\\d.*";//Check digit characters
		if(password.length() >= 8 && password.matches(capital) && password.matches(small) 
		&& password.matches(digit) &&password.matches(special)){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean  checkCellPhoneNumber(String phone){
		String saCode = "+27";
		String firstThreeChars = phone.substring(0, 3); // Gets characters from index 0 to 2 (inclusive)
		int fourthDigit = Character.getNumericValue(phone.charAt(3));//Gets and convert the fourth digit
		if(phone.length() <= 12 && firstThreeChars.equals(saCode) && fourthDigit >= 6 && fourthDigit <= 8){
			return true;
		}
		else{
			return false;
		}
	}
	public String registerUser(String username, String password, String phone){
		boolean  validatePhone = checkCellPhoneNumber(phone);
		boolean  validateUsername = checkUserName(username);
		boolean  validatePassword = checkPasswordComplexity(password);
		if(validatePhone == true && validateUsername == true && validatePassword == true){
			return "User is successfully registered";
		}else{
			return "User registration failed!!!!!";
		}
	}
	public boolean loginUser(String username, String password){
		boolean  validUsername = checkUserName(username);
		boolean  validPassword = checkPasswordComplexity(password);
		if(validUsername == true && validPassword == true){
			return true;
		}else{
			return false;
		}
	}
	public String returnLoginStatus(String username, String password){
		boolean  validUsername = checkUserName(username);
		boolean  validPassword = checkPasswordComplexity(password);
		if(validUsername == true && validPassword == true){
			return "A successful login";
		}else{
			return "A failed login";
		}
	
    }

}import java.util.Scanner;
public class LoginTester{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);//Create and instantiate Scanner object
		String username, password, phone; //Declare user inputs
		//Prompt and Receiving user inputs
		System.out.print("Enter Username: ");
		username = input.nextLine();
		System.out.print("Enter Password: ");
		password = input.nextLine();
		System.out.print("Enter Phone Number (starting with South African international code (+27)): ");
		phone = input.nextLine();
		
		Login login = new Login();//Create and instantiate Login object
		boolean  validatePhone = login.checkCellPhoneNumber(phone);
		boolean  validateUsername = login.checkUserName(username);
		boolean  validatePassword = login.checkPasswordComplexity(password);
		//Checks and validate username
		if(validateUsername == true){
			System.out.println("Username successfully captured.");
		}else{
			System.out.println("Username is not correctly formatted, please ensure that your username " + 
			"contains an underscore and is no more than five characters in length.");
		}
		//Checks and validate password
		if(validatePassword == true){
			System.out.println("Password  successfully captured.");
		}else{
			System.out.println("Password  is not correctly formatted; please ensure that the password " + 
			"contains at least eight characters, a capital and small letter, a number, and a special character.");
		}
		//Checks and validate phone number
		if(validatePhone == true){
			System.out.println("Cell phone number successfully added.");
		}else{
			System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
		}
	}
}