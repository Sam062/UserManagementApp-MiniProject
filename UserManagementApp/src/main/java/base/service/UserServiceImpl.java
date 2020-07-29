package base.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	public Map<Integer, String> getAllCountry() {
		List<CountryMaster> list = countryMasterRepo.findAll();
		Map<Integer, String> countryMap=new LinkedHashMap<>();
		list.forEach(entity->{
			countryMap.put(entity.getCountryID(), entity.getCountryName());
		});
		return countryMap;
	}

	public Map<Integer, String> getStatesByCountryID(Integer id){
		List<StateMaster> statesList = stateMasterRepo.findByCountryID(id);
		Map<Integer, String> stateMap=new LinkedHashMap<>();
		statesList.forEach(states->{
			stateMap.put(states.getStateID(), states.getStateName());
		});
		return stateMap;
	}
	@Override
	public Map<Integer, String> getCityByStateID(Integer stateID) {
		List<CityMaster> cityList = cityMasterRepo.findByStateID(stateID);
		Map<Integer, String> cityMap=new LinkedHashMap<>();
		cityList.forEach(states->{
			cityMap.put(states.getCityID(), states.getCityName());
		});
		return cityMap;
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
