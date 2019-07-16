package entitys;

public class Danhmucthuoc {
	private String loaithuoc;
	private String madm;
	
	
	
	
	public Danhmucthuoc(String madm) {
		super();
		this.madm = madm;
	}


	public String getMadm() {
		return madm;
	}


	public void setMadm(String madm) {
		this.madm = madm;
	}


	public Danhmucthuoc(String loaithuoc, String madm) {
		super();
		this.loaithuoc = loaithuoc;
		this.madm = madm;
	}


	public String getLoaithuoc() {
		return loaithuoc;
	}

	public void setLoaithuoc(String loaithuoc) {
		this.loaithuoc = loaithuoc;
	}
	
	
}
