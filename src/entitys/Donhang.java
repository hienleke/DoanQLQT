package entitys;

import java.time.LocalDate;

public class Donhang {
	private String Ma;
	private LocalDate ngaytaodonhang;
	private int Soluong;
	private String ten;
	private double Tongtien;
	private double thanhtien;
	private Khachhang kh;
	
	
	public Donhang(String ma, LocalDate ngaytaodonhang, int soluong, String ten, double tongtien, double thanhtien,
			Khachhang kh) {
		super();
		Ma = ma;
		this.ngaytaodonhang = ngaytaodonhang;
		Soluong = soluong;
		this.ten = ten;
		Tongtien = tongtien;
		this.thanhtien = thanhtien;
		this.kh = kh;
	}
	public Khachhang getKh() {
		return kh;
	}
	public void setKh(Khachhang kh) {
		this.kh = kh;
	}
	public Donhang(String ma, LocalDate ngaytaodonhang, int soluong, String ten, double tongtien, double thanhtien) {
		super();
		Ma = ma;
		this.ngaytaodonhang = ngaytaodonhang;
		Soluong = soluong;
		this.ten = ten;
		Tongtien = tongtien;
		this.thanhtien = thanhtien;
	}
	public String getMa() {
		return Ma;
	}
	public void setMa(String ma) {
		Ma = ma;
	}
	public LocalDate getNgaytaodonhang() {
		return ngaytaodonhang;
	}
	public void setNgaytaodonhang(LocalDate ngaytaodonhang) {
		this.ngaytaodonhang = ngaytaodonhang;
	}
	public int getSoluong() {
		return Soluong;
	}
	public void setSoluong(int soluong) {
		Soluong = soluong;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public double getTongtien() {
		return Tongtien;
	}
	public void setTongtien(double tongtien) {
		Tongtien = tongtien;
	}
	public double getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(double thanhtien) {
		this.thanhtien = thanhtien;
	}
	
	
}
