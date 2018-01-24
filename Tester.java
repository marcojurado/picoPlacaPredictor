import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * The class will test the outcomes of the predictor in several ways.
 * @author Marco Jurado M.
 * @version 1.0
 */
public class Tester {
	
	/**
	 * Controls the number of tests to be done.
	 * (1 test = 1 plate number + 1 date and time used)
	 * */
	private static final int NUMTESTS = 1000;

	public static void main(String[] args) {
		
		manualCompleteTest();
		automatedCompleteTest();
		
	}

	/**
	 * Shows to the user all the information needed to evaluate manually whether the 
	 * Predictor is doing its job.
	 * */
	private static void manualCompleteTest() {
		Integer i=0;
		while(i<NUMTESTS) {
			
			/*Random data for the car and its plate is generated*/
			String plate = DataGenerator.generatePlate();
			Car car = new Car(plate);
			
			/*Random data for a point in time is generated*/
			String dateTimeStr = DataGenerator.generateDateTime();
			LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
			
			/*All the information required to make a manual evaluation is shown*/
			System.out.println(
					plate + " " + dateTime.getDayOfWeek() + " "+dateTimeStr+ " " + 
					"PicoPlaca:" + Toolbox.hasPicoPlaca(car, dateTime)
			);
			
			i++;
		}
	}
	
	/**
	 * Evaluates the predictor in different components and situations.
	 * The result of the test is given to the user as a console text. 
	 * */
	private static void automatedCompleteTest() {
		/**
		 * Carries the result of the evaluation.
		 * */
		Boolean testFailed = Boolean.FALSE;

		Integer i=0;
		while(i<NUMTESTS) {
			
			/*Random data generated*/
			String plate = DataGenerator.generatePlate();
			Car car = new Car(plate);
			String dateTimeStr = DataGenerator.generateDateTime();
			LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
			
			/*Checks the consistency of the final evaluation with its parts*/
			if(Toolbox.hasPicoPlaca(car, dateTime)) {
				
				/*Checks if a car is in the day and time of Pico y Placa*/
				if(!Toolbox.isPicoPlacaDay(car, dateTime)) testFailed = Boolean.TRUE;
				if(!Toolbox.isPicoPlacaTime(dateTime)) testFailed = Boolean.TRUE;
				
				/*Checks if the day is consistent*/
				if(dateTime.getDayOfWeek().toString()!=car.getPicoPlacaDay()) testFailed = Boolean.TRUE;
				if(dateTime.getDayOfWeek().toString()=="SATURDAY") testFailed = Boolean.TRUE;
				if(dateTime.getDayOfWeek().toString()=="SUNDAY") testFailed = Boolean.TRUE;
				
				/*Checks if the time is consistent*/
				if(dateTime.getHour()<7) testFailed = Boolean.TRUE;
				if(dateTime.getHour()>19) testFailed = Boolean.TRUE;
				if(dateTime.getHour()>9 && dateTime.getHour()<16) testFailed = Boolean.TRUE;


			}

			i++;
		}
		
		if(testFailed) {
			System.out.println("automatedCompleteTest has failed");
		}
		else {
			System.out.println("automatedCompleteTest has finished successfully");

		}
	}
	
	
}
