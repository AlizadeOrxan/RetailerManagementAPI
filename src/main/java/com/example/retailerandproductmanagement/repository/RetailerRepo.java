package com.example.retailerandproductmanagement.repository;

import com.example.retailerandproductmanagement.entity.RetailerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailerRepo extends JpaRepository<RetailerEntity, Long> {
}
