package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogStudent extends JDialog {

	public DialogStudent(MainFrame parent) {
		Dimension frameSize = parent.getSize();
		int frameHeight = frameSize.height;
		int frameWidth = frameSize.width;
		setSize(frameWidth / 2, frameHeight - 100);
		setLocationRelativeTo(parent);
		setTitle("Dodavanje studenta");
		setModal(true);

		JPanel bottomPanel = new JPanel();
		JButton confirm = new JButton("Potvrda");
		JButton abort = new JButton("Odustanak");

		bottomPanel.add(confirm);
		bottomPanel.add(abort);

		add(bottomPanel, BorderLayout.SOUTH);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridBagLayout());
		add(centerPanel, BorderLayout.NORTH);

		JLabel name = new JLabel("Ime*");
		JLabel surname = new JLabel("Prezime*");
		JLabel birthday = new JLabel("Datum rođenja*");
		JLabel adress = new JLabel("Adresa stanovanja* ");
		JLabel phone = new JLabel("Broj telefona* ");
		JLabel index = new JLabel("Broj indeksa* ");
		JLabel currentYear = new JLabel("Trenutna godina studija* ");
		JLabel mail = new JLabel("Email adresa*");
		JLabel enrollmentDate = new JLabel("Godina upisa*");
		JLabel stat = new JLabel("Način finansiranja*");

		JTextField txtName = new JTextField();
		JTextField txtSurname = new JTextField();
		JTextField txtBirthday = new JTextField();
		JTextField txtAdress = new JTextField();
		JTextField txtPhone = new JTextField();
		JTextField txtIndex = new JTextField();
		JTextField txtMail = new JTextField();
		JTextField txtEnrollmentDate = new JTextField();
		JTextField txtAvgGrade = new JTextField();

		GridBagConstraints gbcName = new GridBagConstraints();
		gbcName.gridx = 0;
		gbcName.gridy = 0;
		gbcName.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(name, gbcName);

		GridBagConstraints gbcSurname = new GridBagConstraints();
		gbcSurname.gridx = 0;
		gbcSurname.gridy = 1;
		gbcSurname.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(surname, gbcSurname);

		GridBagConstraints gbcBirthday = new GridBagConstraints();
		gbcBirthday.gridx = 0;
		gbcBirthday.gridy = 2;
		gbcBirthday.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(birthday, gbcBirthday);

		GridBagConstraints gbcAdress = new GridBagConstraints();
		gbcAdress.gridx = 0;
		gbcAdress.gridy = 3;
		gbcAdress.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(adress, gbcAdress);

		GridBagConstraints gbcPhone = new GridBagConstraints();
		gbcPhone.gridx = 0;
		gbcPhone.gridy = 4;
		gbcPhone.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(phone, gbcPhone);

		GridBagConstraints gbcMail = new GridBagConstraints();
		gbcMail.gridx = 0;
		gbcMail.gridy = 5;
		gbcMail.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(mail, gbcMail);
		
		GridBagConstraints gbcIndex = new GridBagConstraints();
		gbcIndex.gridx = 0;
		gbcIndex.gridy = 6;
		gbcIndex.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(index, gbcIndex);

		GridBagConstraints gbcEnrollmentDate = new GridBagConstraints();
		gbcEnrollmentDate.gridx = 0;
		gbcEnrollmentDate.gridy = 7;
		gbcEnrollmentDate.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(enrollmentDate, gbcEnrollmentDate);

		GridBagConstraints gbcCurrentYear = new GridBagConstraints();
		gbcCurrentYear.gridx = 0;
		gbcCurrentYear.gridy = 9;
		gbcCurrentYear.insets = new Insets(20, 10, 0, 0);
		centerPanel.add(currentYear, gbcCurrentYear);

		GridBagConstraints gbcStat = new GridBagConstraints();
		gbcStat.gridx = 0;
		gbcStat.gridy = 10;
		gbcStat.insets = new Insets(20, 10, 0, 0);
		centerPanel.add(stat, gbcStat);
		
		GridBagConstraints gbcTxtName = new GridBagConstraints();
		gbcTxtName.gridx = 1;
		gbcTxtName.gridy = 0;
		gbcTxtName.weightx = 0.5;
		gbcTxtName.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtName.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtName, gbcTxtName);

		GridBagConstraints gbcTxtSurname = new GridBagConstraints();
		gbcTxtSurname.gridx = 1;
		gbcTxtSurname.gridy = 1;
		;
		gbcTxtSurname.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtSurname.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtSurname, gbcTxtSurname);

		GridBagConstraints gbcTxtBirthday = new GridBagConstraints();
		gbcTxtBirthday.gridx = 1;
		gbcTxtBirthday.gridy = 2;
		gbcTxtBirthday.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtBirthday.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtBirthday, gbcTxtBirthday);

		GridBagConstraints gbcTxtAdress = new GridBagConstraints();
		gbcTxtAdress.gridx = 1;
		gbcTxtAdress.gridy = 3;
		gbcTxtAdress.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtAdress.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtAdress, gbcTxtAdress);

		GridBagConstraints gbcTxtPhone = new GridBagConstraints();
		gbcTxtPhone.gridx = 1;
		gbcTxtPhone.gridy = 4;
		gbcTxtPhone.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtPhone.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtPhone, gbcTxtPhone);
		
		GridBagConstraints gbcTxtMail = new GridBagConstraints();
		gbcTxtMail.gridx = 1;
		gbcTxtMail.gridy = 5;
		gbcTxtMail.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtMail.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtMail, gbcTxtMail);

		GridBagConstraints gbcTxtIndex = new GridBagConstraints();
		gbcTxtIndex.gridx = 1;
		gbcTxtIndex.gridy = 6;
		gbcTxtIndex.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtIndex.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtIndex, gbcTxtIndex);

		GridBagConstraints gbcTxtEnrollmentDate = new GridBagConstraints();
		gbcTxtEnrollmentDate.gridx = 1;
		gbcTxtEnrollmentDate.gridy = 7;
		gbcTxtEnrollmentDate.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtEnrollmentDate.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtEnrollmentDate, gbcTxtEnrollmentDate);

		String currYear[] = { "I (prva)", "II (druga)", "III (treća)", "IV (četvrta)" };
		JComboBox<String> cY = new JComboBox<>(currYear);

		GridBagConstraints gbcCY = new GridBagConstraints();
		gbcCY.gridx = 1;
		gbcCY.gridy = 9;
		gbcCY.fill = GridBagConstraints.HORIZONTAL;
		gbcCY.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(cY, gbcCY);

		String status[] = { "Budžet", "Samofinansiranje" };
		JComboBox<String> s = new JComboBox<>(status);

		GridBagConstraints gbcS = new GridBagConstraints();
		gbcS.gridx = 1;
		gbcS.gridy = 10;
		gbcS.fill = GridBagConstraints.HORIZONTAL;
		gbcS.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(s, gbcS);

		setVisible(true);
	}

}
