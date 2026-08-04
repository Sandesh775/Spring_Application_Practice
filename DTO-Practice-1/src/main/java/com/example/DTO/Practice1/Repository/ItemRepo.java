package com.example.DTO.Practice1.Repository;

import com.example.DTO.Practice1.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,Integer> {
}
