package code;

public class Item {

	private int code;
	private String product;
	private boolean spacer;
	
	public Item(int _code, String _product) {
		code=_code;
		product=_product;
		spacer=false;
	}
	
	public  void setCode(int x) {
		this.code=x;
	}
	
	public void setProduct(String y) {
		this.product=y;
	}
	
	public void setSpacer(boolean _spacer) {
		this.spacer=_spacer;
	}
	
	public boolean isSpacer() {
		return spacer;
	}
	
	public int getCode(){
		return code;
	}
	
	public String getProduct(){
		return product;
	}
}