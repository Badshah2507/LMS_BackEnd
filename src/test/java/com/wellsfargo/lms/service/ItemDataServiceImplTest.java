package com.wellsfargo.lms.service;

import com.wellsfargo.lms.model.Item;
import com.wellsfargo.lms.model.LoanCard;
import com.wellsfargo.lms.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ItemDataServiceImplTest {

    @Autowired
    ItemDataService itemDataService;
    @MockBean
    ItemRepository itemRepository;


    @Test
    void addItemData() {
        Item itemObj = Item.builder()
                .itemId("I0001")
                .itemCategory("Furniture")
                .itemDescription("Tea Table")
                .itemMake("Wooden")
                .itemValuation(5000)
                .build();

        String response = itemDataService.addItemData(itemObj);
        assertEquals("Item Saved Succesfully", response);
    }

    @Test
    void getAllItems() {
        Item itemObj1 = Item.builder()
                .itemId("I0001")
                .itemCategory("Furniture")
                .itemDescription("Tea Table")
                .itemMake("Wooden")
                .itemValuation(5000)
                .build();
        Item itemObj2 = Item.builder()
                .itemId("I0002")
                .itemCategory("Stationery")
                .itemDescription("Pen")
                .itemMake("Plastic")
                .itemValuation(500)
                .build();
        List<Item> res = new ArrayList<>();
        res.add(itemObj1);
        res.add(itemObj2);

        when(itemRepository.findAll()).thenReturn(res);

        List<Item> response = itemDataService.getAllItems();
        assertEquals("I0001", response.get(0).getItemId());
        assertEquals("I0002", response.get(1).getItemId());
        assertEquals("Furniture", response.get(0).getItemCategory());
        assertEquals("Stationery", response.get(1).getItemCategory());
        assertEquals("Tea Table", response.get(0).getItemDescription());
        assertEquals("Pen", response.get(1).getItemDescription());
        assertEquals("Wooden", response.get(0).getItemMake());
        assertEquals("Plastic", response.get(1).getItemMake());
        assertEquals(5000, response.get(0).getItemValuation());
        assertEquals(500, response.get(1).getItemValuation());
    }

}