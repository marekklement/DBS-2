package cz.marek.cvut.presentation.panel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cz.marek.cvut.model.Librarian;
import cz.marek.cvut.service.LibrarianService;
import cz.marek.cvut.service.LibrarianServiceImpl;

public class WorkerPanel extends AbstractPanel {

	private LibrarianService librarianService;

	public void set() {
		resetY();
		//
		this.librarianService = new LibrarianServiceImpl();
		//
		this.setBackground(Color.ORANGE);
		//
		setProperties(leftMeasureForm, leftMeasureLabel);
	}

	private void setProperties(int mf, int ml) {
		resetY();

		// SerialNumber
		final TextField username = new TextField();
		username.setBounds(mf, yFormStart, formWidth, formHeight);
		this.add(username);
		username.setColumns(10);

		JLabel uName = new JLabel("Username");
		uName.setBounds(ml, yLabelStart, labelWidth, labelHeight);
		this.add(uName);

		// title
		final TextField firstName = new TextField();
		firstName.setBounds(mf, increaseYForm(), formWidth, formHeight);
		this.add(firstName);
		firstName.setColumns(10);

		JLabel fName = new JLabel("FirstName");
		fName.setBounds(ml, increaseYLabel(), labelWidth, labelHeight);
		this.add(fName);

		// author
		final TextField lastName = new TextField();
		lastName.setBounds(mf, increaseYForm(), formWidth, formHeight);
		this.add(lastName);
		lastName.setColumns(10);

		JLabel lName = new JLabel("LastName");
		lName.setBounds(ml, increaseYLabel(), labelWidth, labelHeight);
		this.add(lName);

		// special
		final TextField address = new TextField();
		address.setBounds(mf, increaseYForm(), formWidth, formHeight);
		this.add(address);
		address.setColumns(10);

		JLabel aName = new JLabel("Address");
		aName.setBounds(ml, increaseYLabel(), labelWidth, labelHeight);
		this.add(aName);

		// Salary
		final TextField salary = new TextField();
		salary.setBounds(mf, increaseYForm(), formWidth, formHeight);
		this.add(salary);
		salary.setColumns(10);

		JLabel sName = new JLabel("Salary");
		sName.setBounds(ml, increaseYLabel(), labelWidth, labelHeight);
		this.add(sName);

		// seat
		final TextField seat = new TextField();
		seat.setBounds(mf, increaseYForm(), formWidth, formHeight);
		this.add(seat);
		seat.setColumns(10);

		JLabel seName = new JLabel("Seat");
		seName.setBounds(ml, increaseYLabel(), labelWidth, labelHeight);
		this.add(seName);

		JButton b = new JButton("Save Librarian");
		b.setBounds(ml, increaseYLabel(), buttonWidth, formHeight);
		add(b);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (username.getText().isEmpty() || salary.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Data Missing");
				else {
					Librarian item = new Librarian();
					item.setUsername(username.getText());
					item.setFirstName(firstName.getText());
					item.setLastName(lastName.getText());
					item.setAddress(address.getText());
					item.setSalary(Integer.parseInt(salary.getText()));
					item.setSeat(seat.getText());
					librarianService.createNewLibrarian(item);
					JOptionPane.showMessageDialog(null, username.getText() + " saved!");
				}
			}
		});
	}
}
