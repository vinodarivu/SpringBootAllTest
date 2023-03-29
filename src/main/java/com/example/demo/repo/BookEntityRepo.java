package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BookEntity;

@Repository
public interface BookEntityRepo  extends JpaRepository<BookEntity, Long>{
	
	@Query(value = "SELECT r FROM BookEntity r where r.age=:age")
	List<BookEntity> findByAge(int age);

}
