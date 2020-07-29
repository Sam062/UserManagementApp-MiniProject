package base.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.StateMaster;

public interface StateMasterRepo extends JpaRepository<StateMaster, Serializable> {
	List<StateMaster> findByCountryID(Integer id);

}
