package entitys;

import java.time.LocalDate;

public class Hoadon {
	private String mahoadon;
	private LocalDate ngaylaphoadon;
	private Nhanvien nvlap;
	private Khachhang kh;
	private double tongtien;
	public double getTongtien() {
		return tongtien;
	}
	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}
	public Khachhang getKh() {
		return kh;
	}
	public void setKh(Khachhang kh) {
		this.kh = kh;
	}
	
	
	public Hoadon(String mahoadon, LocalDate ngaylaphoadon, Nhanvien nvlap, Khachhang kh, double tongtien) {
		super();
		this.mahoadon = mahoadon;
		this.ngaylaphoadon = ngaylaphoadon;
		this.nvlap = nvlap;
		this.kh = kh;
		this.tongtien = tongtien;
	}
	public Hoadon(String mahoadon, LocalDate ngaylaphoadon, Nhanvien nvlap, Khachhang kh) {
		super();
		this.mahoadon = mahoadon;
		this.ngaylaphoadon = ngaylaphoadon;
		this.nvlap = nvlap;
		this.kh = kh;
	}
	public Hoadon(String mahoadon, LocalDate ngaylaphoadon, Nhanvien nvlap) {
		super();
		this.mahoadon = mahoadon;
		this.ngaylaphoadon = ngaylaphoadon;
		this.nvlap = nvlap;
	}
	public String getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}
	public LocalDate getNgaylaphoadon() {
		return ngaylaphoadon;
	}
	public void setNgaylaphoadon(LocalDate ngaylaphoadon) {
		this.ngaylaphoadon = ngaylaphoadon;
	}
	public Nhanvien getNvlap() {
		return nvlap;
	}
	public void setNvlap(Nhanvien nvlap) {
		this.nvlap = nvlap;
	}
	
	
}
