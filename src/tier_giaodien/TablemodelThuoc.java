package tier_giaodien;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entitys.Thuoc;
import tier_DAO.Thuoc_DAO;

public class TablemodelThuoc extends AbstractTableModel {

	String header[] = { "Mã Thuốc", "Tên Thuốc", "Đơn Vị", "Đơn Giá", "Mã Nhà Cung Cấp", "Mã Loại Thuốc",
			"Hạn Sử Dụng" };
	Thuoc_DAO ql = new Thuoc_DAO();

	ArrayList<Thuoc> ds = ql.getdatafromThuoctable();
	
	


	public TablemodelThuoc() {
		super();
	}

	public TablemodelThuoc(ArrayList<Thuoc> ds) {
		super();
		this.ds = ds;
	}

	public Thuoc_DAO getQl() {
		return ql;
	}

	public void setQl(Thuoc_DAO ql) {
		this.ql = ql;
	}

	public ArrayList<Thuoc> getDs() {
		return ds;
	}

	public void setDs(ArrayList<Thuoc> ds) {
		this.ds = ds;
	}

	@Override
	public int getColumnCount() {

		return header.length;
	}

	@Override
	public int getRowCount() {

		return ds.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Thuoc t = ds.get(row);
		switch (col) {
		case 0:
			return t.getMa();
		case 1:
			return t.getTenthuoc();
			
		case 2:
			return t.getDonvi();
		
		case 3:
			return t.getDongia();
		
		case 4:
			return t.getNhacungcap().getMa();
		
		case 5:
			return t.getDmt().getMadm();
			
		case 6:
			return t.getHansudung();
			

		default:
			break;
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {

		return header[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 3)
			return double.class;
		if (columnIndex == 6)
			return LocalDate.class;
		return String.class;
	}
	
}
