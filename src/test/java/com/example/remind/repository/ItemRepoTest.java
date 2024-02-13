package com.example.remind.repository;

import com.example.remind.entity.Item;
import com.example.remind.entity.QItem;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemRepoTest {
    @Autowired
    ItemRepo itemRepo;

    @PersistenceContext
    EntityManager em;

//    @Test
    public void createItemList(){
        for(int i=0; i<10; i++){
            Item item = new Item();
            item.setItemName("테스트상품"+(i+1));
            item.setDescription("설명 "+(i+1));
            item.setPrice((i+1)*1000);
            itemRepo.save(item);
        }
    }

    public void createItemList2(){
        for(int i=0; i<5; i++){
            Item item = new Item();
            item.setItemName("테스트상품"+(i+1));
            item.setDescription("설명 "+(i+1));
            item.setPrice((i+1)*1000);
            item.setSellOrNot("SOLD OUT");
            item.setStock(0);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            itemRepo.save(item);
        }
        for(int i=5; i<10; i++){
            Item item = new Item();
            item.setItemName("테스트상품"+(i+1));
            item.setDescription("설명 "+(i+1));
            item.setPrice((i+1)*1000);
            item.setSellOrNot("SELL");
            item.setStock(100);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            itemRepo.save(item);
        }
    }

    @Test
    public void findByItemNameTest(){
        this.createItemList();
        List<Item> itemList = itemRepo.findByItemName("테스트상품");

        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }

    @Test
    public void findByDescriptionTest(){
        this.createItemList();
        List<Item> itemList = itemRepo.findByDescription("설명");
       for(Item item : itemList){
           System.out.println(item.toString());
//           System.out.println(item.getDescription());
       }
    }

    @Test
    @DisplayName("querydsl 조회 테스트 1 ")
    public void querydslTest(){
        this.createItemList();
        JPAQueryFactory queryFactory= new JPAQueryFactory(em);
//        QItem qItem = new QItem("item");
        QItem qItem = QItem.item;
        JPAQuery<Item> query = queryFactory.selectFrom(qItem)
                .where(qItem.description.like("%"+"설명"+"%"))
                .orderBy();
//                .orderBy(qItem.price.desc());

        List<Item> itemList = query.fetch();

        for(Item item : itemList){
            System.out.println("this : "+item.toString());
        }
    }

    @Test
    public void querydslTest2(){
        this.createItemList2();

        BooleanBuilder builder = new BooleanBuilder();
        QItem qItem = QItem.item;
        String detail = "테스트상품 상세설명";
        int price = 1000;
        String sellOrNot = "sell";

        builder.and(qItem.price.gt(price));

    }

}