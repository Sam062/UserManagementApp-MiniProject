package base.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
@Data
public class UserModel {
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;
	private Date dob;
	private Character gender;
	private Integer countryID;
	private Integer stateID;
	private Integer cityID;
	private String accountStatus;
	private String password;
	
	public Date getDob() {
		return dob;
	}
	public void setDob(String dob) throws ParseException {
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd"); 
		Date date=f.parse(dob);  
		this.dob = date;
	}
}
