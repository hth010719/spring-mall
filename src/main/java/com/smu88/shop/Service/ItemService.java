package com.smu88.shop.Service;

import com.smu88.shop.Entity.Item;
import com.smu88.shop.Repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(String title, String price) throws Exception {

        if (price==null){
            throw new Exception("가격을 입력해주십시오");
        }

        long parsedPrice;

        try {
            parsedPrice=Long.parseLong(price);
        }catch (NumberFormatException e){
            throw new Exception("가격은 숫자로 입력해주세요");
        }
        if (parsedPrice < 0) {
            throw new Exception("가격은 음수가 될 수 없습니다.");
        }
        if (parsedPrice > 100000000) {
            throw new Exception("가격이 너무 큽니다.");
        }

        if (title==null || title.isBlank()){
            throw new Exception("상품명을 입력해주세요");
        }
        if (title.length()>20){
            throw new Exception("상품명이 너무 깁니다.");
        }


        Item item = new Item();
        item.setTitle(title);
        item.setPrice((int)parsedPrice);
        itemRepository.save(item);

    }
    public List<Item> findAllItems(){
        return itemRepository.findAll();
    }
    public Item findItemById(Long id) throws Exception {
        return itemRepository.findById(id)
                .orElseThrow(()->new Exception("상품을 찾을수없습니다"));
    }

    public void updateItem(Long id, String title, Integer price) throws Exception {
        Item item=findItemById(id);

        item.setTitle(title);
        item.setPrice(price);

        itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

}
