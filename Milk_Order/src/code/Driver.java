package code;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import GUI.GUI;

public class Driver implements Runnable {

	
	private OrderSheet _os;
	private JFrame _window;
	private JPanel _mainPanel;
	
	public Driver(OrderSheet os) {
		_os=os;
	}
	
	public static void main(String[] args) {
		OrderSheet os = new OrderSheet("src/Products");
		SwingUtilities.invokeLater(new Driver(os));
	}

	@Override
	public void run() {
		_window = new JFrame("Milk Order");
		_mainPanel = new JPanel();
		_window.getContentPane().add(_mainPanel);
		
		new GUI(_os,_mainPanel,this);
		
		_window.setVisible(true);
		_window.pack();
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public void updateJFrame() {
		_window.pack();
		_window.repaint();
	}
}