import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * TODO A simple class that needs to be localized
 * 
 * @author mohan. Created Mar 27, 2011.
 */
public class PrintBalance {

	/**
	 * Simple Java Method that is crying out to be localized.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		String language, country;
		double currency = 9876543.21;

		Locale currentLocale;
		ResourceBundle messages;

		currentLocale = new Locale(args[0], args[1]);
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);

		Scanner scanInput = new Scanner(System.in);
		Date today = new Date();

		// Greeting
		System.out.println(messages.getString("greeting"));

		// Get User's Name
		System.out.println(messages.getString("inquiryName"));
		String name = scanInput.nextLine();
		System.out.println(messages.getString("welcome") + name);

		// print today's date, balance and bid goodbye
		System.out.println(messages.getString("date")
				+ DateFormat.getDateTimeInstance(DateFormat.FULL,
						DateFormat.FULL, currentLocale).format(today));
		System.out.println(messages.getString("amount")
				+ NumberFormat.getCurrencyInstance(currentLocale).format(
						currency));
		System.out.println(messages.getString("farewell"));
	}
	
	public static ArrayList<String> returnLocalizedStrings (Locale currentLocale){
		ArrayList<String> ret = new ArrayList<String>();
		String defaultName = "Herpaderp";
		double currency = 9876543.21;
		
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);

		Date today = new Date();

		// Greeting
		ret.add(messages.getString("greeting"));

		// Get User's Name
		ret.add(messages.getString("inquiryName"));
		
		ret.add(messages.getString("welcome") + defaultName);

		// print today's date, balance and bid goodbye
		ret.add(messages.getString("date")
				+ DateFormat.getDateTimeInstance(DateFormat.FULL,
						DateFormat.FULL, currentLocale).format(today));
		ret.add(messages.getString("amount")
				+ NumberFormat.getCurrencyInstance(currentLocale).format(
						currency));
		ret.add(messages.getString("farewell"));
			
		
		return ret;
	}
}