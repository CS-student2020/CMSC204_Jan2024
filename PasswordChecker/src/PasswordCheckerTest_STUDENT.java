
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {

	
	ArrayList<String> passwordsArray;
	
	@Before
	public void setUp() throws Exception {
		String[] p = {"Go0dP@ssw0rd", "Sh0rt", "n0upper@lpha", "N0LOWER@LPHA", "BothUpper&Lower0", "WeakP@ss2", "Inv@liiidSeq2", "NoDigitP@ssword" };
		passwordsArray = new ArrayList<String>();
		passwordsArray.addAll(Arrays.asList(p));
	}

	@After
	public void tearDown() throws Exception {
		passwordsArray = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		String pwd = passwordsArray.get(0);
		try {
			assertTrue(PasswordCheckerUtility.isValidLength(pwd));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		pwd = passwordsArray.get(1);
		try {
			assertTrue(PasswordCheckerUtility.isValidLength(pwd));
			assertTrue(false);
		} catch (LengthException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		String pwd = passwordsArray.get(4);
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(pwd));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		pwd = passwordsArray.get(2);
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(pwd));
			assertTrue(false);
		} catch (NoUpperAlphaException e) {
			assertTrue(true);
		}
		catch (Exception e)
		{
			assertTrue(false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		String pwd = passwordsArray.get(4);
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(pwd));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		pwd = passwordsArray.get(3);
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(pwd));
			assertTrue(false);
		} catch (NoLowerAlphaException e) {
			e.printStackTrace();
			assertTrue(true);
		}
		catch (Exception e)
		{
			assertTrue(false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		String pwd = passwordsArray.get(0);
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword(pwd));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		pwd = passwordsArray.get(5);
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword(pwd));
			assertTrue(false);
		} catch (WeakPasswordException e) {
			e.printStackTrace();
			assertTrue(true);
		}
		catch (Exception e)
		{
			assertTrue(false);
		}

	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		String pwd = passwordsArray.get(0);
		try {
			assertTrue(PasswordCheckerUtility.noSameCharInSequence(pwd));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		pwd = passwordsArray.get(6);
		try {
			assertTrue(PasswordCheckerUtility.noSameCharInSequence(pwd));
			assertTrue(false);
		} catch (InvalidSequenceException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		String pwd = passwordsArray.get(0);
		try {
			assertTrue(PasswordCheckerUtility.hasDigit(pwd));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		pwd = passwordsArray.get(7);
		try {
			assertTrue(PasswordCheckerUtility.hasDigit(pwd));
			assertTrue(false);
		} catch (NoDigitException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		String pwd = passwordsArray.get(0);
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(pwd));
		} catch (Exception e) {
			assertTrue(false);
		}
		
		pwd = passwordsArray.get(1);
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(pwd));
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results = PasswordCheckerUtility.getInvalidPasswords(passwordsArray);
		
		assertEquals(results.size(), 5);
		
		assertEquals(results.get(0), "Sh0rt The password must be at least 6 characters long");
		assertEquals(results.get(1), "n0upper@lpha The password must contain at least one uppercase alphabetic character");
		assertEquals(results.get(2), "N0LOWER@LPHA The password must contain at least one lowercase alphabetic character");
		assertEquals(results.get(3), "Inv@liiidSeq2 The password cannot contain more than two of the same character in sequence.");
		assertEquals(results.get(4), "NoDigitP@ssword The password must contain at least one digit");
		
	}
	
}
