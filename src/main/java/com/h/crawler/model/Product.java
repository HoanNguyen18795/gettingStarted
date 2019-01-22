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

	@Column(name = "IMG1")
	private String img1;
	
	@Column(name = "IMG2")
	private String img2;
	
	@Column(name = "IMG3")
	private String img3;
	
	@Column(name = "IMG4")
	private String img4;
	
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

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public String getImg4() {
		return img4;
	}

	public void setImg4(String img4) {
		this.img4 = img4;
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
