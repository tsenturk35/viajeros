package com.viajeros.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.viajeros.entity.AuditStamp;

@Entity
@Table(name = "ordersheet")

public class InvoiceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "invoice_id")
	private Long invoiceId;
	
	@Column(name = "inv_dt")
	private Date invoiceDate;
	
	@Column(name = "veichle_no")
	private String veichleNumber;
	
	@Column(name = "veichle_typ_id")
	private Long veichleTypeId;
	
	@Column(name = "delivery_dt")
	private Date deliveryDate;
//	--------------------------------------------------- datat type to be chkd----------------------
	@Column(name = "lr_no")
	private int lrNumber;
	
	@Column(name = "deten_days")
	private int detentionDays;
	
	@Column(name = "amount")
	private Double amount;
	
	@Embedded
	private AuditStamp auditStamp;

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getVeichleNumber() {
		return veichleNumber;
	}

	public void setVeichleNumber(String veichleNumber) {
		this.veichleNumber = veichleNumber;
	}

	public Long getVeichleTypeId() {
		return veichleTypeId;
	}

	public void setVeichleTypeId(Long veichleTypeId) {
		this.veichleTypeId = veichleTypeId;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getLrNumber() {
		return lrNumber;
	}

	public void setLrNumber(int lrNumber) {
		this.lrNumber = lrNumber;
	}

	public int getDetentionDays() {
		return detentionDays;
	}

	public void setDetentionDays(int detentionDays) {
		this.detentionDays = detentionDays;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public AuditStamp getAuditStamp() {
		return auditStamp;
	}

	public void setAuditStamp(AuditStamp auditStamp) {
		this.auditStamp = auditStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((invoiceId == null) ? 0 : invoiceId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceDetails other = (InvoiceDetails) obj;
		if (invoiceId == null) {
			if (other.invoiceId != null)
				return false;
		} else if (!invoiceId.equals(other.invoiceId))
			return false;
		return true;
	}
	
	
	
}
