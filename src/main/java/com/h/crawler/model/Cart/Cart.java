package com.h.crawler.model.Cart;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.h.crawler.model.Product;
import com.h.crawler.model.auth.Account;

@Entity
@Table(name = "CARTS")
public class Cart {
	@Id
	@Column(name = "ID")
	private Long id;
	
	@JoinColumn(name = "ID")
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Account account;
	
	@ManyToMany(mappedBy = "carts")
	private Set<Product> products;
	
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
