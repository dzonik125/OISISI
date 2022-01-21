package frame;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import model.BazaProfesora;
import model.Professor;
import model.Student;
import model.StudentBase;
import model.Subject;
import model.SubjectBase;
import search.SearchProfessors;
import search.SearchStudents;
import search.SearchSubjects;

public class MyToolBar extends JToolBar {

	private static MyToolBar instance = null;

	public static MyToolBar getInstance() {
		if (instance == null) {
			instance = new MyToolBar();
		}
		return instance;
	}

	public int counter = 0;
	public int counter1=0;
	public int counter2=0;
	public ArrayList<Student> helpList = new ArrayList<Student>(StudentBase.getInstance().getStudents());
	public ArrayList<Professor> helpList1 = new ArrayList<Professor>(BazaProfesora.getInstance().getProfessors());
	public ArrayList<Subject> helpList2 = new ArrayList<Subject>(SubjectBase.getInstance().getSubjects());
	
	
	public MyToolBar() {

		super(SwingConstants.HORIZONTAL);

		ImageIcon iconIcon = new ImageIcon("images/icon.png");
		Image image3 = iconIcon.getImage();
		Image newimg3 = image3.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		iconIcon = new ImageIcon(newimg3);

		JButton buttonNew = new JButton();
		buttonNew.setToolTipText("New");
		buttonNew.setIcon(iconIcon);
		add(buttonNew);
		buttonNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Dodati if za tabove!!
				if (MainFrame.getInstance().tp.getSelectedIndex() == 0) {
					if (counter == 0) {

						DialogStudent ds = new DialogStudent(MainFrame.getInstance());
						helpList = new ArrayList<Student>(StudentBase.getInstance().getStudents());

					} else {
						if (SearchStudents.getInstance().flag == true) {
							DialogStudent ds = new DialogStudent(MainFrame.getInstance());
							helpList = new ArrayList<Student>(StudentBase.getInstance().getStudents());
						} else {
							return;
						}
					}
				} else if (MainFrame.getInstance().tp.getSelectedIndex() == 1) {
					if(counter1==0) {
						
						DialogProfesor dp = new DialogProfesor(MainFrame.getInstance());
						helpList1 = new ArrayList<Professor>(BazaProfesora.getInstance().getProfessors());

					} else {
						if (SearchProfessors.getInstance().flag == true) {
							DialogProfesor dp = new DialogProfesor(MainFrame.getInstance());
							helpList1 = new ArrayList<Professor>(BazaProfesora.getInstance().getProfessors());
						} else {
							return;
						}		
					}
						

				} else if (MainFrame.getInstance().tp.getSelectedIndex() == 2) {
					DialogSubject sd = new DialogSubject(MainFrame.getInstance());
				}
			}
		});

		addSeparator();

		ImageIcon pencilIcon = new ImageIcon("images/pencil.png");
		Image image2 = pencilIcon.getImage();
		Image newimg2 = image2.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		pencilIcon = new ImageIcon(newimg2);

		JButton buttonChange = new JButton();
		buttonChange.setToolTipText("change");
		buttonChange.setIcon(pencilIcon);
		add(buttonChange);
		buttonChange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (MainFrame.getInstance().tp.getSelectedIndex() == 0 & MainFrame.getInstance().studentTable.getSelectedRowCount() != 0) {
					if (counter == 0) {

						EditStudent es = new EditStudent(MainFrame.getInstance());
						helpList = new ArrayList<Student>(StudentBase.getInstance().getStudents());

					} else {
						if (SearchStudents.getInstance().flag == true) {
							EditStudent es = new EditStudent(MainFrame.getInstance());
							helpList = new ArrayList<Student>(StudentBase.getInstance().getStudents());
						} else {
							return;
						}
					}
				} else if (MainFrame.getInstance().tp.getSelectedIndex() == 1 & MainFrame.getInstance().professorTable.getSelectedRowCount() != 0) {
					if(counter==1) {
						EditProfesor ep=new EditProfesor(MainFrame.getInstance());
						helpList1=new ArrayList<Professor>(BazaProfesora.getInstance().getProfessors());
					}
					else {
						
						if(SearchProfessors.getInstance().flag==true) {
							EditProfesor ep=new EditProfesor(MainFrame.getInstance());
							helpList1=new ArrayList<Professor>(BazaProfesora.getInstance().getProfessors());
						}else {
							return;
						}

					}	
				
				} else if (MainFrame.getInstance().tp.getSelectedIndex() == 2 & MainFrame.getInstance().subjectTable.getSelectedRowCount() != 0) {
					EditSubject es1 = new EditSubject(MainFrame.getInstance());
				}
			}

		});

		addSeparator();

		ImageIcon deleteIcon = new ImageIcon("images/delete.png");
		Image image1 = deleteIcon.getImage();
		Image newimg1 = image1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		deleteIcon = new ImageIcon(newimg1);

		JButton buttonBin = new JButton();
		buttonBin.setToolTipText("delete");
		buttonBin.setIcon(deleteIcon);
		add(buttonBin);
		buttonBin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (MainFrame.getInstance().tp.getSelectedIndex() == 0 & MainFrame.getInstance().studentTable.getSelectedRowCount() != 0) {
					if (counter == 0) {

						DeleteStudent dels = new DeleteStudent(MainFrame.getInstance());
						helpList = new ArrayList<Student>(StudentBase.getInstance().getStudents());

					} else {
						if (SearchStudents.getInstance().flag == true) {
							DeleteStudent dels = new DeleteStudent(MainFrame.getInstance());
							helpList = new ArrayList<Student>(StudentBase.getInstance().getStudents());
						} else {
							return;
						}
					}
				}else if(MainFrame.getInstance().tp.getSelectedIndex()==1
						&MainFrame.getInstance().professorTable.getSelectedRowCount()!=0){
					if(counter==1) {
					DeleteProfesor ep=new DeleteProfesor(MainFrame.getInstance());
						helpList1=new ArrayList<Professor>(BazaProfesora.getInstance().getProfessors());
					}
					else {
						
						if(SearchProfessors.getInstance().flag==true) {
							DeleteProfesor ep=new DeleteProfesor(MainFrame.getInstance());
							helpList1=new ArrayList<Professor>(BazaProfesora.getInstance().getProfessors());
						}else {
							return;
						}

					}	
					
				}else if(MainFrame.getInstance().tp.getSelectedIndex()==2
						&MainFrame.getInstance().subjectTable.getSelectedRowCount()!=0){
					DeleteSubject delsp = new DeleteSubject(MainFrame.getInstance());
				}
				}
		});

		addSeparator();

		JTextField textField = new JTextField();
		textField.setToolTipText("pretraga");
		textField.setColumns(9);
		textField.getPreferredSize();
		textField.setBounds(100, 100, 200, 40);

		add(textField);

		ImageIcon searchIcon = new ImageIcon("images/search.png");
		Image image4 = searchIcon.getImage();
		Image newimg4 = image4.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		searchIcon = new ImageIcon(newimg4);

		JButton buttonSearch = new JButton();
		buttonSearch.setToolTipText("seach");
		buttonSearch.setIcon(searchIcon);
		SearchStudents ss = new SearchStudents();

		buttonSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (MainFrame.getInstance().tp.getSelectedIndex() == 0) {
					String srch = textField.getText();
					counter = counter + 1;
					if (counter > 1 & textField.getText().isEmpty()) {
						StudentBase.getInstance().setStudents(helpList);
						MainFrame.getInstance().refresh();
					} else if (counter > 1 & !textField.getText().isEmpty()) {
						StudentBase.getInstance().setStudents(helpList);
					}

					SearchStudents.getInstance().searchStudents(srch);
				}else if(MainFrame.getInstance().tp.getSelectedIndex()==1) {
					String srch = textField.getText();
					counter1=counter1+1;
					if(counter1>1 & textField.getText().isEmpty()) {
						BazaProfesora.getInstance().setProfessors(helpList1);
						MainFrame.getInstance().refresh2();	
						
					}else if(counter>1 & !textField.getText().isEmpty()) {
						BazaProfesora.getInstance().setProfessors(helpList1);
						
					}
					
					SearchProfessors.getInstance().searchProfessors(srch);
					
				}else if(MainFrame.getInstance().tp.getSelectedIndex()==2) {
					
					
					String srch = textField.getText();
					counter2=counter2+1;
					if(counter2>1 & textField.getText().isEmpty()) {
						SubjectBase.getInstance().setSubjects(helpList2);
						MainFrame.getInstance().refresh1();	
						
					}else if(counter2>1 & !textField.getText().isEmpty()) {
						SubjectBase.getInstance().setSubjects(helpList2);
					}
					
					SearchSubjects.getInstance().searchSubjects(srch);
	
				}
			}
		});

		add(buttonSearch);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(RIGHT));
		panel.add(textField);
		panel.add(buttonSearch);

		add(panel);

		setFloatable(false);

	}
}


