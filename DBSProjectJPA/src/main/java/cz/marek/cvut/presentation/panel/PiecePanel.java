package cz.marek.cvut.presentation.panel;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import cz.marek.cvut.model.Item;
import cz.marek.cvut.service.ItemService;
import cz.marek.cvut.service.ItemServiceImpl;
import cz.marek.cvut.service.PieceService;
import cz.marek.cvut.service.PieceServiceImpl;

public class PiecePanel extends AbstractPanel {

	JComboBox items;
	private PieceService pieceService;
	private ItemService itemService;

	public void set() {
		resetY();
		//
		pieceService = new PieceServiceImpl();
		itemService = new ItemServiceImpl();
		//
		this.setBackground(Color.GREEN);
		//
		setProperties(leftMeasureForm, leftMeasureLabel);
	}

	private void setProperties(int mf, int ml) {
		resetY();

		// pieceNumber
		final TextField pieceNumber = new TextField();
		pieceNumber.setBounds(mf, yFormStart, formWidth, formHeight);
		this.add(pieceNumber);
		pieceNumber.setColumns(10);

		JLabel pName = new JLabel("Piece");
		pName.setBounds(ml, yLabelStart, labelWidth, labelHeight);
		this.add(pName);

		// price
		final TextField price = new TextField();
		price.setBounds(mf, increaseYForm(), formWidth, formHeight);
		this.add(price);
		price.setColumns(10);

		JLabel prName = new JLabel("Price");
		prName.setBounds(ml, increaseYLabel(), labelWidth, labelHeight);
		this.add(prName);

		List<Item> all = itemService.findAll();

//		items = new JComboBox(new DefaultComboBoxModel(all.toArray()));
//		items.setBounds(ml, increaseYForm(), labelWidth, labelHeight);
//		items.setRenderer(new DefaultListCellRenderer() {
//			@Override
//			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//				if(value instanceof Item){
//					Item item = (Item) value;
//					StringBuilder sb = new StringBuilder();
//					sb.append(item.getTitle()).append(", ").append(item.getId());
//					setText(sb.toString());
//				}
//				return this;
//			}
//		} );
//
//		this.add(items);
	}

//	public void updateItems(){
//		List<Item> all = itemService.findAll();
//		items.removeAllItems();
//		all.forEach(i -> {
//			items.addItem(i);
//		});
//	}
}
