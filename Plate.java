
public class Plate {
	
	/*Fields*/
	private String plateNumber = ""; 
	private String picoPlacaDay = "";
	private Integer lastDigit = 999;
	/*Constructor*/
	Plate(String plateNumber){
		this.plateNumber = plateNumber;
        lastDigit = Integer.valueOf(plateNumber.charAt(plateNumber.length()-1));
        
	}
	
	/*Methods*/
	
	private String calculatePicoPlacaDay(String plateNumber) {
		String day = "";
		return day;
	} 
	
	
}
