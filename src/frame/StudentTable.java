package frame;

import java.awt.Color;
import java.awt.Component;
import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class StudentTable extends JTable {

	public StudentTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudents());

		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.getModel());
		this.setRowSorter(sorter);
		sorter.setComparator(0, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String[] pts1 = o1.split("-");
				String[] pts2 = o2.split("-");

				if (pts1[0].compareTo(pts2[0]) == 0) {
					if (Integer.parseInt(pts1[2]) == Integer.parseInt(pts2[2])) {
						if (Integer.parseInt(pts1[1]) == Integer.parseInt(pts2[1])) {
							return 0;
						} else if (Integer.parseInt(pts1[1]) < Integer.parseInt(pts2[1])) {
							return -1;
						} else {
							return 1;
						}
					} else {
						if (Integer.parseInt(pts1[2]) < Integer.parseInt(pts2[2])) {
							return -1;
						} else {
							return 1;
						}
					}
				} else {
					return pts1[0].compareTo(pts2[0]);
				}
			}

		});
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}