package com.coolerspark.whatsup.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "whatsup_app_image")
public class Image extends IdEntity {

	private String name;

	private String path;

	private Date creationDate;

	private Item item;

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@NotBlank
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	// JPA 基于ITEM_ID列的多对一关系定义
	@ManyToOne
	@JoinColumn(name = "item_id")
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
