package com.pruebaNisum.pruebaNisum.repository;

import com.pruebaNisum.pruebaNisum.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhoneRepository extends JpaRepository<Phone,String> {
}
