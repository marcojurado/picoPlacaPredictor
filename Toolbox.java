import java.time.LocalDateTime;

/**
 * Contains a set of tools to make the Prediction process easier.
 * @author Marco Jurado M.
 * @version 1.0
 * */
public final class Toolbox {
	
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
