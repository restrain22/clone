package com.coupang.clone.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"list"})
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @OneToOne
    @JoinColumn(name="member_id")
    private Member member;

    private int count;

    @JsonManagedReference
    @OneToMany(mappedBy = "cart")
    private List<CartProduct> list = new ArrayList<>();

    @Builder
    public Cart(Member member, int count) {
        this.member = member;
        this.count = count;
    }
}
