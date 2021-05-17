package com.bijou.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="stone")
public class Stone extends Option {

	private String typeStone;
	private String formStone;
	private double weightStone;
	private String nextStones;
	private String haloStone;

	@OneToMany(mappedBy = "stone", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<RingSimple> ringSimpleStoneList;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	public String getHaloStone() {
		return haloStone;
	}

	public void setHaloStone(String haloStone) {
		this.haloStone = haloStone;
	}

	public List<RingSimple> getRingSimpleStoneList() {
		return ringSimpleStoneList;
	}

	public void setRingSimpleStoneList(List<RingSimple> ringSimpleStoneList) {
		this.ringSimpleStoneList = ringSimpleStoneList;
	}

	public String getNextStones() {
		return nextStones;
	}

	public void setNextStones(String nextStones) {
		this.nextStones = nextStones;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getWeightStone() {
		return weightStone;
	}

	public void setWeightStone(double weightStone) {
		this.weightStone = weightStone;
	}

	public String getTypeStone() {
		return typeStone;
	}

	public void setTypeStone(String typeStone) {
		this.typeStone = typeStone;
	}

	public String getFormStone() {
		return formStone;
	}

	public void setFormStone(String formStone) {
		this.formStone = formStone;
	}

}
