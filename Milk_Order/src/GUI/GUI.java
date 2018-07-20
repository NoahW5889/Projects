package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import code.Driver;
import code.OrderSheet;

public class GUI {

	private JPanel _mainPanel;
	private JPanel _scrollPanel;
	private JPanel _productPanel;
	private JPanel _codePanel;
	private JPanel _textPanel;
	private JPanel _submitPanel;
	private JScrollPane scroll;
	private int listSize;
	public GUI(OrderSheet os, JPanel mp, Driver driver) {
	
		os.getList();
		listSize=os.getLength();
		_mainPanel = mp;
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.Y_AXIS));
		_productPanel = new JPanel();
		_productPanel.setLayout(new GridLayout(listSize+3,9));
		_codePanel = new JPanel();
		_codePanel.setLayout(new GridLayout(listSize+3,9));
		_textPanel = new JPanel();
		_textPanel.setLayout(new GridLayout(listSize+3,9));
		_submitPanel=new JPanel();
		_submitPanel.setLayout(new GridLayout(listSize+3,9));
		
		JLabel upstate = new JLabel("Upstate Farms: (716) 892-3434");
		setTitleProperties(upstate);
		_mainPanel.add(upstate);
		
		JLabel title = new JLabel("WEEKLY MILK ORDER SHEET FOR W/E:");
		setTitleProperties(title);
		_mainPanel.add(title);
		
		JLabel customerNum = new JLabel("Customer Number: 110 420 461");
		setTitleProperties(customerNum);
		_mainPanel.add(customerNum);
		
		for(String codes : os.getList().keySet()) {
			JLabel add = new JLabel(codes);
			setLabelProperties(add);
			_codePanel.add(add);
		}
		
		for(String products : os.getList().values()) {
			JLabel add = new JLabel(products);
			setLabelProperties(add);
			_productPanel.add(add);
		}
		
		for(int i=0;i<listSize;i++) {
			JTextField count = new JTextField();
			count.setColumns(30);
			_textPanel.add(count);
		}
		
		JButton submit = new JButton("Submit");
		setButtonProperties(submit);
		_submitPanel.add(submit);
		
		_scrollPanel=new JPanel();
		_scrollPanel.setLayout(new BoxLayout(_scrollPanel, BoxLayout.X_AXIS));
		_scrollPanel.add(_codePanel);
		_scrollPanel.add(_productPanel);
		_scrollPanel.add(_textPanel);
		_scrollPanel.add(_submitPanel);
		scroll = new JScrollPane(_scrollPanel);
		_mainPanel.add(scroll, BorderLayout.EAST);
		_mainPanel.add(submit);
		JLabel author = new JLabel("Created By Noah Wutz");
		_mainPanel.add(author);
		
	}
	

	public void setTitleProperties(JLabel label) {
		label.setFont(new Font("Courier", Font.BOLD, 28));
		label.setBackground(Color.WHITE);
		label.setForeground(Color.BLACK);
		label.setOpaque(true);
		label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
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
