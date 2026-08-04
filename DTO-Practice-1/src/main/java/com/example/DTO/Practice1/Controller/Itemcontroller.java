package com.example.DTO.Practice1.Controller;

import com.example.DTO.Practice1.Entity.Item;
import com.example.DTO.Practice1.Service.Itemservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class Itemcontroller {
    private final Itemservice itemservice;

    public Itemcontroller(Itemservice itemservice) {
        this.itemservice = itemservice;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getRequest(){
        List<Item> list = itemservice.get();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Item> postRequest(@RequestBody Item item){
        Item savedItem = itemservice.post(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }
}