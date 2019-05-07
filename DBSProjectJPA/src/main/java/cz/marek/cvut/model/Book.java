package cz.marek.cvut.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_ITEM")
public class Book extends Item {

	@Column(name = "YEAR")
	private int year;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
