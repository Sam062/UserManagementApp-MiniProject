package base.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class UserEntity {
	@Id
	@SequenceGenerator(name = "abc",sequenceName = "dbSequenceName",allocationSize = 1)
	@GeneratedValue(generator = "abc",strategy = GenerationType.SEQUENCE)
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;
	private Date dob;
	private String gender;
	private String country;
	private String state;
	private String city;
}
