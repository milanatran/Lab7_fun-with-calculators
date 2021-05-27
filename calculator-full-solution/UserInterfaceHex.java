import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class UserInterfaceHex extends UserInterface{
	private boolean checked = true;
	
	public UserInterfaceHex(CalcEngineHex engine) {
		super(engine);
		//makeFrame();
	}

	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	//}
	
	 /**
     * Add a button to the button panel.
     * @param panel The panel to receive the button.
     * @param buttonText The text for the button.
     */
    protected void addButton(Container panel, String buttonText, boolean visible)
    {
        JButton button = new JButton(buttonText);
        button.addActionListener(this);
        button.setVisible(visible);
        panel.add(button);
    }

	
	/**
     * Make the frame for the user interface.
     */
    protected void makeFrame()
    {
    	Checkbox cb = new Checkbox("Hex", true);
        frame = new JFrame(calc.getTitle());
        
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(8, 8));
        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));
        
       

        display = new JTextField();
        contentPane.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 4));
        	
            addButton(buttonPanel, "7");
            addButton(buttonPanel, "8");
            addButton(buttonPanel, "9");
            addButton(buttonPanel, "Clear");
            
            addButton(buttonPanel, "4");
            addButton(buttonPanel, "5");
            addButton(buttonPanel, "6");
            addButton(buttonPanel, "?");
            
            addButton(buttonPanel, "1");
            addButton(buttonPanel, "2");
            addButton(buttonPanel, "3");
            addButton(buttonPanel, "*");
            //buttonPanel.add(new JLabel(" "));
            
            addButton(buttonPanel, "0");
            addButton(buttonPanel, "+");
            addButton(buttonPanel, "-");
            addButton(buttonPanel, "=");
            
            addButton(buttonPanel, "A", checked);
            addButton(buttonPanel, "B", checked);
            addButton(buttonPanel, "C", checked);
            addButton(buttonPanel, "D", checked);
            
            addButton(buttonPanel, "E", checked);
            addButton(buttonPanel, "F", checked);
            
            cb.addItemListener(new ItemListener() {
            	public void itemStateChanged(ItemEvent e) {
            		Checkbox ch =(Checkbox) e.getItemSelectable();
            		if(ch.getState()==true) {}
            			
            	}
            });
            
            buttonPanel.add(cb);
           // buttonPanel.add(new JLabel(" "));
            
            
            
            
            
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        status = new JLabel(calc.getAuthor());
        contentPane.add(status, BorderLayout.SOUTH);

        frame.pack();
    }
    
   /* public void isChecked(ItemEvent e) {
    	if(e.getStateChange() == 1) {
    		this.makeFrame();
    	}else {
    		super.makeFrame();
    	}
    }*/
	
	/**
     * An interface action has been performed.
     * Find out what it was and handle it.
     * @param event The event that has occured.
     */
    public void actionPerformed(ActionEvent event)
    {
    	
        String command = event.getActionCommand();

        if(command.equals("0") ||
           command.equals("1") ||
           command.equals("2") ||
           command.equals("3") ||
           command.equals("4") ||
           command.equals("5") ||
           command.equals("6") ||
           command.equals("7") ||
           command.equals("8") ||
           command.equals("9")) {
            int number = Integer.parseInt(command);
            calc.numberPressed(number);
        }
        else if(command.equals("A") ||
                command.equals("B") ||
                command.equals("C") ||
                command.equals("D") ||
                command.equals("E") ||
                command.equals("F") ) {
                 int number = Integer.parseInt(command,16);
                 calc.numberPressed(number);
        }
        else if(command.equals("+")) {
            calc.plus();
        }
        else if(command.equals("-")) {
            calc.minus();
        }
        else if(command.equals("*")) {
            calc.multiplication();
        }
        else if(command.equals("=")) {
            calc.equals();
        }
        else if(command.equals("Clear")) {
            calc.clear();
        }
        else if(command.equals("?")) {
            showInfo();
        }
        // else unknown command.

        redisplay();
    }
    
    /**
     * Update the interface display to show the current value of the 
     * calculator.
     */
    protected void redisplay()
    {
        display.setText("" + Integer.toHexString(calc.getDisplayValue()).toUpperCase());
    }

	//@Override
	/*public void itemStateChanged(ItemEvent e) {
		Checkbox ch =(Checkbox) e.getItemSelectable();
		if(ch.getState()==true) {
			checked = false;
			frame.repaint();
			//makeFrame();
			//frame.setVisible(true);
			//this.setVisible(false);
			//super.makeFrame();
			//frame.setVisible(true);
		}
		
	}*/

	
    

}
