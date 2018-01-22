
public class Car {

	/*Fields*/
	private String picoPlacaDay = "";
	private Integer lastDigit = 0;	
	
	Car(String plateNumber){
		
        lastDigit = Integer.valueOf(Character.toString(plateNumber.charAt(plateNumber.length()-1)));
        System.out.println(plateNumber);
        System.out.println("Last digit:" + lastDigit.toString());
        picoPlacaDay = calculatePicoPlacaDay(lastDigit);
	}
	
	/*Methods*/
	
	private String calculatePicoPlacaDay(Integer plateNumber) {
		if(plateNumber == 0 ) {
			return "FRIDAY";
		}
		else if(plateNumber <3){
			return "MONDAY";
		}
		else if(plateNumber <5){
			return "TUEDAY";
		}
		else if(plateNumber <7){
			return "WEDNESDAY";
		}
		else if(plateNumber <9){
			return "THURSDAY";
		}
		else if(plateNumber == 9) {
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
	

}
