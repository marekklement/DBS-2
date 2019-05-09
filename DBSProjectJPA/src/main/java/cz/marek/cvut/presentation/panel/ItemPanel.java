package cz.marek.cvut.presentation.panel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cz.marek.cvut.model.Book;
import cz.marek.cvut.model.DVD;
import cz.marek.cvut.service.BookService;
import cz.marek.cvut.service.BookServiceImpl;
import cz.marek.cvut.service.DVDService;
import cz.marek.cvut.service.DVDServiceImpl;

public class ItemPanel extends AbstractPanel {

	private BookService bookService;
	private DVDService dvdService;


	public void set() {
		resetY();
		//
		this.bookService = new BookServiceImpl();
		this.dvdService = new DVDServiceImpl();
		//
		this.setBackground(Color.CYAN);
		//
		setItem(leftMeasureForm, leftMeasureLabel, false);
		setItem(centerMeasureForm, centerMeasureLabel, true);
	}

	private void setItem(int mf, int ml, boolean dvd) {
		resetY();

		// SerialNumber
		final TextField serialNumber = new TextField();
		serialNumber.setBounds(mf, yFormStart, formWidth, formHeight);
		this.add(serialNumber);
		serialNumber.setColumns(10);

		JLabel sName = new JLabel("SerialNumber");
		sName.setBounds(ml, yLabelStart, labelWidth, labelHeight);
		this.add(sName);

		// title
		final TextField title = new TextField();
		title.setBounds(mf, increaseYForm(), formWidth, formHeight);
		this.add(title);
		title.setColumns(10);

		JLabel tName = new JLabel("Title");
		tName.setBounds(ml, increaseYLabel(), labelWidth, labelHeight);
		this.add(tName);

		// author
		final TextField author = new TextField();
		author.setBounds(mf, increaseYForm(), formWidth, formHeight);
		this.add(author);
		author.setColumns(10);

		JLabel aName = new JLabel("Author");
		aName.setBounds(ml, increaseYLabel(), labelWidth, labelHeight);
		this.add(aName);

		// special
		final TextField special = new TextField();
		special.setBounds(mf, increaseYForm(), formWidth, formHeight);
		this.add(special);
		special.setColumns(10);

		JLabel spName = new JLabel("Special");
		spName.setBounds(ml, increaseYLabel(), labelWidth, labelHeight);

		JButton b = new JButton("Save Book");
		b.setBounds(ml, increaseYLabel(), buttonWidth, formHeight);
		add(b);

		if (dvd) {
			spName.setText("Original");
			this.add(spName);
			b.setText("Save DVD");

			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (serialNumber.getText().isEmpty() || title.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Data Missing");
					else {
						boolean original = false;
						if (special.getText().toLowerCase().equals(textTrue)) {
							original = true;
						}
						DVD item = new DVD();
						item.setTitle(title.getText());
						item.setSerialNumber(serialNumber.getText());
						item.setAuthor(author.getText());
						item.setOriginal(original);
						dvdService.createNewDVD(item);
						JOptionPane.showMessageDialog(null, title.getText() + " saved!");
					}
				}
			});
		} else {
			spName.setText("Year");
			this.add(spName);

			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (serialNumber.getText().isEmpty() || title.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Data Missing");
					else {
						Book item = new Book();
						item.setTitle(title.getText());
						item.setSerialNumber(serialNumber.getText());
						item.setAuthor(author.getText());
						item.setYear(Integer.parseInt(special.getText()));
						bookService.createNewBook(item);
						JOptionPane.showMessageDialog(null, title.getText() + " saved!");
					}
				}
			});
		}
	}
}
