package tier_giaodien;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entitys.Danhmucthuoc;
import tier_DAO.Danhmucthuoc_DAO;

public class tablemodelqldanhmuc extends AbstractTableModel {
	String[] header = { "Mã danh mục ", "Tên loại thuốc" };
	Danhmucthuoc_DAO dmDAO = new Danhmucthuoc_DAO();

	ArrayList<Danhmucthuoc> ds = dmDAO.getdatafromnhacungcap();

	public tablemodelqldanhmuc(ArrayList<Danhmucthuoc> ds) {
		super();
		this.ds = ds;
	}
	
	

	public tablemodelqldanhmuc() {
		super();
	}



	public ArrayList<Danhmucthuoc> getDs() {
		return ds;
	}

	public void setDs(ArrayList<Danhmucthuoc> ds) {
		this.ds = ds;
	}

	@Override
	public int getRowCount() {
		return ds.size();
	}

	@Override
	public int getColumnCount() {

		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Danhmucthuoc dmt = ds.get(rowIndex);
		switch (columnIndex) {
		case 1:
			return dmt.getMadm();

		case 0:
			return dmt.getLoaithuoc();

		default:
			return null;
		}
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return header[column];
	}

}
