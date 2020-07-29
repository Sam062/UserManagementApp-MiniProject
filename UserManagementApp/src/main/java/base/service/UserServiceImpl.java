package base.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.entity.CountryMaster;
import base.entity.UserAccounts;
import base.model.UserModel;
import base.pwdGenerater.RandomPwdGenerater;
import base.repo.CountryMasterRepo;
import base.repo.UserAccountRepo;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private CountryMasterRepo countryMasterRepo;
	@Autowired
	private UserAccountRepo uaRepo;

	@Override
	public Map<Integer, String> getAllCountry() {
		List<CountryMaster> list = countryMasterRepo.findAll();

		Map<Integer, String> countryMap=new LinkedHashMap<>();
		list.forEach(entity->{
			countryMap.put(entity.getCountryID(), entity.getCountryName());
		});

		return countryMap;
	}

	@Override
	public Boolean saveUser(UserModel umodel) {
		UserAccounts ua=new UserAccounts();
		BeanUtils.copyProperties(umodel, ua);
		ua.setAccountStatus("LOCKED");
		ua.setPassword(RandomPwdGenerater.randomAlphaNumeric(7));

		UserAccounts save = uaRepo.save(ua);
		if(save==null)
			return false;
		return true;
	}
}
