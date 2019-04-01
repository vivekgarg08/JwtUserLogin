package com.vivek.userLoginRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.userLoginModel.Users;



public interface UserLoginRepository extends JpaRepository<Users, Integer> {
	
	Optional<List<Users>> findByFirstName(String firstName);
     

	Optional<Users> findByUserID(String userID);

}
