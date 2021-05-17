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
@Table(name="chain")
public class Chain extends Bijou {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String typeChain;

	@OneToMany(mappedBy = "chain", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Necklace> necklaceList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Necklace> getNecklaceList() {
		return necklaceList;
	}

	public void setNecklaceList(List<Necklace> necklaceList) {
		this.necklaceList = necklaceList;
	}

	public String getTypeChain() {
		return typeChain;
	}

	public void setTypeChain(String typeChain) {
		this.typeChain = typeChain;
	}

}
