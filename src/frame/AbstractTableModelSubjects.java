package frame;

import javax.swing.table.AbstractTableModel;

import model.SubjectBase;



public class AbstractTableModelSubjects extends AbstractTableModel{

	public AbstractTableModelSubjects() {}

	//broj redova
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return SubjectBase.getInstance().getSubjects().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}
	
	//Nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return SubjectBase.getInstance().getColumnName(column);
	}

	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return SubjectBase.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
