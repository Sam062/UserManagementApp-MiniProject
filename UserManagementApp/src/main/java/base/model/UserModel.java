package base.model;

import java.util.Date;

import base.entity.CityMaster;
import base.entity.CountryMaster;
import base.entity.StateMaster;
import lombok.Data;

@Data
public class UserModel {
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;
	private Date dob;
	private String gender;
	private CountryMaster country;
	private StateMaster state;
	private CityMaster city;
}
