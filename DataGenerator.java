import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * This class will generate Random data to test the Predictor.
 * @author Marco Jurado M.
 * @version 1.0
 * */
public final class DataGenerator {
	
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
		while(i<3) {
			letterNum = rand.nextInt(26)+65;
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
		dateStr = correctFormat(String.valueOf(rand.nextInt(28) + 1));
		/*Adds the month*/
		dateStr = dateStr.concat("/").concat(
				correctFormat(String.valueOf(rand.nextInt(12) + 1)));
		/*Adds the year (Between 1900 and 2100)*/
		dateStr = dateStr.concat("/").concat(
				String.valueOf(rand.nextInt(200) + 1900));
		/*Adds the hour*/
		dateStr = dateStr.concat(" ").concat(
				correctFormat(String.valueOf(rand.nextInt(24))));
		/*Adds the minutes*/
		dateStr = dateStr.concat(":").concat(
				correctFormat(String.valueOf(rand.nextInt(60))));		

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
