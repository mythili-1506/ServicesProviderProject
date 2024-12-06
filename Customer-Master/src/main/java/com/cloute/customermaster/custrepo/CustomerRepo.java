package com.cloute.customermaster.custrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloute.customermaster.custentity.CustomerEntity;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Long>{

	List<CustomerEntity> findByCustStatus(int i);
	
}
