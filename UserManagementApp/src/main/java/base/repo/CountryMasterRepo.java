package base.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.CountryMaster;

public interface CountryMasterRepo extends JpaRepository<CountryMaster, Serializable> {

}
