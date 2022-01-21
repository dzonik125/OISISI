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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controllers.ProfessorController;
import controllers.SubjectController;
import model.BazaProfesora;
import model.Professor;
import model.Student;
import model.StudentBase;
import model.Subject;
import model.SubjectBase;

public class EditSubject extends JDialog {
	
	private JList available;

	private Subject.Semester semms;
	private int yr;

	public EditSubject(MainFrame parent) {
		Subject sb=SubjectBase.getInstance().getSubjects().get(MainFrame.getInstance().subjectTable.convertRowIndexToModel(MainFrame.getInstance().getDataFromSelectedRow1()));
		Dimension frameSize = parent.getSize();
		int frameHeight = frameSize.height;
		int frameWidth = frameSize.width;
		setSize(frameWidth / 2, frameHeight / 2);
		setLocationRelativeTo(parent);
		setTitle("Izmena predmeta");
		setModal(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		JButton addProfesor=new JButton("+");
		JButton deleteProfesor= new JButton("-");
		
		JPanel bottomPanel = new JPanel();
		JButton confirm = new JButton("Potvrda");
		JButton abort = new JButton("Odustanak");

		bottomPanel.add(confirm);
		bottomPanel.add(abort);
		bottomPanel.add(addProfesor);
		bottomPanel.add(deleteProfesor);

		add(bottomPanel, BorderLayout.SOUTH);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridBagLayout());
		add(centerPanel, BorderLayout.NORTH);
		List<Professor> subb = new ArrayList<Professor>();
		subb.add(new Professor());
		subb.add(new Professor());
		
		JTextField txtName = new JTextField();
		JTextField txtScode = new JTextField();
		JTextField txtYr = new JTextField();
		JTextField txtEspb = new JTextField();
		JTextField txtProfesor= new JTextField();
		

		
	addProfesor.addActionListener(new ActionListener() {
		

	public void actionPerformed(ActionEvent e) {
		
		JDialog addProf= new JDialog();
		addProf.setModal(true);
		addProf.setTitle("Odaberi profesora");
		Dimension frameSize3=parent.getSize();
		int frameHeight3=frameSize.height/3;
		int frameWidth3 = frameSize3.width / 3;
		addProf.setSize(frameWidth3, frameHeight3);
		addProf.setLocationRelativeTo(null);
		addProf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		boolean passed = true;
		addProf.setLayout(new BorderLayout());
		
		List<String> data = new ArrayList<String>();
		data.add("Profesori:");
		data.add(" ");
		
		
		for (Professor prf : BazaProfesora.getInstance().getProfessors()) {
			if (SubjectBase.getInstance().getSubjects().get(MainFrame.getInstance().subjectTable.convertRowIndexToModel(MainFrame.getInstance().getDataFromSelectedRow1())).getSubjectProfessor()==prf) {
				passed = false;
			} else {
				passed = true;
			}
			if (passed) {
		
				String first = prf.getName();
				String second= prf.getSurname();
				String fise = first.concat(" ").concat(second);
				data.add(fise);
				subb.add(prf);
			}
		}
		
		available = new JList(data.toArray());
		available.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		addProf.add(available, BorderLayout.CENTER);
		JPanel bot = new JPanel();
		addProf.add(bot, BorderLayout.SOUTH);
		bot.setLayout(new FlowLayout());
		bot.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JButton conf = new JButton("Potvrdi");
		JButton abor = new JButton("Odustani");
		bot.add(conf);
		bot.add(abor);
		
		conf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Professor prof = new Professor();
				int index = available.getSelectedIndex();
				prof = subb.get(available.getSelectedIndex());
				subb.remove(index);
				SubjectController.getInstance().addProfessorToSubject(SubjectBase.getInstance().getSubjects().get(MainFrame.getInstance().subjectTable.convertRowIndexToModel(MainFrame.getInstance().getDataFromSelectedRow1())), prof);
				txtProfesor.setText(String.valueOf(SubjectBase.getInstance().getSubjects().get(MainFrame.getInstance().subjectTable.convertRowIndexToModel(MainFrame.getInstance().getDataFromSelectedRow1())).getSubjectProfessor().getName().concat(" ").concat(sb.getSubjectProfessor().getSurname())));
				System.out.print(SubjectBase.getInstance().getSubjects().get(MainFrame.getInstance().subjectTable.convertRowIndexToModel(MainFrame.getInstance().getDataFromSelectedRow1())).getSubjectProfessor().getName());
				addProf.dispose();
			}
			
		});
		
		abor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addProf.dispose();
			}

		});
		
		addProf.setVisible(true);
		
	}
			
	});	
	
	deleteProfesor.addActionListener(new ActionListener() {
		

		public void actionPerformed(ActionEvent e) {
			
			JDialog addProf= new JDialog();
			addProf.setModal(true);
			addProf.setTitle("Odaberi profesora");
			Dimension frameSize3=parent.getSize();
			int frameHeight3=frameSize.height/3;
			int frameWidth3 = frameSize3.width / 3;
			addProf.setSize(frameWidth3, frameHeight3);
			addProf.setLocationRelativeTo(null);
			addProf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			boolean passed = true;
			addProf.setLayout(new BorderLayout());
			
			List<String> data = new ArrayList<String>();
			data.add("Profesori:");
			data.add(" ");
			
			
			for (Professor prf : BazaProfesora.getInstance().getProfessors()) {
				if (SubjectBase.getInstance().getSubjects().get(MainFrame.getInstance().subjectTable.convertRowIndexToModel(MainFrame.getInstance().getDataFromSelectedRow1())).getSubjectProfessor()==prf) {
					passed = false;
				} else {
					passed = true;
				}
				if (passed) {
			
					String first = prf.getName();
					String second= prf.getSurname();
					String fise = first.concat(" ").concat(second);
					data.add(fise);
					subb.add(prf);
				}
			}
			
			available = new JList(data.toArray());
			available.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			addProf.add(available, BorderLayout.CENTER);
			JPanel bot = new JPanel();
			addProf.add(bot, BorderLayout.SOUTH);
			bot.setLayout(new FlowLayout());
			bot.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			JButton conf = new JButton("Potvrdi");
			JButton abor = new JButton("Odustani");
			bot.add(conf);
			bot.add(abor);
			
			conf.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Professor prof = new Professor();
					int index = available.getSelectedIndex();
					prof = subb.get(available.getSelectedIndex());
					subb.remove(index);
					SubjectController.getInstance().addProfessorToSubject(SubjectBase.getInstance().getSubjects().get(MainFrame.getInstance().subjectTable.convertRowIndexToModel(MainFrame.getInstance().getDataFromSelectedRow1())), prof);
					txtProfesor.setText(String.valueOf(SubjectBase.getInstance().getSubjects().get(MainFrame.getInstance().subjectTable.convertRowIndexToModel(MainFrame.getInstance().getDataFromSelectedRow1())).getSubjectProfessor().getName().concat(" ").concat(sb.getSubjectProfessor().getSurname())));
					System.out.print(SubjectBase.getInstance().getSubjects().get(MainFrame.getInstance().subjectTable.convertRowIndexToModel(MainFrame.getInstance().getDataFromSelectedRow1())).getSubjectProfessor().getName());
					addProf.dispose();
				}
				
			});
			
			abor.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					addProf.dispose();
				}

			});
			
			addProf.setVisible(true);
			
		}
				
		});	
		
	
		

		JLabel name = new JLabel("Naziv predmeta*");
		JLabel scode = new JLabel("Šifra predmeta*");
		JLabel sem = new JLabel("Semestar*");
		JLabel yr = new JLabel("Godina studija u kojoj se predmet izvodi* ");
		JLabel espb = new JLabel("Broj ESPB bodova*");
		JLabel profesor=new JLabel("Profesor*");

	
		
		
		txtName.setText(sb.getSubjectName());
		txtScode.setText(String.valueOf(sb.getSubjectID()));
		txtYr.setText(String.valueOf(sb.getStudyYear()));
		txtEspb.setText(String.valueOf(sb.getEspb()));
		if(SubjectBase.getInstance().getSubjects().get(MainFrame.getInstance().subjectTable.convertRowIndexToModel(MainFrame.getInstance().getDataFromSelectedRow1())).getSubjectProfessor()==null) {
			txtProfesor.setText(null);
		}else {
			txtProfesor.setText(SubjectBase.getInstance().getSubjects().get(MainFrame.getInstance().subjectTable.convertRowIndexToModel(MainFrame.getInstance().getDataFromSelectedRow1())).getSubjectProfessor().getName().concat(" ").concat(SubjectBase.getInstance().getSubjects().get(MainFrame.getInstance().subjectTable.convertRowIndexToModel(MainFrame.getInstance().getDataFromSelectedRow1())).getSubjectProfessor().getSurname()));
		}
		String check = SubjectBase.getInstance().getSubjects().get(MainFrame.getInstance().subjectTable.convertRowIndexToModel(MainFrame.getInstance().getDataFromSelectedRow1())).getSubjectID();
		
		GridBagConstraints gbcName = new GridBagConstraints();
		gbcName.gridx = 0;
		gbcName.gridy = 0;
		gbcName.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(name, gbcName);

		GridBagConstraints gbcScode = new GridBagConstraints();
		gbcScode.gridx = 0;
		gbcScode.gridy = 1;
		gbcScode.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(scode, gbcScode);

		GridBagConstraints gbcSem = new GridBagConstraints();
		gbcSem.gridx = 0;
		gbcSem.gridy = 2;
		gbcSem.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(sem, gbcSem);

		GridBagConstraints gbcYr = new GridBagConstraints();
		gbcYr.gridx = 0;
		gbcYr.gridy = 3;
		gbcYr.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(yr, gbcYr);

		GridBagConstraints gbcEspb = new GridBagConstraints();
		gbcEspb.gridx = 0;
		gbcEspb.gridy = 4;
		gbcEspb.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(espb, gbcEspb);
		
		
		GridBagConstraints gbcProfesor = new GridBagConstraints();
		gbcProfesor.gridx = 0;
		gbcProfesor.gridy = 5;
		gbcProfesor.insets = new Insets(20, 0, 0, 0);
		centerPanel.add(profesor, gbcProfesor);

		GridBagConstraints gbcTxtName = new GridBagConstraints();
		gbcTxtName.gridx = 1;
		gbcTxtName.gridy = 0;
		gbcTxtName.weightx = 0.5;
		gbcTxtName.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtName.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtName, gbcTxtName);

		GridBagConstraints gbcTxtScode = new GridBagConstraints();
		gbcTxtScode.gridx = 1;
		gbcTxtScode.gridy = 1;
		gbcTxtScode.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtScode.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtScode, gbcTxtScode);
		
		String semester[] = {"Letnji", "Zimski"};
		JComboBox<String> semCB = new JComboBox<>(semester);

		GridBagConstraints gbcTxtSem = new GridBagConstraints();
		gbcTxtSem.gridx = 1;
		gbcTxtSem.gridy = 2;
		gbcTxtSem.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtSem.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(semCB, gbcTxtSem);

		GridBagConstraints gbcTxtYr = new GridBagConstraints();
		gbcTxtYr.gridx = 1;
		gbcTxtYr.gridy = 3;
		gbcTxtYr.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtYr.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtYr, gbcTxtYr);

		GridBagConstraints gbcTxtEspb = new GridBagConstraints();
		gbcTxtEspb.gridx = 1;
		gbcTxtEspb.gridy = 4;
		gbcTxtEspb.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtEspb.insets = new Insets(20, 20, 0, 20);
		centerPanel.add(txtEspb, gbcTxtEspb);
		
		GridBagConstraints gbcTxtProfesor = new GridBagConstraints();
		gbcTxtProfesor.gridx = 1;
		gbcTxtProfesor.gridy = 5;
		gbcTxtProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtProfesor.insets = new Insets(20, 20, 0, 150);
		centerPanel.add(txtProfesor, gbcTxtProfesor);

		abort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				dispose();
			}

		});

		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Ime i sifra predmeta
				Pattern p = Pattern.compile("[A-z]+");

				Matcher m = p.matcher(txtName.getText());
				boolean b = m.matches();

				Pattern p1 = Pattern.compile("[A-z]*\\d*");
				Matcher m1 = p1.matcher(txtScode.getText());
				boolean b1 = m1.matches();

				// Godina u kojoj se predmet slusa
				Pattern p2 = Pattern.compile("\\d+");
				Matcher m2 = p2.matcher(txtYr.getText());
				boolean b2 = m2.matches();
				
				//ESPB
				Pattern p8 = Pattern.compile("\\d+");
				Matcher m8 = p8.matcher(txtEspb.getText());
				boolean b4 = m8.matches();
				
				//Provera sifre predmeta
				boolean sameID = false;
				for(Subject sb : SubjectBase.getInstance().getSubjects()) {
					if(sb.getSubjectID().equals(txtScode.getText())) {
						if(sb.getSubjectID().equals(check)) {
							sameID = false;
						}else {
							sameID = true;
						}
					}
				}
			
				//Dodati chProf u proveru kada se odradi dodavanje profesora
				if (b & b1 & b2 & b4 & !sameID) {
					String semm = semCB.getSelectedItem().toString();
					if (semm.equals("Letnji")) {
						semms = Subject.Semester.Letnji;
					} else {
						semms = Subject.Semester.Zimski;
					}
					
					Subject s = new Subject(txtScode.getText(), txtName.getText(), semms, Integer.parseInt(txtYr.getText()), Integer.parseInt(txtEspb.getText()));
					SubjectController.getInstance().editSubject(MainFrame.getInstance().subjectTable.getSelectedRow(), s);
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

	


}
	
