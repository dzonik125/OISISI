package frame;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import model.Student;
import model.StudentBase;
import search.SearchStudents;
import util.Serialization;

public class MenuBar extends JMenuBar {

	public MenuBar() {

		JMenu file = new JMenu("File");
		JMenuItem miNew = new JMenuItem("New");
		miNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Dodati if za tab!!!
				if (MainFrame.getInstance().tp.getSelectedIndex() == 0) {
//					if (MyToolBar.getInstance().counter == 0) {

						DialogStudent ds = new DialogStudent(MainFrame.getInstance());
//						MyToolBar.getInstance().helpList = new ArrayList<Student>(
//								StudentBase.getInstance().getStudents());

//					} else {
//						if (SearchStudents.getInstance().flag == true) {
//							DialogStudent ds = new DialogStudent(MainFrame.getInstance());
//							MyToolBar.getInstance().helpList = new ArrayList<Student>(
//									StudentBase.getInstance().getStudents());
//						} else {
//							return;
//						}
//					}
				}

				else if (MainFrame.getInstance().tp.getSelectedIndex() == 1) {
					DialogProfesor dp = new DialogProfesor(MainFrame.getInstance());
				} else if (MainFrame.getInstance().tp.getSelectedIndex() == 2) {
					DialogSubject sd = new DialogSubject(MainFrame.getInstance());
				}
			}
		});
		JMenuItem miSave = new JMenuItem("Save");
		miSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Serialization.getInstance().serializeStudent();
				Serialization.getInstance().serializeProfessor();
				Serialization.getInstance().serializeSubject();
			}
			
		});
		JMenu miOpen = new JMenu("Open");
		JMenuItem miClose = new JMenuItem("Close");
		JMenu edit = new JMenu("Edit");
		JMenuItem miEdit = new JMenuItem("Edit");
		miEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (MainFrame.getInstance().tp.getSelectedIndex() == 0
						& MainFrame.getInstance().studentTable.getSelectedRowCount() != 0) {
//					if (MyToolBar.getInstance().counter == 0) {

						EditStudent es = new EditStudent(MainFrame.getInstance());
//						MyToolBar.getInstance().helpList = new ArrayList<Student>(
//								StudentBase.getInstance().getStudents());
//
//					} else {
//						if (SearchStudents.getInstance().flag == true) {
//							EditStudent es = new EditStudent(MainFrame.getInstance());
//							MyToolBar.getInstance().helpList = new ArrayList<Student>(
//									StudentBase.getInstance().getStudents());
//						} else {
//							return;
//						}
//					}
				} else if (MainFrame.getInstance().tp.getSelectedIndex() == 1
						& MainFrame.getInstance().professorTable.getSelectedRowCount() != 0) {
					EditProfesor ep = new EditProfesor(MainFrame.getInstance());
				} else if (MainFrame.getInstance().tp.getSelectedIndex() == 2
						& MainFrame.getInstance().subjectTable.getSelectedRowCount() != 0) {
					EditSubject es1 = new EditSubject(MainFrame.getInstance());
				}

			}
		});
		JMenuItem miDelete = new JMenuItem("Delete");
		miDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (MainFrame.getInstance().tp.getSelectedIndex() == 0
						& MainFrame.getInstance().studentTable.getSelectedRowCount() != 0) {
					DeleteStudent dels = new DeleteStudent(MainFrame.getInstance());
				} else if (MainFrame.getInstance().tp.getSelectedIndex() == 1) {
					DeleteProfesor delp = new DeleteProfesor(MainFrame.getInstance());
				} else if (MainFrame.getInstance().tp.getSelectedIndex() == 2
						& MainFrame.getInstance().subjectTable.getSelectedRowCount() != 0) {
					DeleteSubject delsu = new DeleteSubject(MainFrame.getInstance());

				}
			}
		});
		JMenu help = new JMenu("Help");
		JMenuItem miHelp = new JMenuItem("Help");
		JMenuItem miAbout = new JMenuItem("About");

		JRadioButtonMenuItem rmiStudents = new JRadioButtonMenuItem("Studenti");
		JRadioButtonMenuItem rmiSubjects = new JRadioButtonMenuItem("Predmeti");
		JRadioButtonMenuItem rmiProfs = new JRadioButtonMenuItem("Profesori");
		JRadioButtonMenuItem rmiCathedra = new JRadioButtonMenuItem("Katedra");
		ButtonGroup group = new ButtonGroup();
		group.add(rmiStudents);
		group.add(rmiSubjects);
		group.add(rmiProfs);
		group.add(rmiCathedra);
		rmiStudents.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				MainFrame.getInstance().tp.setSelectedIndex(0);
			}

		});

		rmiSubjects.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				MainFrame.getInstance().tp.setSelectedIndex(2);
			}

		});

		rmiProfs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				MainFrame.getInstance().tp.setSelectedIndex(1);
			}

		});

		// Pokupljeno sa stackoverflowa, linije ispod za skaliranje slika,
		// https://stackoverflow.com/questions/25593949/force-jmenuitem-size

		ImageIcon fileIcon = new ImageIcon("images/file.png");
		Image image1 = fileIcon.getImage();
		Image newimg1 = image1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		fileIcon = new ImageIcon(newimg1);

		ImageIcon newIcon = new ImageIcon("images/new.png");
		Image image = newIcon.getImage();
		Image newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		newIcon = new ImageIcon(newimg);

		ImageIcon saveIcon = new ImageIcon("images/save.png");
		Image image2 = saveIcon.getImage();
		Image newimg2 = image2.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		saveIcon = new ImageIcon(newimg2);

		ImageIcon openIcon = new ImageIcon("images/open.png");
		Image image3 = openIcon.getImage();
		Image newimg3 = image3.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		openIcon = new ImageIcon(newimg3);

		ImageIcon closeIcon = new ImageIcon("images/close.png");
		Image image4 = closeIcon.getImage();
		Image newimg4 = image4.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		closeIcon = new ImageIcon(newimg4);

		file.add(miNew);
		KeyStroke ctrlNKeyStroke = KeyStroke.getKeyStroke("control N");
		miNew.setAccelerator(ctrlNKeyStroke);
		miNew.setIcon(newIcon);
		miNew.setMnemonic(KeyEvent.VK_W);
		file.addSeparator();
		file.add(miSave);
		KeyStroke ctrlSKeyStroke = KeyStroke.getKeyStroke("control S");
		miSave.setAccelerator(ctrlSKeyStroke);
		miSave.setIcon(saveIcon);
		miSave.setMnemonic(KeyEvent.VK_S);
		file.addSeparator();
		file.add(miOpen);
		miOpen.setMnemonic(KeyEvent.VK_O);
		miOpen.setIcon(openIcon);
		file.addSeparator();
		file.add(miClose);
		KeyStroke ctrCKeySTroke = KeyStroke.getKeyStroke("control C");
		miClose.setAccelerator(ctrCKeySTroke);
		miClose.setIcon(closeIcon);
		miClose.setMnemonic(KeyEvent.VK_C);

		miOpen.add(rmiStudents);
		miOpen.addSeparator();
		miOpen.add(rmiSubjects);
		miOpen.addSeparator();
		miOpen.add(rmiProfs);
		miOpen.addSeparator();
		miOpen.add(rmiCathedra);

		ImageIcon editIcon = new ImageIcon("images/edit.png");
		Image image5 = editIcon.getImage();
		Image newimg5 = image5.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		editIcon = new ImageIcon(newimg5);

		ImageIcon deleteIcon = new ImageIcon("images/delete.png");
		Image image6 = deleteIcon.getImage();
		Image newimg6 = image6.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		deleteIcon = new ImageIcon(newimg6);

		ImageIcon helpIcon = new ImageIcon("images/help.png");
		Image image7 = helpIcon.getImage();
		Image newimg7 = image7.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		helpIcon = new ImageIcon(newimg7);

		ImageIcon aboutIcon = new ImageIcon("images/about.png");
		Image image8 = aboutIcon.getImage();
		Image newimg8 = image8.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		aboutIcon = new ImageIcon(newimg8);

		edit.add(miEdit);
		KeyStroke ctrlEKeyStroke = KeyStroke.getKeyStroke("control E");
		miEdit.setAccelerator(ctrlEKeyStroke);
		miEdit.setIcon(editIcon);
		miEdit.setMnemonic(KeyEvent.VK_T);
		edit.addSeparator();
		edit.add(miDelete);
		KeyStroke ctrlDKeyStroke = KeyStroke.getKeyStroke("control D");
		miDelete.setAccelerator(ctrlDKeyStroke);
		miDelete.setIcon(deleteIcon);
		miDelete.setMnemonic(KeyEvent.VK_D);

		help.add(miHelp);
		KeyStroke ctrlHKeyStroke = KeyStroke.getKeyStroke("control H");
		miHelp.setAccelerator(ctrlHKeyStroke);
		miHelp.setIcon(helpIcon);
		miHelp.setMnemonic(KeyEvent.VK_L);
		help.addSeparator();
		help.add(miAbout);
		KeyStroke ctrlAKeyStroke = KeyStroke.getKeyStroke("control A");
		miAbout.setAccelerator(ctrlAKeyStroke);
		miAbout.setIcon(aboutIcon);
		miAbout.setMnemonic(KeyEvent.VK_A);

		add(file);
		file.setIcon(fileIcon);
		file.setMnemonic(KeyEvent.VK_F);
		add(edit);
		edit.setIcon(editIcon);
		edit.setMnemonic(KeyEvent.VK_E);
		add(help);
		help.setIcon(helpIcon);
		help.setMnemonic(KeyEvent.VK_H);

	}

}
