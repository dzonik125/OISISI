package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class EditStudent extends JDialog {

	public EditStudent(JFrame parent) {
		Dimension frameSize = parent.getSize();
		int frameHeight = frameSize.height;
		int frameWidth = frameSize.width;
		setSize(frameWidth / 2, frameHeight - 100);
		setLocationRelativeTo(parent);
		setTitle("Izmena studenta");
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
		
		JTabbedPane tp = new JTabbedPane();
		add(tp);
		tp.addTab("Informacije", centerPanel);
		tp.addTab("Položeni", new JPanel());
		tp.addTab("Nepoloženi", new JPanel());
		

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

		txtName.setName("txtName");
		txtSurname.setName("txtSurname");
		txtBirthday.setName("txtBirthday");
		txtAdress.setName("txtAdress");
		txtPhone.setName("txtPhone");
		txtIndex.setName("txtIndex");
		txtMail.setName("txtMail");
		txtEnrollmentDate.setName("txtEnrollmentDate");

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

		abort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				dispose();
			}
		});
		//Ime i prezime
		Pattern p = Pattern.compile("\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+");
		Matcher m = p.matcher(txtName.getText());
		boolean b = m.matches();
		
		Pattern p1 = Pattern.compile("\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+");
		Matcher m1 = p1.matcher(txtSurname.getText());
		boolean b1 = m1.matches();
		//Rodjendan
		Pattern p2 = Pattern.compile("^([0-2][0-9]|(3)[0-1])(\\.)(((0)[0-9])|((1)[0-2]))(\\.)\\d{4}(\\.)$");
		Matcher m2 = p2.matcher(txtBirthday.getText());
		boolean b2 = m2.matches();
		//Adresa
		Pattern p3 = Pattern.compile("^([A-ZÄÖÜ][a-zäöüß]+(([.] )|( )|([-])))+[1-9][0-9]{0,3}[a-z]?(\\,)\\s[a-z]+\\s[a-z]+$");
		Matcher m3 = p3.matcher(txtAdress.getText());
		boolean b3 = m3.matches();
		//Broj telefona
		Pattern p4 = Pattern.compile("\\d{9,11}");
		Matcher m4 = p4.matcher(txtAdress.getText());
		boolean b4 = m4.matches();
		//Broj indeksa
		Pattern p5 = Pattern.compile("[a-z]{2,4}(\\-)\\d{1,3}(\\-)\\d{4}");
		Matcher m5 = p5.matcher(txtAdress.getText());
		boolean b5 = m5.matches();
		//Mejl
		Pattern p6 = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\\\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\\\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
		Matcher m6 = p6.matcher(txtAdress.getText());
		boolean b6 = m6.matches();
		//Datum upisa
		Pattern p7 = Pattern.compile("\\d{4}");
		Matcher m7 = p7.matcher(txtAdress.getText());
		boolean b7 = m7.matches();
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(b);
				if (b & b1 & b2 & b3 & b4 & b5 & b6 & b7) {
					dispose();
				} else {
					JDialog error = new JDialog();
					error.setModal(true);
					error.setTitle("GREŠKA");
					Dimension frameSize2 = parent.getSize();
					int frameHeight2 = frameSize2.height / 3;
					int frameWidth2 = frameSize.width / 3;
					error.setSize(frameWidth2, frameHeight2);
					error.setLocationRelativeTo(null);
					error.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					JLabel err = new JLabel("Niste uneli odgovarajuće vrednosti!");
					JPanel up = new JPanel();
					up.setBorder(new EmptyBorder(20, 0, 0, 0));
					up.add(err);
					error.add(up, BorderLayout.NORTH);
					JButton ok = new JButton("Potvrdi");
					JPanel down = new JPanel();
					down.add(ok);
					error.add(down, BorderLayout.SOUTH);
					ok.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							error.dispose();
						}
					});
					error.setVisible(true);
				}
			}
		});
		setVisible(true);
	}

}
