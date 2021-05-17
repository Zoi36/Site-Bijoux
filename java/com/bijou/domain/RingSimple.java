package com.bijou.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ringSimple")
public class RingSimple extends Ring {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private RingSertis ringSertis;

	@OneToOne(cascade = CascadeType.ALL)
	private Stone stone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RingSertis getRingSertis() {
		return ringSertis;
	}

	public void setRingSertis(RingSertis ringSertis) {
		this.ringSertis = ringSertis;
	}

	public Stone getStone() {
		return stone;
	}

	public void setStone(Stone stone) {
		this.stone = stone;
	}

}
