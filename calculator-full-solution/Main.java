
public class Main {

	public static void main(String[] args) {
		CalcEngineHex ce = new CalcEngineHex();
		UserInterfaceHex ui = new UserInterfaceHex(ce);
		ui.setVisible(true);
		
		
		//CalcEngine ce = new CalcEngine();
		//UserInterface ui = new UserInterface(ce);
		//ui.setVisible(true);

	}

}
