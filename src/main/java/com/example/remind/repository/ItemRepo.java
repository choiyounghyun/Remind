package com.example.remind.repository;

import com.example.remind.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, Long>,  QuerydslPredicateExecutor<Item> {
    List<Item> findByItemName(String itemName);

    @Query("select i from Item i where i.description like %:itemDetail% order by i.price")
    List<Item> findByDescription(@Param("itemDetail") String itemDetail);



}
