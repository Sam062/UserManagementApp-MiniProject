package base.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.entity.CityMaster;
import base.entity.CountryMaster;
import base.entity.StateMaster;
import base.entity.UserAccounts;
import base.model.UserModel;
import base.pwdGenerater.RandomPwdGenerater;
import base.repo.CityMasterRepo;
import base.repo.CountryMasterRepo;
import base.repo.StateMasterRepo;
import base.repo.UserAccountRepo;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private CountryMasterRepo countryMasterRepo;
	@Autowired
	private StateMasterRepo stateMasterRepo;
	@Autowired
	private CityMasterRepo cityMasterRepo;
	@Autowired
	private UserAccountRepo uaRepo;

	@Override
	public List<CountryMaster> getAllCountry() {
		List<CountryMaster> findAll = countryMasterRepo.findAll();
		if(null!=findAll)
			return findAll;
		else 
			return null;
	}

	@Override
	public List<StateMaster> getAllState() {
		List<StateMaster> findAll = stateMasterRepo.findAll();
		if(null!=findAll)
			return findAll;
		else 
			return null;
	}
	@Override
	public List<CityMaster> getAllCity() {
		List<CityMaster> findAll = cityMasterRepo.findAll();
		if(null!=findAll)
			return findAll;
		else 
			return null;

	}

	@Override
	public Boolean saveUser(UserModel umodel) {
		UserAccounts ua=new UserAccounts();
		BeanUtils.copyProperties(umodel, ua);
		ua.setCountryID(umodel.getCountry().getCountryID());
		ua.setStateID(umodel.getState().getStateID());
		ua.setCityID(umodel.getCity().getCityID());
		ua.setAccountStatus("LOCKED");
		ua.setPassword(RandomPwdGenerater.randomAlphaNumeric(7));

		UserAccounts save = uaRepo.save(ua);
		if(save==null)
			return false;
		return true;
	}
}
