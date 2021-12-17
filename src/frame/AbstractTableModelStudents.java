package frame;

import javax.swing.table.AbstractTableModel;

import model.StudentBase;

public class AbstractTableModelStudents extends AbstractTableModel{

	public AbstractTableModelStudents() {}

	//broj redova
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//Nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return StudentBase.getInstance().getColumnName(column);
	}

	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return StudentBase.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
