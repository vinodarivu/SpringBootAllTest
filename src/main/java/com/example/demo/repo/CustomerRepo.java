package com.example.demo.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Customer r where r.id IN (:id)")
	public void  deleteAllById(Set<Long> id);

}
