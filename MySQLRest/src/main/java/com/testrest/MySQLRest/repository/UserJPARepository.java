package com.testrest.MySQLRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.testrest.MySQLRest.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserJPARepository extends JpaRepository<User, Long> {

    User findByName(String firstname);
}
