package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import code.Driver;
import code.OrderSheet;

public class GUI {

	private Driver _windowHolder;
	private JPanel _mainPanel;
	private JPanel _panel;
	private JPanel _productPanel;
	private JPanel _codePanel;
	
	public GUI(OrderSheet os, JPanel mp, Driver driver) {
	
		_windowHolder = driver;
		_mainPanel = mp;
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.X_AXIS));
		_productPanel = new JPanel();
		_productPanel.setLayout(new GridLayout(os.getProducts().size()+3,9));
		_codePanel = new JPanel();
		_codePanel.setLayout(new GridLayout(os.getCodes().size()+3,9));
		
		for(int i=0;i<os.getProducts().size();i++) {
			JLabel add = new JLabel(os.getProducts().get(i));
			setLabelProperties(add);
			_productPanel.add(add);
		}
		
		for(int i=0;i<os.getCodes().size();i++) {
			JLabel add = new JLabel(os.getCodes().get(i));
			setLabelProperties(add);
			_codePanel.add(add);
		}
		
		_panel=new JPanel();
		_panel.setLayout(new BoxLayout(_panel, BoxLayout.X_AXIS));
		_panel.add(_codePanel);
		_panel.add(_productPanel);
		JScrollPane scroll = new JScrollPane(_panel);
		_mainPanel.add(scroll, BorderLayout.EAST);
	}
	
	public void setButtonProperties(JButton button) {
		button.setFont(new Font("Courier", Font.BOLD, 25));
		button.setBackground(Color.WHITE);
		button.setForeground(Color.BLACK);
		button.setOpaque(true);
		button.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}
	
	public void setLabelProperties(JLabel label) {
		if(label.getText().contains("MILK")||label.getText().contains("HALF & HALF")||label.getText().contains("CREAMS")||label.getText().contains("PINTS")||label.getText().contains("CHEESE")||label.getText().contains("EGG NOG")==true) {
			label.setFont(new Font("Courier", Font.BOLD, 25));
			label.setBackground(Color.LIGHT_GRAY);
			label.setForeground(Color.BLACK);
			label.setOpaque(true);
			label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
		}
		else {
		label.setFont(new Font("Courier", Font.BOLD, 25));
		label.setBackground(Color.WHITE);
		label.setForeground(Color.BLACK);
		label.setOpaque(true);
		label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
		}
	}
	
}
