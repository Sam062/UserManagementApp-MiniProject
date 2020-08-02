package base.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.UserAccounts;

public interface UserAccountRepo extends JpaRepository<UserAccounts, Serializable> {
	List<UserAccounts> findByEmail(String email);

}
