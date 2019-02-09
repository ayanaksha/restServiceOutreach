package com.cts.cloud.enablement.onlinesales.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author 547991
 *
 */
@Entity
@Table
public class SalesTransaction implements Serializable {
	
	private static final long serialVersionUID = 2102917516769742591L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "Reg_id")
	private Long id;
	
	@Column(name = "event_id")
	private Long eventID;
	
	@Column(name = "event_role")
	private String eventRole;
	
	@Column(name = "emp_id")
	private Long empID;
	
	@Column(name = "emp_proj_id")
	private Long empProjId;
		
	@Column(name = "status")
	private String status;
	
	@Column(name = "event_location")
	private String eventLocation;

	@Column(name = "event_time")
	private String eventTime;
		
	@Column(name = "poc_id")
	private Long pocID;
	
	@Column(name = "poc_email_id")
	private String pocEmailId;
		
	@Column(name = "emp_email_id")
	private String empEmailId;
	
	/**
	 * Default constructor
	 */
	public SalesTransaction() {
		super();
	}

	/**
	 * @param id
	 * @param amount
	 * @param projectionType
	 * @param projectionAmount
	 * @param status
	 * @param requestedBy
	 * @param approver
	 * @param createdDate
	 * @param approvedDate
	 * @param rmEmailId
	 * @param rowversion
	 */
	public SalesTransaction(Long id, Long eventID, String eventRole, 
			Long empID, Long empProjID, String status, String eventLocation, String eventTime, Long pocID, 
			String pocEmailId, String empEmailId) {
		super();
		this.id = id;
		this.eventID = eventID;
		this.eventRole = eventRole;
		this.empID = empID;
		this.empProjID = empProjID;
		this.status = status;
		this.eventLocation = eventLocation;
		this.eventTime = eventTime;
		this.pocID = pocID;
		this.pocEmailId = pocEmailId;
		this.empEmailId = empEmailId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventID() {
		return eventID;
	}

	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}

	public String getEventRole() {
		return eventRole;
	}

	public void setEventRole(String eventRole) {
		this.eventRole = eventRole;
	}

	public Long getEmpID() {
		return empID;
	}

	public void setEmpID(Long empID) {
		this.empID = empID;
	}

	public Long getEmpProjID() {
		return empProjID;
	}

	public void setEmpProjID(Long empProjID) {
		this.empProjID = empProjID;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public Long getPocID() {
		return pocID;
	}

	public void setPocID(Long pocID) {
		this.pocID = pocID;
	}

	public String getPocEmailId() {
		return pocEmailId;
	}

	public void setPocEmailId(String pocEmailId) {
		this.pocEmailId = pocEmailId;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

