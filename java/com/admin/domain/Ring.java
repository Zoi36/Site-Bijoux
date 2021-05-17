package com.admin.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="ring")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Ring extends Bijou {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String typeRing;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeRing() {
		return typeRing;
	}

	public void setTypeRing(String typeRing) {
		this.typeRing = typeRing;
	}

}
