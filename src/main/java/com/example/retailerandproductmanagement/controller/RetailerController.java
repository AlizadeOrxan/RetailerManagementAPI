package com.example.retailerandproductmanagement.controller;
import com.example.retailerandproductmanagement.service.RetailerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/retailer")
public class RetailerController {

    private RetailerService retailerService;


    public RetailerController(RetailerService retailerService) {
        this.retailerService = retailerService;
    }

}
