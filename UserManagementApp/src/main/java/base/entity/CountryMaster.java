package base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CNTRY_MSTR")
public class CountryMaster {
	@Id
	@GeneratedValue
	@Column(name = "CNTRY_ID")
	private Integer countryID;
	@Column(name = "CNTRY_NAME")
	private String countryName;
	
}
