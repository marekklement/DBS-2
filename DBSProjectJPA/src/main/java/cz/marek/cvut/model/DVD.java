package cz.marek.cvut.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DVD")
public class DVD extends Item {

	@Column(name = "ORIGINAL")
	private boolean original;

	public boolean isOriginal() {
		return original;
	}

	public void setOriginal(boolean original) {
		this.original = original;
	}
}
