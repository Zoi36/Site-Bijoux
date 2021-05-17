package com.bijou.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="necklace")
public class Necklace extends Bijou {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String typeNecklace;

	@OneToOne(cascade = CascadeType.ALL)
	private Stone stone;

	@OneToOne(cascade = CascadeType.ALL)
	private Chain chain;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Chain getChain() {
		return chain;
	}

	public void setChain(Chain chain) {
		this.chain = chain;
	}

	public String getTypeNecklace() {
		return typeNecklace;
	}

	public void setTypeNecklace(String typeNecklace) {
		this.typeNecklace = typeNecklace;
	}

	public Stone getStone() {
		return stone;
	}

	public void setStone(Stone stone) {
		this.stone = stone;
	}

}
