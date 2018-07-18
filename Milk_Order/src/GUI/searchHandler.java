package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.OrderSheet;

public class searchHandler implements ActionListener {
	private GUI _g;
	
	public searchHandler(GUI gui) {
		_g=gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_g.search(_g.getSearch());
	}

}
