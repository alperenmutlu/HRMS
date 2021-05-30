package project.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@PrimaryKeyJoinColumn(name="user_id")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
public class Employer extends User{
	
//	@Id
//	@GeneratedValue
//	@Column(name= "user_id")
//	private int userId;
	
	@Column(name="website")
	private String website;
	
	@Column(name="company_name")
	private String companyName;

	@Column(name="phone_numberd")
	private String phoneNumber;
	
	@Column(name="is_verified", columnDefinition = "boolean default false")
	private boolean isVerified = false;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;
}
