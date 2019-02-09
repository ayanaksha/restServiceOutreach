package com.cts.cloud.enablement.onlinesales.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author 547991
 *
 */
@Entity
@Table
public class Event implements Serializable {

	private static final long serialVersionUID = 728806186124441033L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		//@GeneratedValue(strategy = GenerationType.TABLE)
		@Column(name = "id")
		private Long eventID;
		
		@Column(name = "event_type")
		private String eventType;
		
		@Column(name = "event_role")
		private String eventRole;
		
		@Column(name = "status")
		private String status;
				
		@Column(name = "location")
		private String location;
		
		@Column(name = "event_time")
		private String eventTime;
		
		@Column(name = "creation_date")
		private String creationDate;

		@Column(name = "poc_id")
		private Long pocID;
		
		@Column(name = "event_desc")
		private String eventDesc;
		
		@Column(name = "lives_touched")
		private String livesTouched;
		/**
		 * Default constructor
		 */
		public Event() {
			super();
		}

		/**
		 * @param id
		 * @param username
		 * @param password
		 * @param userEmailId
		 * @param role
		 * @param phone
		 * @param location
		 */
		public Event(Long eventID, String eventRole, String status, String location, String eventTime, String creationDate,
				Long pocID, String eventDesc) {
			super();
			this.eventID = eventID;
			this.eventRole = eventRole;
			this.status = status;
			this.empname = empname;
			this.location = location;
			this.eventTime = eventTime;
			this.creationDate = creationDate;
			this.pocID = pocID;
			this.eventDesc = eventDesc;
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

		public String getEventType() {
			return eventType;
		}

		public void setEventType(String eventType) {
			this.eventType = eventType;
		}
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getEventTime() {
			return eventTime;
		}

		public void setEventTime(String eventTime) {
			this.eventTime = eventTime;
		}

		public String getCreationDate() {
			return creationDate;
		}

		public void setCreationDate(String creationDate) {
			this.creationDate = creationDate;
		}

		public Long getPocID() {
			return pocID;
		}

		public void setPocID(Long pocID) {
			this.pocID = pocID;
		}

		public String getEventDesc() {
			return eventDesc;
		}

		public void setEventDesc(String eventDesc) {
			this.eventDesc = eventDesc;
		}
		
		public String getLivesTouched() {
			return livesTouched;
		}

		public void setLivesTouched(String livesTouched) {
			this.livesTouched = livesTouched;
		}

		