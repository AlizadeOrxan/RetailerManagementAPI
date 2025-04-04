package com.example.retailerandproductmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name must be mandatory")
    @Column(name = "ProductName")
    private String name;

    @NotEmpty(message = "Price can not be blank ")
    @Column(name = "Price")

    private Double price;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "retailer_id")
    private RetailerEntity retailer;



}
