package com.h.crawler.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "PRODUCT_ORDER"
				,joinColumns = @JoinColumn(name = "PRODUCT_ID")
				,inverseJoinColumns = @JoinColumn(name = "ORDER_ID"))
	private Set<Order> orders;
	
	@Column(name = "IMG")
	private String img;

	@Column(name = "PRICE")
	private Double price;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "MANUFACTURER")
	private String manufacturer;

	@Column(name = "TOTAL")
	private Long total;

	@Column(name = "CATEGORY")
	private Long category;

	@Column(name = "DEL_FLG")
	private Long delFlg;

	@Column(name = "INS_DATE")
	private Date insDate;

	@Column(name = "UPD_DATE")
	private Date updDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Long getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(Long delFlg) {
		this.delFlg = delFlg;
	}

	public Date getInsDate() {
		return insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

}
