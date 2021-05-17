package com.bijou.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="alliance")
public class Alliance extends Ring {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String profilAlliance;
	private int widthAlliance;

	@OneToOne(cascade = CascadeType.ALL)
	private Engraving engraving;

	@OneToOne(cascade = CascadeType.ALL)
	private Finish finish;

	@OneToMany(mappedBy = "alliance", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<DiammandAlliance> diammandAllianceList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getWidthAlliance() {
		return widthAlliance;
	}

	public void setWidthAlliance(int widthAlliance) {
		this.widthAlliance = widthAlliance;
	}

	public Finish getFinish() {
		return finish;
	}

	public void setFinish(Finish finish) {
		this.finish = finish;
	}

	public Engraving getEngraving() {
		return engraving;
	}

	public void setEngraving(Engraving engraving) {
		this.engraving = engraving;
	}

	public String getProfilAlliance() {
		return profilAlliance;
	}

	public void setProfilAlliance(String profilAlliance) {
		this.profilAlliance = profilAlliance;
	}

}
