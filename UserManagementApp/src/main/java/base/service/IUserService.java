package base.service;

import java.util.List;

import base.entity.CityMaster;
import base.entity.CountryMaster;
import base.entity.StateMaster;
import base.model.UserModel;

public interface IUserService {
	List<CountryMaster> getAllCountry();
	List<StateMaster> getAllState();
	List<CityMaster> getAllCity();
	Boolean saveUser(UserModel umodel);

}
