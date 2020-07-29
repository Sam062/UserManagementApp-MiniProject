package base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "COUNTRY_MASTER")
public class CountryMaster {
	@Id
	@Column(name = "CNTRY_ID")
	private Integer countryID;
	@Column(name = "CNTRY_NAME")
	private String countryName;
	
//	@OneToMany
//	private StateMaster stateMaster;

}
