import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * This class will generate Random data to test the Predictor.
 * @author Marco Jurado M.
 * @version 1.0
 * */
public final class DataGenerator {
	
	/*Constants*/
	private static final int ASCIIFORA = 65;
	private static final int NUMLETTERS = 26;
	
	/*28 is chosen instead of 30 or 31 as this would require a per month 
	 * case day generator and will not give any impact in the tester*/
	private static final int DAYSINMONTH = 28;
	
	private static final int MONTHS = 12;
	private static final int INITIALYEAR = 1900;
	private static final int NUMYEARS = 200;
	private static final int NUMHOURS = 24;
	private static final int NUMMINUTES = 60;
	private static final int NUMLETTERSINPLATE = 3;

	
	/*Constructor*/
	private DataGenerator() {
	}
	
	/*Methods*/
	
	/**
	 * Generates random data for the Predictor.
	 * @return The data in a String.
	 * */
	public static String generateData() {
		String data = generatePlate().concat(" ").concat(generateDateTime());
		return data;
	}
	
	/**
	 * Generates random plate numbers.
	 * @return The String plate number.
	 * */
	public static String generatePlate() {
		
		String plate = "";
		Random rand = new Random();
		Integer i=0;
		Integer letterNum=0;
		char letterChar = '\0';
		
		/*Sets the 3 initial random letters of a plate*/
		while(i<NUMLETTERSINPLATE) {
			letterNum = rand.nextInt(NUMLETTERS)+ASCIIFORA;
			letterChar = (char) letterNum.intValue();
			plate = plate.concat(String.valueOf(letterChar));
			i++;
		}
		
		/*Sets the 3 or 4 final random digits of a plate*/
		plate = plate.concat(String.valueOf(rand.nextInt(9899)+100));
		
		return plate;
	}
	
	/**
	 * Creates a random point in time.
	 * @return The String point in time.
	 * */
	public static String generateDateTime() {
		
		String dateStr = "";
		Random rand = new Random();

		/*Adds the day*/
		dateStr = correctFormat(String.valueOf(rand.nextInt(DAYSINMONTH) + 1));
		/*Adds the month*/
		dateStr = dateStr.concat("/").concat(
				correctFormat(String.valueOf(rand.nextInt(MONTHS) + 1)));
		/*Adds the year (Between 1900 and 2100)*/
		dateStr = dateStr.concat("/").concat(
				String.valueOf(rand.nextInt(NUMYEARS) + INITIALYEAR));
		/*Adds the hour*/
		dateStr = dateStr.concat(" ").concat(
				correctFormat(String.valueOf(rand.nextInt(NUMHOURS))));
		/*Adds the minutes*/
		dateStr = dateStr.concat(":").concat(
				correctFormat(String.valueOf(rand.nextInt(NUMMINUTES))));		

		return dateStr;
	}
	
	/**
	 * Adds a 0 to the one digit values to get them in the correct format.
	 * @return The string in the desired format.
	 * */
	private static String correctFormat(String data) {
		if(data.length()<2) {
			data = ("0").concat(data);
		}
		
		return data;
	}

}
