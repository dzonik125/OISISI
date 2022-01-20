package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controllers.ProfessorController;
import controllers.StudentController;
import controllers.SubjectController;

public class DeleteSubject extends JDialog {

	public DeleteSubject(JFrame parent) {
		Dimension frameSize = parent.getSize();
		int frameHeight = frameSize.height;
		int frameWidth = frameSize.width;
		setSize(frameWidth / 3, frameHeight / 3);
		setLocationRelativeTo(parent);
		setTitle("Brisanje studenta");
		setModal(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		JPanel upper = new JPanel();
		this.add(upper, BorderLayout.NORTH);
		JLabel sure = new JLabel("Da li ste sigurni da želite da obrišete predmet?");
		sure.setBorder(new EmptyBorder(20, 0, 0, 0));
		upper.add(sure);

		JPanel lower = new JPanel();
		lower.setBorder(new EmptyBorder(0, 0, 20, 0));
		this.add(lower, BorderLayout.SOUTH);
		JButton yes = new JButton("Da");
		JButton no = new JButton("Ne");
		lower.add(yes, FlowLayout.LEFT);
		lower.add(no);

		yes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SubjectController.getInstance().deleteSubject(MainFrame.getInstance().subjectTable.getSelectedRow());
				dispose();
			}

		});

		no.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {
				dispose();

			}

		});

		setVisible(true);
	}

}
