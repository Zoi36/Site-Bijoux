package com.admin.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DiammandAlliance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int qtyDiammand;
	private String dispositionDiammand;

	@ManyToOne
	@JoinColumn(name = "diammandAlliance_id")
	private Alliance alliance;

	@ManyToOne
	@JoinColumn(name = "diammand_id")
	private Diammand diammand;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Alliance getAlliance() {
		return alliance;
	}

	public void setAlliance(Alliance alliance) {
		this.alliance = alliance;
	}

	public Diammand getDiammand() {
		return diammand;
	}

	public void setDiammand(Diammand diammand) {
		this.diammand = diammand;
	}

	public int getQtyDiammand() {
		return qtyDiammand;
	}

	public void setQtyDiammand(int qtyDiammand) {
		this.qtyDiammand = qtyDiammand;
	}

	public String getDispositionDiammand() {
		return dispositionDiammand;
	}

	public void setDispositionDiammand(String dispositionDiammand) {
		this.dispositionDiammand = dispositionDiammand;
	}

}
