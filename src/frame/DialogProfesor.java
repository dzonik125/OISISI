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

import controllers.StudentController;
import model.Adress;
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
		JLabel subject = new JLabel("Predmet");
		JLabel id = new JLabel("Broj licne karte");
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
		JTextField txtSubject = new JTextField();
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
		

		GridBagConstraints gbcSubject = new GridBagConstraints();
		gbcSubject.gridx = 0;
		gbcSubject.gridy = 10;
		gbcSubject.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(subject, gbcSubject);
		
		GridBagConstraints gbcOffice = new GridBagConstraints();
		gbcOffice.gridx = 0;
		gbcOffice.gridy = 11;
		gbcOffice.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(office, gbcOffice);
		
		GridBagConstraints gbcId = new GridBagConstraints();
		gbcId.gridx = 0;
		gbcId.gridy = 12;
		gbcId.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(id, gbcId);
		
		GridBagConstraints gbcTitle= new GridBagConstraints();
		gbcTitle.gridx = 0;
		gbcTitle.gridy = 13;
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
		
		
		GridBagConstraints gbcTxtSubject = new GridBagConstraints();
		gbcTxtSubject.gridx = 1;
		gbcTxtSubject.gridy = 10;
		gbcTxtSubject.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtSubject.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtSubject, gbcTxtSubject);
		
		
		GridBagConstraints gbcTxtOffice = new GridBagConstraints();
		 gbcTxtOffice .gridx = 1;
		 gbcTxtOffice .gridy = 11;
		 gbcTxtOffice .fill = GridBagConstraints.HORIZONTAL;
		 gbcTxtOffice .insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtOffice,  gbcTxtOffice );
		
		
		GridBagConstraints gbcTxtId = new GridBagConstraints();
		gbcTxtId  .gridx = 1;
		gbcTxtId  .gridy = 12;
		gbcTxtId .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtId  .insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtId,  gbcTxtId  );
		
		GridBagConstraints gbcTxtTitle = new GridBagConstraints();
		 gbcTxtTitle.gridx = 1;
		 gbcTxtTitle.gridy = 13;
		 gbcTxtTitle.fill = GridBagConstraints.HORIZONTAL;
		 gbcTxtTitle  .insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtTitle,  gbcTxtTitle  );
		
		
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Ime i prezime
				Pattern p = Pattern.compile("\\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+");
				Matcher m = p.matcher(txtName.getText());
				boolean b = m.matches();

				Pattern p1 = Pattern.compile("\\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+");
				Matcher m1 = p1.matcher(txtSurname.getText());
				boolean b1 = m1.matches();

				// Rodjendan
				Pattern p2 = Pattern.compile("^([0-2][0-9]|(3)[0-1])(\\.)(((0)[0-9])|((1)[0-2]))(\\.)\\d{4}(\\.)$");
				Matcher m2 = p2.matcher(txtBirthday.getText());
				boolean b2 = m2.matches();

				// Adresa(Ulica)
				Pattern p3 = Pattern.compile("[A-z]+\\s*[A-z]*\\s*[A-z]*\\s*");
				Matcher m3 = p3.matcher(txtAdress.getText());
				boolean b3 = m3.matches();
				
				//Broj ulice
				Pattern p4 = Pattern.compile("\\d+[A-z]*");
				Matcher m4 = p4.matcher(txtAdressNumber.getText());
				boolean b4 = m4.matches();
				
				//Grad
				Pattern p5 = Pattern.compile("[A-z]+\\s*[A-z]*");
				Matcher m5 = p5.matcher(txtAdressCity.getText());
				boolean b5 = m5.matches();
				
				//Drzava
				Pattern p6 = Pattern.compile("[A-z]+\\s*[A-z]*\\s*[A-z]*");
				Matcher m6 = p6.matcher(txtAdressState.getText());
				boolean b6 =m6.matches();
				
				// Broj telefona
				Pattern p7 = Pattern.compile("\\d{9,11}");
				Matcher m7 = p7.matcher(txtPhone.getText());
				boolean b7 = m7.matches();

				// Mejl
				Pattern p8 = Pattern.compile(
						"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\\\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\\\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
				Matcher m8 = p8.matcher(txtMail.getText());
				boolean b8 = m8.matches();

				// predmet
				Pattern p9 = Pattern.compile("[A-z]+\\s*[A-z]*\\s*[A-z]*");
				Matcher m9 = p9.matcher(txtSubject.getText());
				boolean b9 = m9.matches();

				// godina staza
				Pattern p10 = Pattern.compile("\\d{9,11}");
				Matcher m10= p10.matcher(txtInterShipYear.getText());
				boolean b10 = m10.matches();
				
				//id
				Pattern p11 = Pattern.compile("\\d{9,11}");
				Matcher m11 = p11.matcher(txtId.getText());
				boolean b11 = m11.matches();
				
				//office
				Pattern p12 = Pattern.compile("[A-z]+\\s*[A-z]*\\s*[A-z]*");
				Matcher m12 = p12.matcher(txtSubject.getText());
				boolean b12 = m12.matches();
	
				Pattern p13 = Pattern.compile("[A-z]+\\s*[A-z]*\\s*[A-z]*");
				Matcher m13 = p12.matcher(txtTitle.getText());
				boolean b13 = m12.matches();
				
			}
		});

		setVisible(true);
	}

}


		




		
		
			
		
		
		
		
		
		
		
		
		
		
	
		