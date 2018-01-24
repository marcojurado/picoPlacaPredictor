/**
 * The class deals with fields and methods relevant in the project
 * that are part of a car.
 * @author Marco Jurado M.
 * @version 1.0
 */
public class Car {

	/*Constants*/

	private static final int TUESDAYPICOPLACA = 3;
	private static final int WEDNESDAYPICOPLACA = 5;
	private static final int THURSDAYPICOPLACA = 7;
	private static final int FRIDAYPICOPLACA = 9;
	private static final int FRIDAYPICOPLACA2 = 0;

	/*Fields*/
	
	/**
	 * The 3 letters + 3 to 4 numbers that make an plate number. 
	 * */
	private String plate = "";
	/**
	 * The day that this car has Pico y Placa.
	 * */
	private String picoPlacaDay = "";
	/**
	 * The last digit of the license plate number; 
	 * */
	private Integer lastDigit = 0;	
	
	/*Constructor*/
	
	Car(String plateNumber){
		
		/*All the values of the object are initialised*/
		this.plate = plateNumber;
        lastDigit = Integer.valueOf(Character.toString(plateNumber.charAt(plateNumber.length()-1)));
        picoPlacaDay = calculatePicoPlacaDay(lastDigit);
	}
	
	/*Methods*/
	
	/**
	 * Calculates in which day, a car has Pico y Placa given the 
	 * last digit of the plate number.
	 * @param lastDigit The last digit of the plate number.
	 * @return String with the name of the day of Pico y Placa in capital letters.  
	 * */
	private String calculatePicoPlacaDay(Integer lastDigit) {
		if(lastDigit == FRIDAYPICOPLACA2 ) {
			return "FRIDAY";
		}
		else if(lastDigit < TUESDAYPICOPLACA){
			return "MONDAY";
		}
		else if(lastDigit < WEDNESDAYPICOPLACA){
			return "TUESDAY";
		}
		else if(lastDigit < THURSDAYPICOPLACA){
			return "WEDNESDAY";
		}
		else if(lastDigit < FRIDAYPICOPLACA){
			return "THURSDAY";
		}
		else if(lastDigit == FRIDAYPICOPLACA) {
			return "FRIDAY";
		}
		else {
			System.out.println("ERROR, lastDigit > 9");
		}
		return "ERROR";
	}
	
	public String getPicoPlacaDay() {
		return picoPlacaDay;
	}

	public String getPlate() {
		return this.plate;
	}

}
