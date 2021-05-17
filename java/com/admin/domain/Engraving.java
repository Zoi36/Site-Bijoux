package com.admin.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="engraving")
public class Engraving extends Option {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(columnDefinition = "text")
	private String textEngraving;
	private String fontEngraving;

	@OneToMany(mappedBy = "engraving", cascade = CascadeType.ALL)
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

	public String getTextEngraving() {
		return textEngraving;
	}

	public void setTextEngraving(String textEngraving) {
		this.textEngraving = textEngraving;
	}

	public String getFontEngraving() {
		return fontEngraving;
	}

	public void setFontEngraving(String fontEngraving) {
		this.fontEngraving = fontEngraving;
	}

}
