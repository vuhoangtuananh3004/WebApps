package com.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name = "Student")
public class Student {
	
	@Id
	@GenericGenerator (name = "sequence_student_id", strategy = "com.web.generatorId.StudentIdGenerator")
	@GeneratedValue (generator = "sequence_student_id")
	@Column (name = "studentId")
	private String studentId;
	@Column (name = "fname")
	private String fname;
	@Column (name = "lname")
	private String lname;
	
	

}
