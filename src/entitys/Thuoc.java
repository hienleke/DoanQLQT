package entitys;

import java.time.LocalDate;

public class Thuoc {
	private String Ma;
	private String Donvi;
	private String Tenthuoc;
	private Nhacungcap Nhacungcap;
	private LocalDate Hansudung;
	private Danhmucthuoc dmt ;
	private double Dongia;
	private int sltonkho;
	
	
	public int getSltonkho() {
		return sltonkho;
	}
	public void setSltonkho(int sltonkho) {
		this.sltonkho = sltonkho;
	}
	public Thuoc(String ma, String donvi, String tenthuoc, entitys.Nhacungcap nhacungcap, LocalDate hansudung,
			Danhmucthuoc dmt, double dongia, int sltonkho) {
		super();
		Ma = ma;
		Donvi = donvi;
		Tenthuoc = tenthuoc;
		Nhacungcap = nhacungcap;
		Hansudung = hansudung;
		this.dmt = dmt;
		Dongia = dongia;
		this.sltonkho = sltonkho;
	}
	public Thuoc(String ma, String donvi, String tenthuoc, entitys.Nhacungcap nhacungcap, LocalDate hansudung,
			Danhmucthuoc dmt, double dongia) {
		super();
		Ma = ma;
		Donvi = donvi;
		Tenthuoc = tenthuoc;
		Nhacungcap = nhacungcap;
		Hansudung = hansudung;
		this.dmt = dmt;
		Dongia = dongia;
	}
	public String getMa() {
		return Ma;
	}
	public void setMa(String ma) {
		Ma = ma;
	}
	public String getDonvi() {
		return Donvi;
	}
	public void setDonvi(String donvi) {
		Donvi = donvi;
	}
	public Danhmucthuoc getDmt() {
		return dmt;
	}
	public void setDmt(Danhmucthuoc dmt) {
		this.dmt = dmt;
	}
	public String getTenthuoc() {
		return Tenthuoc;
	}
	public void setTenthuoc(String tenthuoc) {
		Tenthuoc = tenthuoc;
	}
	public Nhacungcap getNhacungcap() {
		return Nhacungcap;
	}
	public void setNhacungcap(Nhacungcap nhacungcap) {
		Nhacungcap = nhacungcap;
	}
	public LocalDate getHansudung() {
		return Hansudung;
	}
	public void setHansudung(LocalDate hansudung) {
		Hansudung = hansudung;
	}
	public double getDongia() {
		return Dongia;
	}
	public void setDongia(double dongia) {
		Dongia = dongia;
	}
	@Override
	public String toString() {
		return "Thuoc [Ma=" + Ma + ", Donvi=" + Donvi + ", Tenthuoc=" + Tenthuoc + ", Nhacungcap=" + Nhacungcap
				+ ", Hansudung=" + Hansudung + ", dmt=" + dmt + ", Dongia=" + Dongia + ", sltonkho=" + sltonkho + "]";
	}
	
	
	
	
}
