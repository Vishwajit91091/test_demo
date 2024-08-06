package com.in.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="college")
public class College {

	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long collegeId;
	
	@JsonProperty
	@Column
	private String collegeName;
	
	@JsonProperty
	@Column
	private String collegeAddress;
	
	@JsonProperty
	@Column
	private String collegeGrade;

	
}
