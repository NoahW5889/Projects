package code;

import java.util.ArrayList;



public class OrderSheet {

	
	ArrayList<String> codeList = new ArrayList<String>();
	ArrayList<String> productList = new ArrayList<String>();
	
	public OrderSheet(ArrayList<String> _codeList, ArrayList<String> _productList) {
		codeList=_codeList;
		productList=_productList;
	}
	
	public ArrayList<String> getCodes(){
		return codeList;
	}
	
	public ArrayList<String> getProducts(){
		return productList;
	}
}