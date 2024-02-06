import java.util.ArrayList;
//import java.util.regex;

public class PasswordCheckerUtility {

	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
	    if (!password.equals(passwordConfirm)) {
	        throw new UnmatchedException();
	    }
	}

    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
	    if (password.equals(passwordConfirm)) {
	        return true;
	    }
	    else {
	    	return false;
	    }
    }

    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords)
    {
    	ArrayList<String> invalidPasswords = new ArrayList<String>();

        for (String password : passwords) {
            try {
            	isValidPassword(password);
            } catch (Exception e) {
                invalidPasswords.add(password + " " + e.getMessage());
            }
        }

        return invalidPasswords;
    }

    public static boolean hasBetweenSixAndNineChars(String password) {
    	int len = password.length();
    	if (len >= 6 && len <= 9) {
    		return true;
    	} else {
    		return false;
    	}
    }

    public static boolean hasDigit(String password) throws NoDigitException {
        String regex = ".*\\d.*";
        if (password.matches(regex)) {
            return true;
        } else {
            throw new NoDigitException();
        }
    }

    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
    {
    	String regex = ".*[a-z].*";
        if (password.matches(regex)) {
            return true;
        } else {
            throw new NoLowerAlphaException();
        }
    }

    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        String regex = ".*[^A-Za-z0-9].*";
        if (password.matches(regex)) {
            return true;
        } else {
            throw new NoSpecialCharacterException();
        }
    }


    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
        String regex = ".*[A-Z].*";
        if (password.matches(regex)) {
            return true;
        } else {
            throw new NoUpperAlphaException();
        }
    }


    public static boolean isValidLength(String password) throws LengthException
    {
    	int len = password.length();
		if (len >= 6) {
			return true;
    	} else {
    		throw new LengthException();
    	}
    }

    public static boolean isValidPassword(String password) throws NoDigitException, 
    	NoUpperAlphaException, NoLowerAlphaException, NoSpecialCharacterException, 
    	InvalidSequenceException, LengthException
    {
    	isValidLength(password);
    	hasUpperAlpha(password);
    	hasLowerAlpha(password);
    	hasDigit(password);
    	hasSpecialChar(password);
    	noSameCharInSequence(password);
    	
    	
    	return true;
    }

    public static boolean isWeakPassword(String password) throws WeakPasswordException, NoDigitException, 
		NoUpperAlphaException, NoLowerAlphaException, NoSpecialCharacterException, 
		InvalidSequenceException, LengthException
    {
    	boolean isValid;
    	try {
    		isValid = isValidPassword(password);
    	}
    	catch (Exception e){
    		throw e;
    	}
    	
    	boolean isBetweenSixAndNine = hasBetweenSixAndNineChars(password);
    	if (isValid && !isBetweenSixAndNine) {
    		return false;
    	} else {
    		throw new WeakPasswordException();
    	}	
    }

    public static boolean noSameCharInSequence(String password) throws InvalidSequenceException {
        String regex = "(.)\\1{2,}";
        if (password.matches(".*" + regex + ".*")) {
            throw new InvalidSequenceException();
        } else {
            return true;
        }
    }
}