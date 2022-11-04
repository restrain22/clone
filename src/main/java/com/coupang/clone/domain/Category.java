package com.coupang.clone.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"product"})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    private String description;

    @Builder
    public Category(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "category")
    private List<Product> product;
}
