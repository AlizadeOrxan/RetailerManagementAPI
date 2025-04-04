package com.example.retailerandproductmanagement.repository;

import com.example.retailerandproductmanagement.entity.ProductEntity;
import com.example.retailerandproductmanagement.entity.RetailerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByRetailer(Long retailerId);
}
