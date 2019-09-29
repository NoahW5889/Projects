package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.OrderSheet;

public class clearHandler implements ActionListener{
	private OrderSheet _os;
	
	public clearHandler(OrderSheet os) {
		_os=os;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_os.clearSearch();
		
	}

}
