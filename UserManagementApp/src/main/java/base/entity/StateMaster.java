package base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "STATE_MASTER")
public class StateMaster {
	@Id
	@Column(name = "STATE_ID")
	private Integer stateID;
	@Column(name = "STATE_NAME")
	private String stateName;
	@Column(name = "CNTRY_ID")
	private Integer countryID;
}
