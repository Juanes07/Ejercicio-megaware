package com.sofka.service;

import com.sofka.domain.Item;
import com.sofka.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;


    public List<Item> getItemDesc(){
        return (List<Item>) itemRepository.getItemDesc();
    }

    public List<Item> getItemAsc(){
        return (List<Item>) itemRepository.getItemAsc();
    }
}
