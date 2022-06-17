package com.dahae.weeklytestspring.spring0617.repository;

import com.dahae.weeklytestspring.spring0617.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByAgeAndGender(int age, int gender);

    Optional<User> findByEmail(String email);
}
