package com.h.crawler.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.h.crawler.model.auth.Account;

@Entity
@Table(name = "ORDERS")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ID")
	private Account accountId;
	
	@ManyToMany(mappedBy = "orders")
	private Set<Product> products;

	@Column(name = "COST")
	private Double cost;

	@Column(name = "PURCHASE_DATE")
	private Date purchaseDate;

	@Column(name = "DEL_FLG")
	private Long delFlg;

	@Column(name = "INS_DATE")
	private Date insDate;

	@Column(name = "UPD_DATE")
	private Date updDate;

}
