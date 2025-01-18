package com.tamara.bankappli.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tamara.bankappli.model.Company;

@Component
@Repository
public interface CompanyRepository 
	extends JpaRepository<Company, Long>, JpaSpecificationExecutor<Company>{
	
	public Company findByCompanyName(String name);

	public String getName();
	
}
