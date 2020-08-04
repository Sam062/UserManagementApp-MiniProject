package base.service;

import java.util.Map;

import base.model.UnlockAccount;
import base.model.UserModel;

public interface IUserService {
	Map<Integer, String> getAllCountry();
	Map<Integer, String> getStatesByCountryID(Integer id);
	Map<Integer, String> getCityByStateID(Integer stateID);
	Boolean saveUser(UserModel umodel);

	String findByUserEmail(String email);
	UserModel findByEmailAndPassword(String email, String pwd);
	Boolean updateUserAccount(UnlockAccount unAccount);
}
