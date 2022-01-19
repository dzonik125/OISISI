package frame;

import javax.swing.table.AbstractTableModel;

import model.PassedExamsBase;
import model.StudentBase;

public class AbstractTableModelPassedExams extends AbstractTableModel{

	public AbstractTableModelPassedExams() {}

	//broj redova
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return PassedExamsBase.getInstance().getGrades().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}
	
	//Nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return PassedExamsBase.getInstance().getColumnName(column);
	}

	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return PassedExamsBase.getInstance().getValueAt(rowIndex, columnIndex);
	}
}