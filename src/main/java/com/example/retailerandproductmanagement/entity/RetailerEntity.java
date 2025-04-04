package com.example.retailerandproductmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RetailerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = " Name can not be empty")
    @Column(name = "NAME")
    private String name;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$" , message = "Email cann not be empty")
    @Column(unique = true, nullable = false, name = "EMAIL")
    private String email;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    public List<ProductEntity> products;

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
        if (products != null) {
            products.forEach(product -> {
                product.setName(this.name);
            });
        }
    }
}
