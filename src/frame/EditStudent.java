package frame;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controllers.StudentController;
import model.Adress;
import model.Student;
import model.StudentBase;
import model.Subject;
import model.SubjectBase;

public class EditStudent extends JDialog {

	private Student.Status stats;
	private int yr;
	public JTable passedExamsTable;
	public JTable notPassedExamsTable;
	private JList available;

	public EditStudent(JFrame parent) {
		Dimension frameSize = parent.getSize();
		int frameHeight = frameSize.height;
		int frameWidth = frameSize.width;
		setSize(frameWidth / 2, frameHeight - 30);
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

		JPanel passedPanel = new JPanel();
		passedPanel.setLayout(new BorderLayout());
//		passedPanel.setLayout(new GridBagLayout());
		JTabbedPane tp = new JTabbedPane();
		add(tp);
		passedExamsTable = new PassedExamsTable();
		JScrollPane scrollPane = new JScrollPane(passedExamsTable);
		JButton cancelGrade = new JButton();
		cancelGrade.setText("PoniÅ¡ti ocenu");
		JLabel averageGrade = new JLabel("ProseÄ�na ocena:");
		JLabel summESPB = new JLabel("Ukupno ESPB:");
		scrollPane.setPreferredSize(new Dimension(500, 500));
		JPanel ttt = new JPanel();
		ttt.setLayout(new FlowLayout());
		ttt.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		ttt.add(cancelGrade, FlowLayout.LEFT);
		JPanel bbb = new JPanel();
		bbb.setLayout(new GridBagLayout());
		
		GridBagConstraints gbcAverageGrade = new GridBagConstraints();
		gbcAverageGrade.gridx = 0;
		gbcAverageGrade.gridy = 0;
		gbcAverageGrade.insets = new Insets(10, 250, 0, 0);
		bbb.add(averageGrade, gbcAverageGrade);
		
		GridBagConstraints gbcSumESPB = new GridBagConstraints();
		gbcSumESPB.gridx = 0;
		gbcSumESPB.gridy = 1;
		gbcSumESPB.insets = new Insets(5, 250, 0, 0);
		bbb.add(summESPB, gbcSumESPB);
		

//		GridBagConstraints gbcCancelGrade = new GridBagConstraints();
//		gbcCancelGrade.gridx = 0;
//		gbcCancelGrade.gridy = 0;
//		gbcCancelGrade.insets = new Insets(0, 0, 15, 300);
//		passedPanel.add(cancelGrade, gbcCancelGrade);

//		GridBagConstraints gbcTable = new GridBagConstraints();
//		gbcTable.gridx = 0;
//		gbcTable.gridy = 1;
//		gbcTable.insets = new Insets(0, 0, 0, 0);
		passedPanel.add(scrollPane, BorderLayout.CENTER);
		passedPanel.add(ttt, BorderLayout.NORTH);
		passedPanel.add(bbb, BorderLayout.SOUTH);

//		GridBagConstraints gbcAverageGrade = new GridBagConstraints();
//		gbcAverageGrade.gridx = 0;
//		gbcAverageGrade.gridy = 2;
//		gbcAverageGrade.insets = new Insets(15, 200, 0, 0);
//		passedPanel.add(averageGrade, gbcAverageGrade);
//
//		GridBagConstraints gbcSummESPB = new GridBagConstraints();
//		gbcSummESPB.gridx = 0;
//		gbcSummESPB.gridy = 3;
//		gbcSummESPB.insets = new Insets(10, 200, 0, 0);
//		passedPanel.add(summESPB, gbcSummESPB);

		JPanel notPassedPanel = new JPanel();
		notPassedPanel.setLayout(new GridBagLayout());
		notPassedExamsTable = new NotPassedExamsTable();
		JScrollPane scrollPane1 = new JScrollPane(notPassedExamsTable);
		JButton addExam = new JButton();
		addExam.setText("Dodaj");
		JButton deleteExam = new JButton();
		deleteExam.setText("ObriÅ¡i");
		JButton tryExam = new JButton();
		tryExam.setText("Polaganje");
		scrollPane1.setPreferredSize(new Dimension(500, 500));

		JPanel npTop = new JPanel();
		npTop.setLayout(new FlowLayout());
		npTop.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		npTop.add(addExam);
		npTop.add(deleteExam);
		npTop.add(tryExam);

		GridBagConstraints gbcPanel = new GridBagConstraints();
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		gbcPanel.weightx = 1.0;
		notPassedPanel.add(npTop, gbcPanel);

		GridBagConstraints gbcTable1 = new GridBagConstraints();
		gbcTable1.gridx = 0;
		gbcTable1.gridy = 1;
		gbcTable1.weightx = 1.0;
		gbcTable1.weighty = 1.0;
		gbcTable1.insets = new Insets(0, 0, 0, 0);
		notPassedPanel.add(scrollPane1, gbcTable1);

		Student st = StudentBase.getInstance().getStudents().get(MainFrame.getInstance().studentTable.convertRowIndexToModel(MainFrame.getInstance().getDataFromSelectedRow()));
		List<Subject> subb = new ArrayList<Subject>();
		subb.add(new Subject());
		subb.add(new Subject());

		addExam.addActionListener(new ActionListener() {

			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog addSubj = new JDialog();
				addSubj.setModal(true);
				addSubj.setTitle("Dodavanje predmeta");
				Dimension frameSize3 = parent.getSize();
				int frameHeight3 = frameSize3.height / 3;
				int frameWidth3 = frameSize3.width / 3;
				addSubj.setSize(frameWidth3, frameHeight3);
				addSubj.setLocationRelativeTo(null);
				addSubj.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				boolean passed = true;
				addSubj.setLayout(new BorderLayout());

				List<String> data = new ArrayList<String>();
				data.add("Å ifra" + " Naziv");
				data.add(" ");
				for (Subject sbt : SubjectBase.getInstance().getSubjects()) {
					if (sbt.getStudyYear() <= st.getCurrentStudyYear()) {
						for (int i = 0; i < st.getGradeList().size(); i++) {
							if (sbt.getSubjectID() != st.getGradeList().get(i).getSubject().getSubjectID()) {
								passed = true;
							} else {
								passed = false;
							}
							if (passed == false) {
								break;
							}
						}
						for (int j = 0; j < st.getNotPassed().size(); j++) {
							if (sbt.getSubjectID() != st.getNotPassed().get(j).getSubjectID()) {
								passed = true;
							} else {
								passed = false;
							}
							if (passed == false) {
								break;
							}
						}
					} else {
						passed = false;
					}
					if (passed) {
						String first = String.valueOf(sbt.getSubjectID());
						String second = sbt.getSubjectName();
						String fise = first.concat(" ").concat(second);
						data.add(fise);
						subb.add(sbt);
					}
				}

				available = new JList(data.toArray());
				available.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				addSubj.add(available, BorderLayout.CENTER);
				JPanel bot = new JPanel();
				addSubj.add(bot, BorderLayout.SOUTH);
				bot.setLayout(new FlowLayout());
				bot.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				JButton conf = new JButton("Dodaj");
				JButton abor = new JButton("Odustani");
				bot.add(conf);
				bot.add(abor);
				conf.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						// METODA ZA DODAVANJE PREDMETA U NEPOLOZENE
						Subject subjc = new Subject();
						subjc = subb.get(available.getSelectedIndex());
						StudentController.getInstance().addSubjectToNotPassed(st, subjc);
						refresh();
						addSubj.dispose();
					}

				});
				abor.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						addSubj.dispose();
					}

				});

				addSubj.setVisible(true);
			}
		});
		
		deleteExam.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(available != null) {
					StudentController.getInstance().deleteExam(available.getSelectedIndex(), (subb.get(available.getSelectedIndex()).getSubjectID()));

					refresh();					
				}
			}
			
		});

		tp.addTab("Informacije", centerPanel);
		tp.addTab("PoloÅ¾eni", passedPanel);
		tp.addTab("NepoloÅ¾eni", notPassedPanel);

		JLabel name = new JLabel("Ime*");
		JLabel surname = new JLabel("Prezime*");
		JLabel birthday = new JLabel("Datum roÄ‘enja*");
		JLabel adress = new JLabel("Ulica stanovanja* ");
		JLabel adressNum = new JLabel("Broj ulice*");
		JLabel adressCity = new JLabel("Mesto*");
		JLabel adressState = new JLabel("DrÅ¾ava*");
		JLabel phone = new JLabel("Broj telefona* ");
		JLabel index = new JLabel("Broj indeksa* ");
		JLabel currentYear = new JLabel("Trenutna godina studija* ");
		JLabel mail = new JLabel("Email adresa*");
		JLabel enrollmentDate = new JLabel("Godina upisa*");
		JLabel stat = new JLabel("NaÄ�in finansiranja*");

		JTextField txtName = new JTextField();
		JTextField txtSurname = new JTextField();
		JTextField txtBirthday = new JTextField();
		JTextField txtAdress = new JTextField();
		JTextField txtAdressNumber = new JTextField();
		JTextField txtAdressCity = new JTextField();
		JTextField txtAdressState = new JTextField();
		JTextField txtPhone = new JTextField();
		JTextField txtIndex = new JTextField();
		JTextField txtMail = new JTextField();
		JTextField txtEnrollmentDate = new JTextField();

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

		GridBagConstraints gbcIndex = new GridBagConstraints();
		gbcIndex.gridx = 0;
		gbcIndex.gridy = 9;
		gbcIndex.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(index, gbcIndex);

		GridBagConstraints gbcEnrollmentDate = new GridBagConstraints();
		gbcEnrollmentDate.gridx = 0;
		gbcEnrollmentDate.gridy = 10;
		gbcEnrollmentDate.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(enrollmentDate, gbcEnrollmentDate);

		GridBagConstraints gbcCurrentYear = new GridBagConstraints();
		gbcCurrentYear.gridx = 0;
		gbcCurrentYear.gridy = 11;
		gbcCurrentYear.insets = new Insets(20, 10, 0, 0);
		centerPanel.add(currentYear, gbcCurrentYear);

		GridBagConstraints gbcStat = new GridBagConstraints();
		gbcStat.gridx = 0;
		gbcStat.gridy = 12;
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

		GridBagConstraints gbcTxtIndex = new GridBagConstraints();
		gbcTxtIndex.gridx = 1;
		gbcTxtIndex.gridy = 9;
		gbcTxtIndex.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtIndex.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtIndex, gbcTxtIndex);

		GridBagConstraints gbcTxtEnrollmentDate = new GridBagConstraints();
		gbcTxtEnrollmentDate.gridx = 1;
		gbcTxtEnrollmentDate.gridy = 10;
		gbcTxtEnrollmentDate.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtEnrollmentDate.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtEnrollmentDate, gbcTxtEnrollmentDate);

		String currYear[] = { "I (prva)", "II (druga)", "III (treÄ‡a)", "IV (Ä�etvrta)" };
		JComboBox<String> cY = new JComboBox<>(currYear);

		GridBagConstraints gbcCY = new GridBagConstraints();
		gbcCY.gridx = 1;
		gbcCY.gridy = 11;
		gbcCY.fill = GridBagConstraints.HORIZONTAL;
		gbcCY.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(cY, gbcCY);

		String status[] = { "BudÅ¾et", "Samofinansiranje" };
		JComboBox<String> s = new JComboBox<>(status);

		GridBagConstraints gbcS = new GridBagConstraints();
		gbcS.gridx = 1;
		gbcS.gridy = 12;
		gbcS.fill = GridBagConstraints.HORIZONTAL;
		gbcS.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(s, gbcS);

		abort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				dispose();
			}
		});

		txtName.setText(st.getName());
		txtSurname.setText(st.getSurname());
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd.MM.yyyy.");
		String dt = formatter1.format(st.getBirthDate());
		txtBirthday.setText(dt);
		txtAdress.setText(st.getAdress().getStreet().toString());
		txtAdressNumber.setText(st.getAdress().getNumber());
		txtAdressCity.setText(st.getAdress().getCity());
		txtAdressState.setText(st.getAdress().getState());
		txtPhone.setText(st.getContact());
		txtMail.setText(st.getMail());
		txtIndex.setText(st.getIndex());
		String check = st.getIndex();
		txtEnrollmentDate.setText(String.valueOf(st.getEnrollmentYear()));
		if (st.getStatus() == Student.Status.B) {
			s.setSelectedItem("BudÅ¾et");
		} else {
			s.setSelectedItem("Samofinansiranje");
		}
		if (st.getCurrentStudyYear() == 1) {
			cY.setSelectedIndex(0);
		} else if (st.getCurrentStudyYear() == 2) {
			cY.setSelectedIndex(1);
		} else if (st.getCurrentStudyYear() == 3) {
			cY.setSelectedIndex(2);
		} else if (st.getCurrentStudyYear() == 4) {
			cY.setSelectedIndex(3);
		}

		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Ime i prezime
				Pattern p = Pattern.compile("\\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+");
				Matcher m = p.matcher(txtName.getText());
				boolean b = m.matches();

				Pattern p1 = Pattern.compile("\\b([A-ZÃ€-Ã¿][-,a-z. ']+[ ]*)+");
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

				// Broj ulice
				Pattern p8 = Pattern.compile("\\d+[A-z]*");
				Matcher m8 = p8.matcher(txtAdressNumber.getText());
				boolean b8 = m8.matches();

				// Grad
				Pattern p9 = Pattern.compile("[A-z]+\\s*[A-z]*");
				Matcher m9 = p9.matcher(txtAdressCity.getText());
				boolean b9 = m9.matches();

				// Drzava
				Pattern p10 = Pattern.compile("[A-z]+\\s*[A-z]*\\s*[A-z]*");
				Matcher m10 = p10.matcher(txtAdressState.getText());
				boolean b10 = m10.matches();

				// Broj telefona
				Pattern p4 = Pattern.compile("\\d{9,11}");
				Matcher m4 = p4.matcher(txtPhone.getText());
				boolean b4 = m4.matches();

				// Mejl
				Pattern p5 = Pattern.compile(
						"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\\\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\\\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
				Matcher m5 = p5.matcher(txtMail.getText());
				boolean b5 = m5.matches();

				// Broj indeksa
				Pattern p6 = Pattern.compile("[a-z]{2,4}(\\-)\\d{1,3}(\\-)\\d{4}");
				Matcher m6 = p6.matcher(txtIndex.getText());
				boolean b6 = m6.matches();

				// Datum upisa
				Pattern p7 = Pattern.compile("\\d{4}");
				Matcher m7 = p7.matcher(txtEnrollmentDate.getText());
				boolean b7 = m7.matches();

				// Provera indeksa
				boolean sameIndex = false;
				for (Student std : StudentBase.getInstance().getStudents()) {
					if (std.getIndex().equals(txtIndex.getText())) {
						if (std.getIndex().equals(check)) {
							sameIndex = false;
						} else {
							sameIndex = true;
						}
					}
				}

				if (b & b1 & b2 & b3 & b4 & b5 & b6 & b7 & b8 & b9 & b10 & !sameIndex) {
					double d = 0.0;
					String status = s.getSelectedItem().toString();
					if (status.equals("BudÅ¾et")) {
						stats = Student.Status.B;
					} else {
						stats = Student.Status.S;
					}

					String year = cY.getSelectedItem().toString();
					if (year.equals("I (prva)")) {
						yr = 1;
					} else if (year.equals("II (druga)")) {
						yr = 2;
					} else if (year.equals("III (treÄ‡a)")) {
						yr = 3;
					} else if (year.equals("IV (Ä�etvrta)")) {
						yr = 4;
					}
					float f = (float) d;
					SimpleDateFormat formatter1 = new SimpleDateFormat("dd.MM.yyyy.");
					Date dt = null;
					try {
						dt = formatter1.parse(txtBirthday.getText());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Adress a = new Adress(txtAdress.getText(), txtAdressCity.getText(), txtAdressNumber.getText(),
							txtAdressState.getText());
					Student s = new Student(txtIndex.getText(), txtName.getText(), txtSurname.getText(), dt, a, yr,
							stats, f, txtPhone.getText(), txtMail.getText(),
							Integer.valueOf(txtEnrollmentDate.getText()));
					StudentController.getInstance().editStudent(MainFrame.getInstance().studentTable.getSelectedRow(),
							s);
					dispose();
				} else {
					JDialog error = new JDialog();
					error.setModal(true);
					error.setTitle("GREÅ KA");
					Dimension frameSize2 = parent.getSize();
					int frameHeight2 = frameSize2.height / 3;
					int frameWidth2 = frameSize.width / 3;
					error.setSize(frameWidth2, frameHeight2);
					error.setLocationRelativeTo(null);
					error.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					JLabel err = new JLabel("Niste uneli odgovarajuÄ‡e vrednosti ili ste uneli veÄ‡ postojeÄ‡i indeks!");
					JPanel up = new JPanel();
					up.setBorder(new EmptyBorder(20, 0, 0, 0));
					up.add(err);
					error.add(up, BorderLayout.NORTH);
					JButton ok = new JButton("Potvrdi");
					JPanel down = new JPanel();
					down.add(ok);
					error.add(down, BorderLayout.SOUTH);
					ok.addActionListener(new ActionListener() {
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

	public JTable getNotPassedExamsTable() {
		return notPassedExamsTable;
	}	

	public void refresh() {
		AbstractTableModelNotPassedExams model = (AbstractTableModelNotPassedExams)notPassedExamsTable.getModel();
		model.fireTableDataChanged();
		validate();
		notPassedExamsTable.repaint();
	}
	
}