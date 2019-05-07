package cz.marek.cvut.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARIAN_WRKR")
public class Librarian extends Worker {

	@Column(name = "SEAT")
	private String seat;

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}
}
