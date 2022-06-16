package project_java;
import javax.swing.*;
import java.awt.*;
import java.util.*;

import java.text.SimpleDateFormat;

public class MyWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel heading ;
	private JLabel clockLabel ;
	private Font font = new Font (  " " , Font.BOLD , 35 ) ;
	MyWindow()
	{
		super.setTitle ( " My Clock " ) ;
		super.setSize ( 400 ,  400 ) ;
		super.setLocation(300,500);
		this.createGUI();
		this.startClock();
		super.setVisible ( true ) ;
	}
	public void createGUI() {
		heading=new JLabel (" My Clock " );
		clockLabel = new JLabel (" clock ");
		heading.setFont ( font ) ;
		clockLabel.setFont(font);
		this.setLayout ( new GridLayout( 2 , 1 ) ) ;
		this.add ( heading ) ;
		this.add ( clockLabel ) ;
		
		
	}
	public  void startClock()
	{
		
		
		
		Thread t = new Thread ( ) {
		public void run ( )
		{
		try
		{
		while (true)
		{
			Date d = new Date ( ) ;
			SimpleDateFormat sfd = new SimpleDateFormat( " hh : mm : ss a " ) ;
			String dateTime = sfd . format ( d ) ;
			clockLabel.setText ( dateTime ) ;
			Thread.sleep ( 1000 ) ;
			
		}
		}
		catch ( InterruptedException e )
			{
			e.printStackTrace ( ) ;
			}
		}
};
	t.start();
	}
}
	