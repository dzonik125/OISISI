package frame;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;

public class AbstractTableModelProfessors extends AbstractTableModel  {

	
	
	public AbstractTableModelProfessors() {
	}

	// broj redova
	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfessors().size();
	}
	
	// broj kolona
	@Override
	public int getColumnCount() {
		return 5;
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
