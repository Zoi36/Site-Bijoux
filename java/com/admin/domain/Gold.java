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
@Table(name="gold")
public class Gold extends Option {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String colorGold;
	private int qualityGold;
	private double pricePerGram;

	@OneToMany(mappedBy = "gold", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Bijou> bijouGoldList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPricePerGram() {
		return pricePerGram;
	}

	public void setPricePerGram(double pricePerGram) {
		this.pricePerGram = pricePerGram;
	}

	public List<Bijou> getBijouGoldList() {
		return bijouGoldList;
	}

	public void setBijouGoldList(List<Bijou> bijouGoldList) {
		this.bijouGoldList = bijouGoldList;
	}

	public String getColorGold() {
		return colorGold;
	}

	public void setColorGold(String colorGold) {
		this.colorGold = colorGold;
	}

	public int getQualityGold() {
		return qualityGold;
	}

	public void setQualityGold(int qualityGold) {
		this.qualityGold = qualityGold;
	}

}
