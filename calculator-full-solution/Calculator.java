/**
 * The main class of a simple calculator. Create one of these and you'll
 * get the calculator on screen.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Calculator
{
    private CalcEngine engine;
    private UserInterface gui;
    private CalcEngineHex engineHex;
    private UserInterfaceHex guiHex;
    private boolean isHex = true;

    /**
     * Create a new calculator and show it.
     */
    public Calculator()
    {
    	if(isHex) {
    		engineHex = new CalcEngineHex();
            guiHex = new UserInterfaceHex(engineHex);

    	} else {
    		engine = new CalcEngine();
    	    gui = new UserInterface(engine);
    	}
    }

    /**
     * In case the window was closed, show it again.
     */
    public void show()
    {
        gui.setVisible(true);
    	
    }
}
