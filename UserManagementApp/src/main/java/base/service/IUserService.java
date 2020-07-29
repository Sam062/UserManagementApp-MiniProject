package base.service;

import java.util.Map;

import base.model.UserModel;

public interface IUserService {
	Map<Integer, String> getAllCountry();
	Boolean saveUser(UserModel umodel);

}
