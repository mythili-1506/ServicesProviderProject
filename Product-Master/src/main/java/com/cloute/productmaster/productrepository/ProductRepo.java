package com.cloute.productmaster.productrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloute.productmaster.productenity.ProductMaster;

public interface ProductRepo extends JpaRepository<ProductMaster, Long> {

	List<ProductMaster> findByProductStatus(int i);

}
