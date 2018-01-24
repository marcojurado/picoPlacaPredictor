import java.util.*;
import java.time.*;
import java.time.format.*;

/**
 * This is the main class. It predicts whether a car has pico y placa.
 * It ask the user for a plate number, date and time.
 * @author Marco Jurado M.
 * @version 1.0
 */
public class Predictor {

    public static void main(String[] args) {

    	/*Instructions for the user*/
    	System.out.println("Enter the information in this way:");
        System.out.println("[plate number] [date] [time]");
        System.out.println("E.g. PPP1234 DD/MM/YYYY HH:MM");
        System.out.println("If a value contains 1 digit, please add a 0");
        System.out.println("in front to match the format. E.g. 1 to 01 in DD");

        
        /*Receiving the user's information */
        Scanner userInput = new Scanner(System.in);
        String plateNumber = userInput.next();
        String dateStr = userInput.next();
        String timeStr = userInput.next();
        userInput.close();
        
        /*Creating a Car object*/
        Car car = new Car(plateNumber);
        
        /*Creating an object that will store the point in time given*/
        dateStr = dateStr.concat(" ").concat(timeStr);
		LocalDateTime date = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		
		/*Evaluating whether a car has Pico y Placa on a given point in time*/
		if(Toolbox.hasPicoPlaca(car, date)) {
	        System.out.println("Auto PROHIBIDO de transitar en Quito");
		}
		else {
	        System.out.println("Auto AUTORIZADO para transitar en Quito");
		}
    }   
}

