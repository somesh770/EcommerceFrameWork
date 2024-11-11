package Utility_PACK;

import java.util.Date;
import java.util.Random;

public class Reusable_details 
{
	public static String reusableEmail() {
		return new Date().toString().replace(" ", "").replace(":", "") + "@gmail.com";
	}

	public static String reusableMobile() {
		return "9" + (100000000L + (long) (new Random().nextDouble() * 900000000L));
	}

}
