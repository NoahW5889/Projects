package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

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
	private JPanel _searchPanel;
	private JTextField search;
	private ArrayList<String> prodList;
	private ArrayList<String> code;
	
	public GUI(OrderSheet os, JPanel mp, Driver driver) {
	
		_mainPanel = mp;
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.Y_AXIS));
		_productPanel = new JPanel();
		_productPanel.setLayout(new GridLayout(os.getProducts().size()+3,9));
		_codePanel = new JPanel();
		_codePanel.setLayout(new GridLayout(os.getCodes().size()+3,9));
		_textPanel = new JPanel();
		_textPanel.setLayout(new GridLayout(os.getProducts().size()+3,9));
		
		JLabel upstate = new JLabel("Upstate Farms: (716) 892-3434");
		setTitleProperties(upstate);
		_mainPanel.add(upstate);
		
		JLabel title = new JLabel("WEEKLY MILK ORDER SHEET FOR W/E:");
		setTitleProperties(title);
		_mainPanel.add(title);
		
		JLabel customerNum = new JLabel("Customer Number: 110 420 461");
		setTitleProperties(customerNum);
		_mainPanel.add(customerNum);
		
		_searchPanel = new JPanel();
		JButton searchBox = new JButton("Search:");
		searchBox.addActionListener(new searchHandler(this));
		setButtonProperties(searchBox);
		_searchPanel.add(searchBox);
		
		search = new JTextField();
		search.setColumns(30);
		_searchPanel.add(search);
		_mainPanel.add(_searchPanel);
		
		prodList=new ArrayList<String>();
		code=new ArrayList<String>();
		
		
		for(int i=0;i<os.getCodes().size();i++) {
			JLabel add = new JLabel(os.getCodes().get(i));
			setLabelProperties(add);
			code.add(os.getCodes().get(i));
			_codePanel.add(add);
		}
		
		for(int i=0;i<os.getProducts().size();i++) {
			JLabel add = new JLabel(os.getProducts().get(i));
			setLabelProperties(add);
			prodList.add(os.getProducts().get(i));
			_productPanel.add(add);
		}
		
		for(int i=0;i<os.getProducts().size();i++) {
			if(os.getCodes().get(i).replaceAll("[^0-9]", "").equals("")) {
				JLabel spacer = new JLabel(os.getCodes().get(i));
				setLabelProperties(spacer);
				_textPanel.add(spacer);
			}
			else {
		JTextField text = new JTextField();	
		_textPanel.add(text);
			}
		}
		
		_scrollPanel=new JPanel();
		_scrollPanel.setLayout(new BoxLayout(_scrollPanel, BoxLayout.X_AXIS));
		_scrollPanel.add(_codePanel);
		_scrollPanel.add(_productPanel);
		_scrollPanel.add(_textPanel);
		JScrollPane scroll = new JScrollPane(_scrollPanel);
		_mainPanel.add(scroll, BorderLayout.EAST);
	}
	
	public String getSearch() {
		return this.search.getText();
		
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

	public void search(String search2) {
		_productPanel.removeAll();
		_codePanel.removeAll();
		_textPanel.removeAll();
		for(int i=0;i<prodList.size();i++) {
			if(prodList.get(i).toLowerCase().contains(search2.toLowerCase())) {
				JLabel cod = new JLabel(code.get(i));
				setLabelProperties(cod);
				JLabel sir = new JLabel(prodList.get(i));
				setLabelProperties(sir);
				JTextField num = new JTextField();
				num.setColumns(20);
				_codePanel.add(cod);
				_productPanel.add(sir);
				_textPanel.add(num);
			}
		}
		
	}
	
}