package base.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity 
@Table(name = "USER_ACCOUNT")
public class UserAccounts {
	@Id
	@GeneratedValue
	private Integer userID;
	@Column(name = "FNAME")
	private String firstName;
	@Column(name = "LNAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "MOB")
	private String phoneNo;
	@Column(name = "DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column(name = "GENDER")
	private Character gender;

	@Column(name = "CNTRY_ID")
	private Integer countryID;
	@Column(name = "STATE_ID")
	private Integer stateID;
	@Column(name = "CITY_ID")
	private Integer cityID;

	@Column(name = "CREATED_DATE",updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@Column(name = "UPDATED_DATE",insertable = false)
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updatedDate;

	@Column(name = "ACC_STATUS")
	private String accountStatus;

	@Column(name = "USER_PWD")
	private String password;
}
