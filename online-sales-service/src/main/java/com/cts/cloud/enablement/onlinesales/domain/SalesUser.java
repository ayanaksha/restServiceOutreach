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
public class SalesUser implements Serializable {

	private static final long serialVersionUID = 728806186124441033L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		//@GeneratedValue(strategy = GenerationType.TABLE)
		@Column(name = "id")
		private Long id;
		
		@Column(name = "empid", unique=true, nullable=false)
		private Long empid;
		
		@Column(name = "password")
		private String password;
		
		@Column(name = "empname")
		private String empname;
		
		@Column(name = "user_email_id", unique=true, nullable=false)
		private String userEmailId;
		
		@Column(name = "proj_id")
		private Long projId;
		
		@Column(name = "proj_name")
		private String projname;
		
		@Column(name = "role")
		private String role;
		
		@Column(name = "phone")
		private String phone;
		
		@Column(name = "location")
		private String location;
		
		/**
		 * Default constructor
		 */
		public SalesUser() {
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
		public SalesUser(Long id, Long empid, String password, String empname, String userEmailId, Long projId, 
				String projname, String role, String phone,String location) {
			super();
			this.id = id;
			this.empid = empid;
			this.password = password;
			this.empname = empname;
			this.userEmailId = userEmailId;
			this.projId = projId;
			this.projname = projname;
			this.role = role;
			this.phone = phone;
			this.location = location;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getEmpid() {
			return empid;
		}

		public void setEmpid(Long empid) {
			this.empid = empid;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmpname() {
			return empname;
		}

		public void setEmpname(String empname) {
			this.empname = empname;
		}

		public String getUserEmailId() {
			return userEmailId;
		}

		public void setUserEmailId(String userEmailId) {
			this.userEmailId = userEmailId;
		}

		public Long getProjId() {
			return projId;
		}

		public void setProjId(Long projId) {
			this.projId = projId;
		}

		public String getProjname() {
			return projname;
		}

		public void setProjname(String projname) {
			this.projname = projname;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		