package entitys;

public class Khachhang {
	private String ma;
	private String ten;
	private String sdt;
	public Khachhang(String ma, String ten, String sdt) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.sdt = sdt;
	}
	
	
	public Khachhang(String ten, String sdt) {
		super();
		this.ten = ten;
		this.sdt = sdt;
	}


	public Khachhang(String ma) {
		super();
		this.ma = ma;
	}
	public Khachhang() {
		super();
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
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	
}
