package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controllers.ProfessorController;
import controllers.StudentController;
import model.Adress;
import model.Professor;
import model.Student;
import model.StudentBase;

public class DialogProfesor extends JDialog {

	

	public DialogProfesor(MainFrame parent) {
		Dimension frameSize = parent.getSize();
		int frameHeight = frameSize.height;
		int frameWidth = frameSize.width;
		setSize(frameWidth / 2, frameHeight -10);
		setLocationRelativeTo(parent);
		setTitle("Dodavanje profesora");
		setModal(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		
		
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
		JLabel adress = new JLabel("Ulica stanovanja* ");
		JLabel adressNum = new JLabel("Broj ulice*");
		JLabel adressCity = new JLabel("Mesto*");
		JLabel adressState = new JLabel("Država*");
		JLabel phone = new JLabel("Broj telefona* ");
		JLabel office = new JLabel("Katedra* ");
		JLabel mail = new JLabel("Email adresa*");
		JLabel intershipyear = new JLabel("Godine rada*");
		JLabel id = new JLabel("Broj lične karte");
		JLabel title=new JLabel("Zvanje");
		

		JTextField txtName = new JTextField();
		JTextField txtSurname = new JTextField();
		JTextField txtBirthday = new JTextField();
		JTextField txtAdress = new JTextField();
		JTextField txtAdressNumber = new JTextField();
		JTextField txtAdressCity = new JTextField();
		JTextField txtAdressState = new JTextField();
		JTextField txtPhone = new JTextField();
		JTextField txtMail = new JTextField();
		JTextField txtInterShipYear = new JTextField();

		JTextField txtOffice = new JTextField();
		JTextField txtId = new JTextField();
		JTextField txtTitle= new JTextField();
		
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

		GridBagConstraints gbcAdressNumber = new GridBagConstraints();
		gbcAdressNumber.gridx = 0;
		gbcAdressNumber.gridy = 4;
		gbcAdressNumber.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(adressNum, gbcAdressNumber);

		GridBagConstraints gbcAdressCity = new GridBagConstraints();
		gbcAdressCity.gridx = 0;
		gbcAdressCity.gridy = 5;
		gbcAdressCity.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(adressCity, gbcAdressCity);

		GridBagConstraints gbcAdressState = new GridBagConstraints();
		gbcAdressState.gridx = 0;
		gbcAdressState.gridy = 6;
		gbcAdress.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(adressState, gbcAdressState);

		GridBagConstraints gbcPhone = new GridBagConstraints();
		gbcPhone.gridx = 0;
		gbcPhone.gridy = 7;
		gbcPhone.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(phone, gbcPhone);

		GridBagConstraints gbcMail = new GridBagConstraints();
		gbcMail.gridx = 0;
		gbcMail.gridy = 8;
		gbcMail.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(mail, gbcMail);

	

		GridBagConstraints gbcInterShipYear = new GridBagConstraints();
		gbcInterShipYear.gridx = 0;
		gbcInterShipYear.gridy = 9;
		gbcInterShipYear.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(intershipyear, gbcInterShipYear);
		

	
		
		GridBagConstraints gbcOffice = new GridBagConstraints();
		gbcOffice.gridx = 0;
		gbcOffice.gridy = 10;
		gbcOffice.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(office, gbcOffice);
		
		GridBagConstraints gbcId = new GridBagConstraints();
		gbcId.gridx = 0;
		gbcId.gridy = 11;
		gbcId.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(id, gbcId);
		
		GridBagConstraints gbcTitle= new GridBagConstraints();
		gbcTitle.gridx = 0;
		gbcTitle.gridy = 12;
		gbcTitle.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(title, gbcTitle);
		
		

		

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

		GridBagConstraints gbcTxtAdressNumber = new GridBagConstraints();
		gbcTxtAdressNumber.gridx = 1;
		gbcTxtAdressNumber.gridy = 4;
		gbcTxtAdressNumber.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtAdressNumber.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtAdressNumber, gbcTxtAdressNumber);

		GridBagConstraints gbcTxtAdressCity = new GridBagConstraints();
		gbcTxtAdressCity.gridx = 1;
		gbcTxtAdressCity.gridy = 5;
		gbcTxtAdressCity.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtAdressCity.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtAdressCity, gbcTxtAdressCity);

		GridBagConstraints gbcTxtAdressState = new GridBagConstraints();
		gbcTxtAdressState.gridx = 1;
		gbcTxtAdressState.gridy = 6;
		gbcTxtAdressState.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtAdressState.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtAdressState, gbcTxtAdressState);

		GridBagConstraints gbcTxtPhone = new GridBagConstraints();
		gbcTxtPhone.gridx = 1;
		gbcTxtPhone.gridy = 7;
		gbcTxtPhone.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtPhone.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtPhone, gbcTxtPhone);

		GridBagConstraints gbcTxtMail = new GridBagConstraints();
		gbcTxtMail.gridx = 1;
		gbcTxtMail.gridy = 8;
		gbcTxtMail.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtMail.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtMail, gbcTxtMail);

	

		GridBagConstraints gbcTxtInterShipYear = new GridBagConstraints();
		gbcTxtInterShipYear.gridx = 1;
		gbcTxtInterShipYear.gridy = 9;
		gbcTxtInterShipYear.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtInterShipYear.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtInterShipYear, gbcTxtInterShipYear);
		
		
	
		
		
		GridBagConstraints gbcTxtOffice = new GridBagConstraints();
		 gbcTxtOffice .gridx = 1;
		 gbcTxtOffice .gridy = 10;
		 gbcTxtOffice .fill = GridBagConstraints.HORIZONTAL;
		 gbcTxtOffice .insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtOffice,  gbcTxtOffice );
		
		
		GridBagConstraints gbcTxtId = new GridBagConstraints();
		gbcTxtId  .gridx = 1;
		gbcTxtId  .gridy = 11;
		gbcTxtId .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtId  .insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtId,  gbcTxtId  );
		
		GridBagConstraints gbcTxtTitle = new GridBagConstraints();
		 gbcTxtTitle.gridx = 1;
		 gbcTxtTitle.gridy = 12;
		 gbcTxtTitle.fill = GridBagConstraints.HORIZONTAL;
		 gbcTxtTitle  .insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtTitle,  gbcTxtTitle  );
		
		abort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				dispose();
			}

		});
		
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		
				SimpleDateFormat formatter1 = new SimpleDateFormat("dd.MM.yyyy.");
				Date dt = null;
				try {
					dt = formatter1.parse(txtBirthday.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Adress a = new Adress(txtAdress.getText(), txtAdressCity.getText(), txtAdressNumber.getText(), txtAdressState.getText()); // Laze Kostica 77, Kovilj
				Professor p = new Professor( txtName.getText(), txtSurname.getText(), dt, a, txtPhone.getText(), txtMail.getText(),txtOffice.getText(),
				txtId.getText(),txtTitle.getText(),Integer.valueOf(txtInterShipYear.getText()));
				ProfessorController.getInstance().addProfessor(p);
				dispose();
			}
		});
		setVisible(true);
	

}
}


		




		
		
			
		
		
		
		
		
		
		
		
		
		
	
		