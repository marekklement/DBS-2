package cz.marek.cvut.presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cz.marek.cvut.model.Item;
import cz.marek.cvut.service.ItemService;
import cz.marek.cvut.service.ItemServiceImpl;

public class View {

	private ItemService itemService;

	public View() {
		this.itemService = new ItemServiceImpl();
		JFrame f = new JFrame();
		JButton b = new JButton("Save");
		b.setBounds(130, 100, 100, 40);
		f.add(b);

		// SerialNumber
		final TextField serialNumber = new TextField();
		serialNumber.setBounds(128, 28, 86, 20);
		f.getContentPane().add(serialNumber);
		serialNumber.setColumns(10);

		JLabel sName = new JLabel("SerialNumber");
		sName.setBounds(65, 31, 46, 14);
		f.getContentPane().add(sName);

		final TextField title = new TextField();
		title.setBounds(128, 59, 86, 20);
		f.getContentPane().add(title);
		title.setColumns(10);

		JLabel tName = new JLabel("Title");
		tName.setBounds(65, 62, 46, 14);
		f.getContentPane().add(tName);
		//
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (serialNumber.getText().isEmpty() || title.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Data Missing");
				else {
					Item item = new Item();
					item.setTitle(title.getText());
					item.setSerialNumber(serialNumber.getText());
					itemService.createNewItem(item);
					JOptionPane.showMessageDialog(null, title.getText() + " saved!");
				}
			}
		});

		//
		f.setSize(400, 500);
		f.setLayout(null);
		f.setVisible(true);
	}

	public void createItem() {

	}
}
