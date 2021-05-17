package com.admin.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="earrings")
public class Earrings extends Bijou {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String typeEarrings;

	@OneToOne(cascade = CascadeType.ALL)
	private Stone stone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeEarrings() {
		return typeEarrings;
	}

	public void setTypeEarrings(String typeEarrings) {
		this.typeEarrings = typeEarrings;
	}

	public Stone getStone() {
		return stone;
	}

	public void setStone(Stone stone) {
		this.stone = stone;
	}

}
