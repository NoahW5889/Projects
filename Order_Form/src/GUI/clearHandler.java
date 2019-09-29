package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.Form;

public class clearHandler implements ActionListener{
	private Form _form;
	
	public clearHandler(Form form) {
		_form=form;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_form.clearSearch();
		
	}

}
