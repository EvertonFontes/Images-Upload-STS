package com.api.comercio.empresa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.comercio.empresa.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String>{
  
}    
