package cz.marek.cvut.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LIBRARY_BLDNG")
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "NAME")
	@NotNull
	private String name;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STREET")
	private String street;

	@Column(name = "HOUSE_NUMBER")
	private int houseNumber;

	@Column(name = "POSTAL_CODE")
	private int postalCode;

	@Column(name = "PIECES")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "library")
	private List<Piece> pieces;

	@ManyToMany
	@JoinTable(name = "LIBRARIES_WORKERS", joinColumns = @JoinColumn(name = "LIBRARY_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "WORKER_ID", referencedColumnName = "ID"))
	private List<Worker> workers;

	public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}
}
