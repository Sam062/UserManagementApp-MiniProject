package base.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.constents.AppConstents;
import base.entity.CityMaster;
import base.entity.CountryMaster;
import base.entity.StateMaster;
import base.entity.UserAccounts;
import base.model.UnlockAccount;
import base.model.UserModel;
import base.pwdGenerater.RandomPwdGenerater;
import base.repo.CityMasterRepo;
import base.repo.CountryMasterRepo;
import base.repo.StateMasterRepo;
import base.repo.UserAccountRepo;
import base.util.EmailUtils;

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
	@Autowired
	private EmailUtils emailUtils;

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
		umodel.setAccountStatus(AppConstents.ACC_STATUS);
		umodel.setPassword(RandomPwdGenerater.randomAlphaNumeric(AppConstents.PWD_LENGTH));
		UserAccounts ua=new UserAccounts();
		BeanUtils.copyProperties(umodel, ua);

		UserAccounts userAcc = uaRepo.save(ua);
		if(userAcc.getUserID()!=null)
			return emailUtils.sendUserUnlockEmail(userAcc);

		return false;
	}

	@Override
	public String findByUserEmail(String email) {
		UserAccounts accounts = uaRepo.findByEmail(email);
		if(accounts!=null)
			return "duplicate";
		return "unique";
	}

	@Override
	public UserModel findByEmailAndPassword(String email, String pwd) {
		UserAccounts entity = uaRepo.findByEmailAndPassword(email, pwd);
		UserModel model=null;
		if(entity!=null) {
			model=new UserModel();
			BeanUtils.copyProperties(entity, model);
		}
		return model;
	}
	@Override
	public Boolean updateUserAccount(UnlockAccount unlAccount) {
		UserAccounts userAccounts = uaRepo.findByEmail(unlAccount.getEmail());
		if(userAccounts==null)
			return false;
		else {
			userAccounts.setPassword(unlAccount.getNewPwd());
			userAccounts.setAccountStatus("UN-LOCKED");
			uaRepo.save(userAccounts);
			return true;
		}
	}
}
