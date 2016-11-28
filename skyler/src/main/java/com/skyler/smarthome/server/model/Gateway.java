package com.skyler.smarthome.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "s_gateways")
public class Gateway implements Serializable {

	@Transient
	private static final long serialVersionUID = 1189530690619771645L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	@Column(name = "s_gateway_name")
	private String gwName;
	@Column(name = "s_gateway_url")
	private String gwUrl;

}
