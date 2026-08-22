package com.example.DTO.Practice1.Service;

import com.example.DTO.Practice1.DTO.RequestDTO;
import com.example.DTO.Practice1.DTO.ResponseDTO;
import com.example.DTO.Practice1.Entity.Item;
import com.example.DTO.Practice1.Entity.Status;
import com.example.DTO.Practice1.Repository.ItemRepo;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Itemservice {
    private final ItemRepo itemRepo;

    public Itemservice(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public List<ResponseDTO> get(){

        List<Item> items = itemRepo.findAll();

        List<ResponseDTO> response = new ArrayList<>();

        for(Item item : items){

            ResponseDTO dto = new ResponseDTO();

            dto.setId(item.getId());
            dto.setTitle(item.getTitle());
            dto.setDescription(item.getDescription());
            dto.setStatus(item.getStatus());
            dto.setCreatedAt(item.getCreatedAt());
            dto.setUpdatedAt(item.getUpdatedAt());

            response.add(dto);
        }

        return response;
    }

    public ResponseDTO post(RequestDTO dto){

        Item item = new Item();

        item.setTitle(dto.getTitle());
        item.setDescription(dto.getDescription());

        item.setStatus(Status.PENDING);
        item.setCreatedAt(LocalDate.now());
        item.setUpdatedAt(LocalDate.now());

        Item savedItem = itemRepo.save(item);

        ResponseDTO response = new ResponseDTO();

        response.setId(savedItem.getId());
        response.setTitle(savedItem.getTitle());
        response.setDescription(savedItem.getDescription());
        response.setStatus(savedItem.getStatus());
        response.setCreatedAt(savedItem.getCreatedAt());
        response.setUpdatedAt(savedItem.getUpdatedAt());

        return response;
    }
 }
