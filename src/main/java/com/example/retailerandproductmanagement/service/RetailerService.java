package com.example.retailerandproductmanagement.service;

import com.example.retailerandproductmanagement.entity.ProductEntity;
import com.example.retailerandproductmanagement.entity.RetailerEntity;
import com.example.retailerandproductmanagement.exception.RetailerNotFoundException;
import com.example.retailerandproductmanagement.repository.ProductRepo;

import com.example.retailerandproductmanagement.repository.RetailerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.naming.Binding;
import java.util.List;

@Service
@Slf4j
public class RetailerService {

    private ProductRepo productRepo;
    private RetailerRepo retailerRepo;

    public RetailerService(ProductRepo productRepo, RetailerRepo retailerRepo) {
        this.productRepo = productRepo;
        this.retailerRepo = retailerRepo;
    }


    // Retailer service

    public List<RetailerEntity> findAll() {
        return retailerRepo.findAll();
    }

    public RetailerEntity findById(Long id) {
        RetailerEntity retailerEntity = retailerRepo.findById(id).get();
        if (retailerEntity == null) {
            throw new RetailerNotFoundException( "Retailer with id " + id + " not found");
        }
        return retailerEntity;
    }

    public RetailerEntity save(RetailerEntity retailerEntity){
        RetailerEntity retailer = retailerRepo.save(retailerEntity);
        if (retailer == null) {
            throw new RetailerNotFoundException( "Retailer with id " + retailer.getId() + " not found");
        }
        return retailer;
    }

    public RetailerEntity updateRetailer (Long id, RetailerEntity retailerEntity){
        RetailerEntity retailer = retailerRepo.findById(id).get();
        if (retailer == null) {
            throw new RetailerNotFoundException( "Retailer with id " + id + " not found");
        }
        retailer.setName(retailerEntity.getName());
        retailerRepo.save(retailer);
        return retailer;
    }

    public void deleteRetailer (Long id){
        RetailerEntity retailer = retailerRepo.findById(id).get();
        if (retailer == null) {
            throw new RetailerNotFoundException( "Retailer with id " + id + " not found");
        }
        retailerRepo.delete(retailer);

    }
    //Retailer end

    // Product Service


    public RetailerEntity addProducts(Long id, List<ProductEntity> products) {
        RetailerEntity retailer = findById(id);
        for (ProductEntity product : products) {
            product.setRetailer(retailer);
        }
        retailer.getProducts().addAll(products);
        return retailerRepo.save(retailer);
    }

    public List<ProductEntity> getProducts(Long id) {
        return findById(id).getProducts();
    }

    public List<ProductEntity> findByRetailerId(Long retailerId) {
        return productRepo.findByRetailer(retailerId);
    }


    //
}
