package tier_giaodien;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entitys.Nhacungcap;
import tier_DAO.Nhacungcap_DAO;

public class tablenccmodel extends AbstractTableModel{
	String header[] = {"Mã" ,"Tên" ,"Địa Chỉ"};
	Nhacungcap_DAO dao = new Nhacungcap_DAO();
	ArrayList<Nhacungcap> ds = dao.getdatafromnhacungcap();

	public tablenccmodel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public tablenccmodel(ArrayList<Nhacungcap> ds) {
		super();
		this.ds = ds;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return ds.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Nhacungcap ncc = ds.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return ncc.getMa();
			
case 1:
			return ncc.getTen();
		
case 2:
	return ncc.getDiachi();


		default:
			break;
		}
		return null;
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
	@Override
	public String getColumnName(int column) {
		
		return header[column];
	}
}
