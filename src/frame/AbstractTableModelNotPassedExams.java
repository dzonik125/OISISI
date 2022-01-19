package frame;

import javax.swing.table.AbstractTableModel;

import model.NotPassedExamsBase;

public class AbstractTableModelNotPassedExams extends AbstractTableModel {

	public AbstractTableModelNotPassedExams() {
	}

	// broj redova
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return NotPassedExamsBase.getInstance().getNotPassedExams().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	// Nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return NotPassedExamsBase.getInstance().getColumnName(column);
	}

	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return NotPassedExamsBase.getInstance().getValueAt(rowIndex, columnIndex);
	}
}