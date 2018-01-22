//make exceptions

import java.util.*;
import java.time.*;
import java.time.format.*;


public class Predictor {

    public static void main(String[] args) {

    	System.out.println("Enter the information in this way:");
        System.out.println("[plate number] [date] [time]");
        System.out.println("E.g. PPP1234 DD/MM/YYYY HH:MM");
        Scanner userInput = new Scanner(System.in);
        String plateNumber = userInput.next();
        String dateStr = userInput.next();
        String timeStr = userInput.next();
        
        /*This needs fixing*/ 
        if(dateStr.length()==9) {
        	dateStr = "0".concat(dateStr);
        }
        
        if(timeStr.length()==4) {
        	timeStr = "0".concat(timeStr);
        }
        
        userInput.close();
        
        Car car = new Car(plateNumber);
        
        dateStr = dateStr.concat(" ").concat(timeStr);

		LocalDateTime date = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
//		System.out.println(date.getDayOfWeek());
		
		if(hasPicoPlaca(car, date)) {
	        System.out.println("Auto PROHIBIDO de transitar en Quito");
		}
		else {
	        System.out.println("Auto AUTORIZADO para transitar en Quito");
		}
		
    }
    
    
    
    private static Boolean isPicoPlacaTime(LocalDateTime date) {
    	
    	/*Has morning PicoPlaca*/
    	if(date.getHour()>=7 && date.getHour()<9) {
    		return Boolean.TRUE;
    	}	
    	if(date.getHour()==9 && date.getMinute()<30) {
			return Boolean.TRUE;
		}
    	
    	/*Has afternoon PicoPlaca*/
    	if(date.getHour()>=16 && date.getHour()<19) {
			return Boolean.TRUE;
    	}
    	if(date.getHour()==19 && date.getMinute()<30) {
			return Boolean.TRUE;
		}
    	
    	System.out.println("isPicoPlacaTime = FALSE");
    	return Boolean.FALSE;
    	
    }
    
    private static Boolean isPicoPlacaDay(Car car, LocalDateTime date) {
    	
		System.out.println("Day of Pico Placa:" + car.getPicoPlacaDay());
    	if(car.getPicoPlacaDay()==date.getDayOfWeek().toString()) {
    		return Boolean.TRUE;
    	}
    	
    	System.out.println("isPicoPlacaDay = FALSE");
    	return Boolean.FALSE;
    	
    }
    
    private static Boolean hasPicoPlaca(Car car, LocalDateTime date) {
    	
    	if(isPicoPlacaDay(car, date) && isPicoPlacaTime(date)) {
    		return Boolean.TRUE;
    	}
    	
    	return Boolean.FALSE;
		
	}
    
}












