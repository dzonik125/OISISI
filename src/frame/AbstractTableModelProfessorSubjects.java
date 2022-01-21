package frame;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;
import model.Professor;
import model.Student;
import model.StudentBase;

public class AbstractTableModelProfessorSubjects extends AbstractTableModel {

	public AbstractTableModelProfessorSubjects() {}

	// broj redova
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		Professor p = BazaProfesora.getInstance().getRow(MainFrame.getInstance().getDataFromSelectedRow2());
		return BazaProfesora.getInstance().getProfessorSubject(p).size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	// Nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnName1(column);
	}

	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getValueAt1(rowIndex, columnIndex);
	}
}