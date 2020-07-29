package base.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.StateMaster;

public interface StateMasterRepo extends JpaRepository<StateMaster, Serializable> {

}
