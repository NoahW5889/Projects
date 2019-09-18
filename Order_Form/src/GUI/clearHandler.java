package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.OrderSheet;

public class clearHandler implements ActionListener{
	private GUI _g;
	private OrderSheet _os;
	
	public clearHandler(GUI gui, OrderSheet os) {
		_g=gui;
		_os=os;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_g.clearSearch(_os);
		
	}

}
