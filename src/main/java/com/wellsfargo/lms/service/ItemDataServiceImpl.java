package com.wellsfargo.lms.service;

import com.wellsfargo.lms.model.Item;
import com.wellsfargo.lms.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDataServiceImpl implements ItemDataService{
    @Autowired
    ItemRepository itemRepository;
    @Override
    public String addItemData(Item itemDto) {
        try {
            itemRepository.save(itemDto);
            return "Item Saved Succesfully";
        } catch (Exception e) {
            return "Item NOT saved :-( !!!";
        }
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
