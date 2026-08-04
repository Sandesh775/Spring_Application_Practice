package com.example.DTO.Practice1.Service;

import com.example.DTO.Practice1.Entity.Item;
import com.example.DTO.Practice1.Repository.ItemRepo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class Itemservice {
    private final ItemRepo itemRepo;

    public Itemservice(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public List<Item> get(){
        return itemRepo.findAll();
    }

    public Item post(Item item){
        return itemRepo.save(item);
    }
 }
