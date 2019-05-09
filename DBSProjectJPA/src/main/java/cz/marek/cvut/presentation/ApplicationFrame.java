package cz.marek.cvut.presentation;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import cz.marek.cvut.presentation.panel.ItemPanel;
import cz.marek.cvut.presentation.panel.LibraryPanel;
import cz.marek.cvut.presentation.panel.PiecePanel;
import cz.marek.cvut.presentation.panel.WorkerPanel;

public class ApplicationFrame extends JFrame {

	private ItemPanel itemPanel;
	private WorkerPanel workerPanel;
	private LibraryPanel libraryPanel;
	private PiecePanel piecePanel;
	//
	private JMenuBar bar;

	public ApplicationFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//
		itemPanel = new ItemPanel();
		workerPanel = new WorkerPanel();
		libraryPanel = new LibraryPanel();
		piecePanel = new PiecePanel();
		//
		itemPanel.set();
		workerPanel.set();
		libraryPanel.set();
		piecePanel.set();
		//
		initMenu();
		//
//		this.setContentPane(itemPanel);
		//
		setLayout(new BorderLayout());
	}

	private void initMenu() {
		bar = new JMenuBar();

		// Item
		JMenu item = new JMenu("Item");
		item.addMenuListener(new MenuAction(itemPanel));
		bar.add(item);

		// Worker
		JMenu worker = new JMenu("Worker");
		worker.addMenuListener(new MenuAction(workerPanel));
		bar.add(worker);

		// Library
		JMenu library = new JMenu("Library");
		library.addMenuListener(new MenuAction(libraryPanel));
		bar.add(library);

		// Piece
		JMenu piece = new JMenu("Piece");
		piece.addMenuListener(new MenuAction(piecePanel));
		bar.add(piece);
		//
		this.setJMenuBar(bar);

	}

	private void changePanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.getContentPane().doLayout();
		this.update(getGraphics());
	}

	public class MenuAction implements MenuListener {

		private JPanel panel;

		private MenuAction(JPanel pnl) {
			this.panel = pnl;
		}


		@Override
		public void menuSelected(MenuEvent e) {
			if (panel instanceof LibraryPanel) {
				//todo
			} else if (panel instanceof PiecePanel) {
				//((PiecePanel) panel).updateItems();
			}
			changePanel(panel);
		}

		@Override
		public void menuDeselected(MenuEvent e) {

		}

		@Override
		public void menuCanceled(MenuEvent e) {

		}
	}
}
