package entitys;

public class Nhacungcap {
	private String Ma;
	private String Ten;
	private String Diachi;
	
	public Nhacungcap(String ma, String ten, String diachi) {
		super();
		Ma = ma;
		Ten = ten;
		Diachi = diachi;
	}
	

	public Nhacungcap(String ma) {
		super();
		Ma = ma;
	}


	public String getMa() {
		return Ma;
	}

	public void setMa(String ma) {
		Ma = ma;
	}

	public String getTen() {
		return Ten;
	}

	public void setTen(String ten) {
		Ten = ten;
	}

	public String getDiachi() {
		return Diachi;
	}

	public void setDiachi(String diachi) {
		Diachi = diachi;
	}


	@Override
	public String toString() {
		return "Nhacungcap [Ma=" + Ma + ", Ten=" + Ten + ", Diachi=" + Diachi + "]";
	}
	
	
	
	
	
}
