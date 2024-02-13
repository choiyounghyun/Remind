package com.example.remind.entity;

import jdk.jfr.Description;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
public class Item {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String itemName;
    @Column
    private int price;
    @Column
    @Description("재고수량")
    private int stock;
    @Column
    private String description;
    @Column
    private String sellOrNot;
    @Column
    private LocalDateTime regTime;
    @Column
    private LocalDateTime updateTime;

}
