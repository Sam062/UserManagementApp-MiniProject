package base.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.CityMaster;

public interface CityMasterRepo extends JpaRepository<CityMaster, Serializable>{

	List<CityMaster> findByStateID(Integer countryID);

}
