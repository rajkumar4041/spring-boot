package com.selfGroup.firstEmpCrud.repository;

import com.selfGroup.firstEmpCrud.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PhoneRepository extends JpaRepository<Phone,Integer> {
}
