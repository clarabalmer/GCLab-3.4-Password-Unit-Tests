import java.util.ArrayList;
import java.util.Calendar;
import java.time.LocalTime;

public class PasswordStorage {

	public static ArrayList<String> passwords = new ArrayList<>();
	public static Calendar calendar = Calendar.getInstance();
	public static int day = calendar.get(Calendar.DAY_OF_WEEK);
	public static LocalTime time = LocalTime.now();
	
	public static void main(String[] args) {
	}
	
	
	public static boolean addPassword(String str) {
		//password must not exist already
		if (!passwords.contains(str)) {
			//admin and mod are okay passwords
			if (str.equals("admin") || str.equals("mod")) {
				passwords.add(str);
				return true;
			//Red Rum and Spooky are okay if it is between midnight and 1am
			} else if (witchingHour(time) && str.equals("Red Rum") || witchingHour(time) && str.equals("Spooky")) {
				passwords.add(str);
				return true;
				
			//otherwise password must be between 7 and 12 chars exclusive, have a num but not 6, have no spaces, have two capital vowels, and no non-prime numbers	
			} else if (str.length() > 7 && str.length() < 12 && hasNumNoSix(str) && hasNoSpace(str) && hasCapVowel(str)  && noNonPrimesPresent(str)) {
				//and if it's Tuesday, password needs "Taco"
				if (todayIsTuesday(day)) {
					if (str.contains("Taco")) {
						passwords.add(str);
						return true;
					}
				} else {
					passwords.add(str);
					return true;
				}
			}
			
		}
		return false;
	}
	public static boolean witchingHour(LocalTime time) {
		return (LocalTime.parse("00:00").isBefore(time) && LocalTime.parse("01:00").isAfter(time));
	}
	public static boolean todayIsTuesday(int day) {
		return day == 3; 
	}
	public static boolean hasNoSpace(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				return false;
			}
		}
		return true;
	}
	public static boolean hasCapVowel(String str) {
		char[] capVowels = {'A', 'E', 'I', 'O', 'U', 'Y'};
		int count = 0;
		for (char vowel : capVowels) {
			for (int i = 0; i < str.length(); i++) {
				if (vowel == str.charAt(i)) {
					count++;
				}
			}
		}
		return (count >= 2);
	}
	//returns false if non-prime numbers are present
	//returns true if only primes are present
	public static boolean noNonPrimesPresent(String str) {
		ArrayList<Integer> nums = allNums(str);
		for (int i = 0; i < nums.size(); i++) {
			if (!isPrime(nums.get(i))) {
				return false;
			}
		}
		return true;
	}
	//makes arrayList of all integer groups in a string
	public static ArrayList<Integer> allNums(String str) {
		ArrayList<Integer> result = new ArrayList<>();
		String numHolder = "";
		for (int i = 0; i < str.length(); i++) {
			//check if char at i is an int
			if (i < str.length() - 1 && isInteger(str.substring(i, i + 1)) || isInteger(str.substring(i))) {
				numHolder += str.charAt(i);
				//check if next char is not an int
				if (i + 1 < str.length() - 1 && !isInteger(str.substring(i + 1, i + 2)) || (i + 1 == str.length() - 1) && !isInteger(str.substring(i + 1)) || (i == str.length() - 1)) {
					result.add(Integer.parseInt(numHolder));
					numHolder = "";
				}
			}
		}
		return result;
	}
	//check if an int is prime
	public static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static boolean hasNumNoSix(String str) {
		boolean sixPresent = false;
		boolean numPresent = true;
		for (int i = 0; i < str.length(); i++) {
			if (isInteger(str.substring(i, i+1))) {
				numPresent = true;
				int sixMaybe = Integer.parseInt(str.substring(i, i+1));
				if (sixMaybe == 6) {
					sixPresent = true;
				}
			}
		}
		return (!sixPresent && numPresent);
	}
	
	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
