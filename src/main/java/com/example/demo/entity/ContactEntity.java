package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONTACT_TABLE")
public class ContactEntity {
	

	@Id
	@GeneratedValue
	@Column(name = "CONTACT_ID")
	public Integer contactId;
	@Column(name = "CONTACT_NAME")
	public String contactName;
	@Column(name = "CONTACT_NUMBER")
	public Integer contactNumber;
	@Column(name = "CONTACT_EMAIL")
	public String contactEmail;
	@CreationTimestamp
	@Column(name = "CREATION_DATE", updatable = false)
	private LocalDate creationalDate;
	@UpdateTimestamp
	@Column(name = "UPDATED_DATE", insertable = false)
	private LocalDate updationalDate;

	@Column(name = "ACTIVE_SWITCH")
	private String activeSwitch;

}