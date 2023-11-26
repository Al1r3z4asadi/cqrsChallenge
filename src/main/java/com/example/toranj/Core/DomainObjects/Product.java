package com.example.toranj.Core.DomainObjects;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Product")
@Table(
        name = "product"
)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "product_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id ;
    private BigDecimal price ;
    private String name ;
    private int count_available ;

    public Product(String name, BigDecimal price, String countAvailable) {
    }
}
