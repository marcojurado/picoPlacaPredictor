import java.time.LocalDateTime;

/**
 * Contains a set of tools to make the Prediction process easier.
 * @author Marco Jurado M.
 * @version 1.0
 * */
public final class Toolbox {
	
	/*Constants*/
	
	/*The hour numbers relevant in pico y placa*/
	private static final int STARTSMORNING = 7;
	private static final int ENDSMORNING = 9;
	private static final int STARTSAFTERNOON = 16;
	private static final int ENDSAFTERNOON = 19;
	
	/*The number of minutes when pico y placa ends*/
	private static final int ENDSMINUTES = 30;



	
	/*Constructor*/
	private Toolbox() {
	}
	
	/*Methods*/
	
	/**
     * Will evaluate whether the time is under Pico y Placa restrictions.
     * @param date Carries details of the point in time when the car is being evaluated.
     * @return A boolean value stating whether the car has restrictions.
     */
    public static Boolean isPicoPlacaTime(LocalDateTime date) {
    	
    	/*Has morning PicoPlaca*/
    	if(date.getHour()>=STARTSMORNING && date.getHour()<ENDSMORNING) {
    		return Boolean.TRUE;
    	}	
    	if(date.getHour()==ENDSMORNING && date.getMinute()<ENDSMINUTES) {
			return Boolean.TRUE;
		}
    	
    	/*Has afternoon PicoPlaca*/
    	if(date.getHour()>=STARTSAFTERNOON && date.getHour()<ENDSAFTERNOON) {
			return Boolean.TRUE;
    	}
    	if(date.getHour()==ENDSAFTERNOON && date.getMinute()<ENDSMINUTES) {
			return Boolean.TRUE;
		}
    	
    	return Boolean.FALSE;
    	
    }
    
    /**
     * Checks if a car is in its Pico y Placa day.
     * @param car Car object with the details of it.
     * @param date Carries details of the point on time when the car is evaluated.
     * @return A boolean value evaluating whether the car is in its Pico y Placa day.
     */
    public static Boolean isPicoPlacaDay(Car car, LocalDateTime date) {
    	
    	if(car.getPicoPlacaDay()==date.getDayOfWeek().toString()) {
    		return Boolean.TRUE;
    	}
    	
    	return Boolean.FALSE;
    	
    }
    
    /**
     * Checks if the car is in its day and time of Pico y Placa.
     * @param car Car object with the details of it.
     * @param date Carries details of the point on time when the car is evaluated.
     * @return A boolean value evaluating whether the car has Pico y Placa.
     */
    public static Boolean hasPicoPlaca(Car car, LocalDateTime date) {
    	
    	if(isPicoPlacaDay(car, date) && isPicoPlacaTime(date)) {
    		return Boolean.TRUE;
    	}
    	
    	return Boolean.FALSE;
		
	}
}
