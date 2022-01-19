package frame;

import javax.swing.table.AbstractTableModel;

import model.Student;
import model.StudentBase;

public class AbstractTableModelPassedExams extends AbstractTableModel{

	public AbstractTableModelPassedExams() {}

	//broj redova
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		Student st = new Student(StudentBase.getInstance().getRow(MainFrame.getInstance().getDataFromSelectedRow()));
		return StudentBase.getInstance().getGrades(st).size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}
	
	//Nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return StudentBase.getInstance().getColumnName1(column);
	}

	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return StudentBase.getInstance().getValueAt1(rowIndex, columnIndex);
	}
}