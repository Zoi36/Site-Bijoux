package com.admin.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double price;
	private String title;
	private int stock;
	private Double weightMetal;

	@Column(columnDefinition = "text")
	private String description;

	@Transient
	private MultipartFile image;

	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<LineProduct> lineProductList;

	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<FeedBack> feedBackList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getWeightMetal() {
		return weightMetal;
	}

	public void setWeightMetal(Double weightMetal) {
		this.weightMetal = weightMetal;
	}

	public List<FeedBack> getFeedBackList() {
		return feedBackList;
	}

	public void setFeedBackList(List<FeedBack> feedBackList) {
		this.feedBackList = feedBackList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<LineProduct> getLineProductList() {
		return lineProductList;
	}

	public void setLineProductList(List<LineProduct> lineProductList) {
		this.lineProductList = lineProductList;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

}
