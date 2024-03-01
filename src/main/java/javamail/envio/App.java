package javamail.envio;

import java.awt.EventQueue;

import view.GUI1;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main( String[] args ) throws Exception
    {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI1 window = new GUI1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
           


        
    }

    

    
}
