package com.bijou.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="diammand")
public class Diammand extends Option {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(columnDefinition = "text")
	private String formDiammand;

	@OneToMany(mappedBy = "diammand")
	@JsonIgnore
	private List<DiammandAlliance> diammandAllianceList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DiammandAlliance> getDiammandAllianceList() {
		return diammandAllianceList;
	}

	public void setDiammandAllianceList(List<DiammandAlliance> diammandAllianceList) {
		this.diammandAllianceList = diammandAllianceList;
	}

	public String getFormDiammand() {
		return formDiammand;
	}

	public void setFormDiammand(String formDiammand) {
		this.formDiammand = formDiammand;
	}

}
