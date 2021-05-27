
public class CalcEngineHex extends CalcEngine{

	public static void main(String[] args) {

	}
	
	public void numberPressed(int number) {
		if(buildingDisplayValue) {
            // Incorporate this digit.
			displayValue = displayValue*16 + number;
        }
        else {
            // Start building a new number.
            displayValue = number;
            buildingDisplayValue = true;
        }
	}
	
	/**
     * @return The value that should currently be displayed
     * on the calculator display.
     */
   /* public int getDisplayValue()
    {
        String hex = Integer.toHexString(displayValue);
    	System.out.println(Integer.parseInt(hex));
    	return Integer.parseUnsignedInt(hex,16);
    }*/

}
