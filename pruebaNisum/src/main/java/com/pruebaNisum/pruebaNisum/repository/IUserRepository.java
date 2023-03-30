package com.pruebaNisum.pruebaNisum.repository;

import com.pruebaNisum.pruebaNisum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,String> {

    boolean existsByEmail(String email);
}
