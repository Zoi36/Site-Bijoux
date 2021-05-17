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
@Table(name="finish")
public class Finish extends Option {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String typeFinish;

	@OneToMany(mappedBy = "finish", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Alliance> allianceList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Alliance> getAllianceList() {
		return allianceList;
	}

	public void setAllianceList(List<Alliance> allianceList) {
		this.allianceList = allianceList;
	}

	public String getTypeFinish() {
		return typeFinish;
	}

	public void setTypeFinish(String typeFinish) {
		this.typeFinish = typeFinish;
	}

}
