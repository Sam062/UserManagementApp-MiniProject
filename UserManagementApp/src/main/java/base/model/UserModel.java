package base.model;

import java.util.Date;

import lombok.Data;

@Data
public class UserModel {
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
