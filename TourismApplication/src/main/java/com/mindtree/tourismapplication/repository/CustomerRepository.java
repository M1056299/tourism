package com.mindtree.tourismapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.tourismapplication.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	

}
