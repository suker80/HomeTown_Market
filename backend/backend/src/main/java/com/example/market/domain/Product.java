package com.example.market.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private boolean wish;
    private LocalDateTime uploadDate;
    private long views; //조회수
    private String productImgUrl;
    private String text; //제품 상세
    private long price;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user

//    @OneToMany(mappedBy = "product")
//    private List<Wishes> wishesList;

//    @OneToMany(mappedBy = "product")
//    private List<Talk> talkList;

    @Transient
    private long wishesCount; //찜수

    @PrePersist
    public void uploadDate() {
        this.uploadDate = LocalDateTime.now();
    }
}