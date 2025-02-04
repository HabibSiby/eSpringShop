package com.shop.espringshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private int price;
    @Column(name="discounted_price")
    private int discountedPrice;
    @Column(name="discount_persent")
    private int discountPersent;
    private int quantity;
    private String brand;
    private String color;

   // @Embedded
    @ElementCollection
    @Column(name="sizes")
    private Set<Size> sizes = new HashSet<>();
    @Column(name="image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @Column(name="num_ratings")
    private int numRatings;

    @ManyToOne()
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private LocalDateTime createdAt;


}
