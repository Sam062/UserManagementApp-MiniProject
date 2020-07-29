package base.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.UserAccounts;

public interface UserAccountRepo extends JpaRepository<UserAccounts, Serializable> {

}
