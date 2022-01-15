package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
@EnableJpaRepositories
public interface JpaRepo extends JpaRepository<Employee, Integer> {
	public List<Employee> findByName(String name);

	@Query("from Employee where designation = ?1 order by name")
	List<Employee> findByDesignation(String designation);
}
