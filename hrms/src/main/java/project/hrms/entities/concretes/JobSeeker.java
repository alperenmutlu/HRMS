package project.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobseekers")
public class JobSeeker extends User{

//	@Id
//	@GeneratedValue
//	@Column(name= "user_id")
//	private int userId;
	
	@Column(name= "first_name")
	private String firstName;
	
	@Column(name= "last_name")
	private String lastName;
	
	@Column(name= "national_id")
	private String nationalId;
	
	@Column(name= "date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name = "is_verified", columnDefinition = "boolean default false")
	private boolean isVerified = false;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<SchoolForCV> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<ProgrammingSkillForCV> programingSkills;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<LinkForCV> links;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<ForeignLanguageForCV> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<ExperienceForCV> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<CoverLetterForCV> coverLetters;	

	//@JsonIgnore
	//@OneToOne(mappedBy = "jobSeeker", optional=false, fetch=FetchType.LAZY)
	//private ImageForCV image;
}
