package entitys;

public class Nhanvien {
	private  String ma;
	private String ten;
	
	
	public Nhanvien(String ma) {
		super();
		this.ma = ma;
	}
	public Nhanvien(String ma, String ten) {
		super();
		this.ma = ma;
		this.ten = ten;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	
}
