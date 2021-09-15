import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.*;
public class PasswordCheckerUtility {
	
	//checks if the passwords are the same
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		//.equals for comparing strings
		if(password.equals(passwordConfirm)) {
		}else {
			throw new UnmatchedException("Passwords do not match");
		}
	}
	//checks if the passwords are the same and returns them
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		//.equals for comparing strings
		if(password.equals(passwordConfirm)) {
			return true;
		}else {
			return false;
		}
	}
	//new method for comparing array list 
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		//creates new arraylist for comparing
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		invalidPasswords = passwords;
		//try catch when opening file
		try {
			//opens file 
		File passwordsText = new File("passwords.txt");
		//scanner to read through the file 
	      Scanner myReader = new Scanner(passwordsText);
	      //loops through the 
	      while (myReader.hasNextLine()) {
	    	  //reads next line 
	        String data = myReader.nextLine();
	        //adds to the new array list 
	        invalidPasswords.add(data);
	      }
	      myReader.close();
	     //catch error if error occurs 
		}catch(FileNotFoundException e) {
			System.out.println("Error");
		}
		/*
		for(int i = 0; i < invalidPasswords.size()-1; i++) {
			try {
			isValidPassword(invalidPasswords.get(i));
			}catch(UnmatchedException e) {
				System.out.print("test");
			}
		}
		*/
		return invalidPasswords;
	}
	//checks character length between 6-9 chars
	public static boolean hasBetweenSixAndNineChars(String passwords) {
		//if they are in the range
		if(passwords.length() >= 5 && passwords.length() <= 8) {
			return true;
		}else {
			return false;
		}
	}
	//checking if the string has a digit in it using regex
	public static boolean hasDigit(String password) throws NoDigitException{
		//regex expression to see if digit 0-9 is present 
		if(password.matches(".*[0-9].*")) {
			return true;
		}else {
			//throws new digit exception
			throw new NoDigitException("The password must contain at least one digit");
		}
	}
	//check if a lower case character exist 
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		//checks if lower alpha
		if(password.matches(".*[a-z].*")) {
			   return true;
		}else {
			//throws new lower alpha exception
			  throw new NoLowerAlphaException("The password must contain at least one lower case alphabetic character");
		}
	}
	//checks if char in sequence 
	public static boolean hasSameCharInSequence(String password)throws InvalidSequenceException{
		//counts the next chars in the sequence
		int count = 0;
		for(int i = 0; i < password.length()-2; i++) {
			//checks the substring of the chars 
			if(password.substring(i) == password.substring(i+1) && password.substring(i) == password.substring(i+2)) {
				count++;
			}
		}
		//checks if the counter gets above 2 meaning repeating chars
		if(count > 0) {
			throw new InvalidSequenceException("Error more than 2 chars in a row");
		}else {
			return true;
		}
	}
	//checks if special char using regex
	public static boolean hasSpecialChar(String password)throws NoSpecialCharacterException{
		//regex expression for chars that are out of digits and characters
		if(password.matches(".*[!@#$%^&*(),.?\":{}|<>]*.")) {
			return true;
		}else {
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		}
	}
	//check for upper case variable
	public static boolean hasUpperAlpha(String password)throws NoUpperAlphaException{
		if(password.matches(".*[A-Z].*")) {
			return true;
		}else {
			throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
		}
	}
	//checks if length is valid greater than 5 or 6 characters
	public static boolean isValidLength(String password)throws LengthException{
		if(password.length() > 5) {
			return true;
		}else {
			throw new LengthException("The password must be at least 6 characters long");
		}
	}
	//check if password valid calling all existing methods already created.
	public static boolean isValidPassword(String password)throws LengthException,NoUpperAlphaException,NoLowerAlphaException,NoDigitException,NoSpecialCharacterException,InvalidSequenceException{
		boolean flag = true;
		if(isValidLength(password) == true){
		}else {
			flag = false;
			throw new LengthException("The password must contain at least one lower case alphabetic character");
		}
		if(hasUpperAlpha(password) == true){
		}else {
			flag = false;
			throw new NoUpperAlphaException("Has no upper case");
		}
		if(hasLowerAlpha(password) == true){
		}else {
			flag = false;
			throw new NoLowerAlphaException("has no lower case");
		}
		if(hasDigit(password) == true){
		}else {
			flag = false;
			throw new NoDigitException("No digits");
		}
		if(hasSpecialChar(password) == true){
		}else {
			flag = false;
			throw new NoSpecialCharacterException("No special chars");
		}
		if(hasSameCharInSequence(password) == true){
		}else {
			flag = false;
			throw new InvalidSequenceException("Invalid sequence");
		}
		return flag;
	}
	//check if the password is between 6-9 characters if so its a weak password.
	public static boolean isWeakPassword(String password)throws WeakPasswordException{
		if(password.length()>=5 && password.length() <=8) {
			throw new WeakPasswordException("Weak Password");
		}else {
			return true;
		}
	}
}
