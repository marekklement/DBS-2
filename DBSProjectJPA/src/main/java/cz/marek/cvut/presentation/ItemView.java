package cz.marek.cvut.presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

import cz.marek.cvut.model.Item;
import cz.marek.cvut.service.ItemService;
import cz.marek.cvut.service.ItemServiceImpl;

public class ItemView {

	private ItemService itemService;

	public ItemView() {
		this.itemService = new ItemServiceImpl();
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton b = new JButton("Save Book");
		b.setBounds(40, 121, 204, 20);
		f.add(b);

		JMenuBar bar = new JMenuBar();

		// File Menu, F - Mnemonic
		JMenu item = new JMenu("Item");
		item.setMnemonic(KeyEvent.VK_F);
		bar.add(item);

		// Edit Menu, E - Mnemonic
		JMenu worker = new JMenu("Worker");
		worker.setMnemonic(KeyEvent.VK_E);
		bar.add(worker);

		// Help Menu, H - Mnemonic
		JMenu library = new JMenu("Library");
		library.setMnemonic(KeyEvent.VK_H);
		bar.add(library);

		JMenu piece = new JMenu("Piece");
		piece.setMnemonic(KeyEvent.VK_G);
		bar.add(piece);

		f.setJMenuBar(bar);

		// SerialNumber
		final TextField serialNumber = new TextField();
		serialNumber.setBounds(158, 28, 86, 20);
		f.getContentPane().add(serialNumber);
		serialNumber.setColumns(10);

		JLabel sName = new JLabel("SerialNumber");
		sName.setBounds(40, 31, 110, 14);
		f.getContentPane().add(sName);

		// title
		final TextField title = new TextField();
		title.setBounds(158, 59, 86, 20);
		f.getContentPane().add(title);
		title.setColumns(10);

		JLabel tName = new JLabel("Title");
		tName.setBounds(40, 62, 110, 14);
		f.getContentPane().add(tName);

		// author
		final TextField author = new TextField();
		author.setBounds(158, 90, 86, 20);
		f.getContentPane().add(author);
		author.setColumns(10);

		JLabel aName = new JLabel("Author");
		aName.setBounds(40, 93, 110, 14);
		f.getContentPane().add(aName);
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
		f.setSize(800, 500);
		f.setLayout(null);
		f.setVisible(true);
	}
}
