package cz.marek.cvut.presentation.panel;

import javax.swing.*;

public abstract class AbstractPanel extends JPanel {

	// settings
	int leftMeasureLabel = 40;
	int leftMeasureForm = 158;
	int centerMeasureLabel = 300;
	int centerMeasureForm = 418;
	int buttonWidth = 204;
	int formHeight = 20;
	int labelHeight = 14;
	int formWidth = 86;
	int labelWidth = 110;
	int yFormStart = 28;
	int yLabelStart = 31;
	String textTrue = "true";
	private int space = 31;
	//
	private int yForm;
	private int yLabel;

	public abstract void set();

	int increaseYForm() {
		yForm = yForm + space;
		return yForm;
	}

	int increaseYLabel() {
		yLabel = yLabel + space;
		return yLabel;
	}

	void resetYForm() {
		yForm = yFormStart;
	}

	void resetYLabel() {
		yLabel = yLabelStart;
	}

	void resetY() {
		resetYForm();
		resetYLabel();
	}
}
