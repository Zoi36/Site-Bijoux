package com.admin.domain;

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
@Table(name="ringSertis")
public class RingSertis extends Option {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String typeStones;

	@OneToMany(mappedBy = "ringSertis", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<RingSimple> ringSimpleRingSertisList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<RingSimple> getRingSimpleRingSertisList() {
		return ringSimpleRingSertisList;
	}

	public void setRingSimpleRingSertisList(List<RingSimple> ringSimpleRingSertisList) {
		this.ringSimpleRingSertisList = ringSimpleRingSertisList;
	}

	public String getTypeStones() {
		return typeStones;
	}

	public void setTypeStones(String typeStones) {
		this.typeStones = typeStones;
	}

}
