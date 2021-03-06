import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class addPasswordTests {

	//Write 2 tests for each of the following rules. 
	//Assert that the ArrayList is changed (or not changed) 
	//and assert that the method returns true or false.
	@Test
	void arrayListIsChanged() {
		ArrayList<String> passwordsCopy = new ArrayList<String>(PasswordStorage.passwords);
		PasswordStorage.addPassword("pAsswOrd89");
		Assert.assertTrue(!passwordsCopy.equals(PasswordStorage.passwords));
	}
	@Test
	void arrayListNotChanged() {
		ArrayList<String> passwordsCopy2 = new ArrayList<String>(PasswordStorage.passwords);
		PasswordStorage.addPassword("bAnAna2ff");
		Assert.assertTrue(!passwordsCopy2.equals(PasswordStorage.passwords));
	}
	@Test
	void passwordIsAdded() {
		PasswordStorage.addPassword("pEAch7abc");
		Assert.assertTrue(PasswordStorage.passwords.contains("pEAch7abc"));
	}
	@Test
	void trueCheck() {
		Assert.assertTrue(PasswordStorage.addPassword("plUmU3abc"));
	}
	@Test
	void falseCheck() {
		Assert.assertTrue(!PasswordStorage.addPassword("butts"));
	}
	
	@Test
	void repeatPassword() {
		PasswordStorage.addPassword("123EE789");
		Assert.assertTrue(!PasswordStorage.addPassword("123EE789"));
	}
	@Test
	void repeatPassword2() {
		PasswordStorage.addPassword("r3pEAtMe");
		Assert.assertTrue(!PasswordStorage.addPassword("r3pEAtMe"));
	}

	@Test
	void shortPassword() {
		Assert.assertTrue(!PasswordStorage.addPassword("bUUb"));
	}
	@Test
	void longPassword() {
		Assert.assertTrue(!PasswordStorage.addPassword("enormOUspassword"));
	}
	
	@Test
	void hasSix() {
		Assert.assertTrue(!PasswordStorage.addPassword("herEIsa6"));
	}
	@Test
	void hasSix2() {
		Assert.assertTrue(!PasswordStorage.addPassword("6inThisOne"));
	}
	
	@Test
	void hasSpace() {
		Assert.assertTrue(!PasswordStorage.addPassword("space man"));
	}
	@Test
	void hasTwoSpaces() {
		Assert.assertTrue(!PasswordStorage.addPassword(" here there"));
	}
	
	@Test
	void noCapVowels() {
		Assert.assertTrue(!PasswordStorage.addPassword("Passw0rd"));
	}
	@Test
	void oneCapVowel() {
		Assert.assertTrue(!PasswordStorage.addPassword("PAssw0rd"));
	}
	
	@Test
	void adminAdd() {
		Assert.assertTrue(PasswordStorage.addPassword("admin"));
	}
	@Test
	void adminNoRepeat() {
		Assert.assertTrue(!PasswordStorage.addPassword("admin"));
	}
	@Test
	void modAdd() {
		Assert.assertTrue(PasswordStorage.addPassword("mod"));
	}
	@Test
	void modNoRepeat() {
		Assert.assertTrue(!PasswordStorage.addPassword("mod"));
	}
	@Test
	void isPrimeTest() {
		Assert.assertTrue(PasswordStorage.isPrime(89));
	}
	@Test
	void isPrimeTest2() {
		Assert.assertTrue(PasswordStorage.isPrime(7));
	}
	@Test
	void isPrimeTest3() {
		Assert.assertTrue(!PasswordStorage.isPrime(10000));
	}
	@Test
	void allNumsTest() {
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(830, 90, 6));
		ArrayList<Integer> actual = PasswordStorage.allNums(".830..90..6..");
		Assert.assertTrue(expected.equals(actual));
	}
	@Test
	void nonPrimesPresent() {
		Assert.assertTrue(!PasswordStorage.noNonPrimesPresent("AE89fdf9"));
	}
	@Test
	void nonPrimesPresent2() {
		Assert.assertTrue(!PasswordStorage.noNonPrimesPresent("AEfejk777"));
	}
	@Test
	void onlyPrimesPresent() {
		Assert.assertTrue(PasswordStorage.noNonPrimesPresent("AE89d59"));
	}
	@Test
	void onlyPrimesPresent2() {
		Assert.assertTrue(PasswordStorage.noNonPrimesPresent("AA3.5.7.13"));
	}
	@Test
	void primesWithSixFalse() {
		Assert.assertTrue(!PasswordStorage.addPassword("AA....61."));
	}
	@Test
	void isWednesdayTuesday() {
		int wednesday = 4;
		Assert.assertTrue(!PasswordStorage.todayIsTuesday(wednesday));
	}
	@Test
	void isTuesdayTuesday() {
		int tuesday = 3;
		Assert.assertTrue(PasswordStorage.todayIsTuesday(tuesday));
	}
	@Test
	void sixThirtyWitchingHour() {
		LocalTime sixThirty = LocalTime.of(6, 30);
		Assert.assertTrue(!PasswordStorage.witchingHour(sixThirty));
	}
	@Test
	void twelveFifteenWitchingHour() {
		LocalTime twelveFifteen = LocalTime.of(00, 15);
		Assert.assertTrue(PasswordStorage.witchingHour(twelveFifteen));
	}
}
