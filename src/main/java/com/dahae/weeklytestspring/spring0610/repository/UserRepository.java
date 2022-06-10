package com.dahae.weeklytestspring.spring0610.repository;

import com.dahae.weeklytestspring.spring0610.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>  {
    List<User> findByAgeAndGender(int age, int gender);
}
