package com.coupang.clone.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @OneToMany(mappedBy = "cart")
    private List<CartProduct> list = new ArrayList<>();

    @Builder
    public Cart(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", member=" + member +
                ", list=" + list +
                '}';
    }
}
