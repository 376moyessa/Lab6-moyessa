import static org.junit.Assert.fail;

import java.text.Collator;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author tugayac. Created Mar 29, 2012.
 */
public class TestPrintBalance {

	private String[] locEN, locDE, locFR;
	private Locale localeEN, localeDE, localeFR;

	private Collator myCollator = Collator.getInstance();

	private ArrayList<String> testMessages;

	private String defaultName = "Herpaderp";
	private double currency = 9876543.21;

	@Before
	public void setUp() {

		this.locEN = new String[2];
		this.locEN[0] = "en";
		this.locEN[1] = "US";

		this.locDE = new String[2];
		this.locDE[0] = "de";
		this.locDE[1] = "DE";

		this.locFR = new String[2];
		this.locFR[0] = "fr";
		this.locFR[1] = "FR";

		this.localeEN = new Locale(this.locEN[0], this.locEN[1]);
		this.localeDE = new Locale(this.locDE[0], this.locDE[1]);
		this.localeFR = new Locale(this.locFR[0], this.locFR[1]);
	}

	@Test
	public void testLocalityEN() {
		this.testMessages = new ArrayList<String>();

		this.testMessages.add("Hello World");
		this.testMessages.add("Please enter your name");
		this.testMessages.add("I am pleased to meet you " + this.defaultName);
		this.testMessages.add("As of : "
				+ DateFormat.getDateTimeInstance(DateFormat.FULL,
						DateFormat.FULL, this.localeEN).format(new Date()));
		this.testMessages.add("You owe the school "
				+ NumberFormat.getCurrencyInstance(this.localeEN).format(
						this.currency));
		this.testMessages.add("Good Bye");

		for (int i = 0; i < this.testMessages.size(); i++) {
			if (this.myCollator.compare(
					PrintBalance.returnLocalizedStrings(this.localeEN).get(i),
					this.testMessages.get(i)) != 0) {
				System.out.println(i);
				fail();
			}
		}
	}

	@Test
	public void testLocalityDE() {
		this.testMessages = new ArrayList<String>();

		this.testMessages.add("Hallo Welt");
		this.testMessages.add("Bitte geben Sie Ihren Namen");
		this.testMessages.add("Ich freue mich, Sie kennenzulernen, "
				+ this.defaultName);
		this.testMessages.add("Stand : "
				+ DateFormat.getDateTimeInstance(DateFormat.FULL,
						DateFormat.FULL, this.localeDE).format(new Date()));
		this.testMessages.add("Sie schulden die Schule "
				+ NumberFormat.getCurrencyInstance(this.localeDE).format(
						this.currency));
		this.testMessages.add("Auf Wiedersehen");

		for (int i = 0; i < this.testMessages.size(); i++) {
			if (this.myCollator.compare(
					PrintBalance.returnLocalizedStrings(this.localeDE).get(i),
					this.testMessages.get(i)) != 0) {
				System.out.println(i);
				fail();
			}
		}
	}

	@Test
	public void testLocalityFR() {
		this.testMessages = new ArrayList<String>();

		this.testMessages.add("Bonjour");
		this.testMessages.add("S'il vous plaît entrer votre nom");
		this.testMessages.add("Je suis heureux de vous rencontrer "
				+ this.defaultName);
		this.testMessages.add("Comme d' : "
				+ DateFormat.getDateTimeInstance(DateFormat.FULL,
						DateFormat.FULL, this.localeFR).format(new Date()));
		this.testMessages.add("Vous devez l'école "
				+ NumberFormat.getCurrencyInstance(this.localeFR).format(
						this.currency));
		this.testMessages.add("Au Revoir");

		for (int i = 0; i < this.testMessages.size(); i++) {
			if (this.myCollator.compare(
					PrintBalance.returnLocalizedStrings(this.localeFR).get(i),
					this.testMessages.get(i)) != 0) {
				System.out.println(i);
				fail();
			}
		}
	}

}
