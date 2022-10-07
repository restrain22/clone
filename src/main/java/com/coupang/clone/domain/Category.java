package com.coupang.clone.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
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

    @OneToMany(mappedBy = "category")
    private List<Product> product;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
