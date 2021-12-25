package frame;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;

public class AbstractTableModelProfessors extends AbstractTableModel  {

	
	
	public AbstractTableModelProfessors() {
	}

	// broj redova
	@Override
	public int getRowCount() {
		return 10;
	}
	
	// broj kolona
	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount();
	}

	// nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnName(column);
	}
	
	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
	}


}
