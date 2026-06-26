package com.smu88.shop.Controller;

import com.smu88.shop.Entity.Item;
import com.smu88.shop.Repository.ItemRepository;
import com.smu88.shop.Service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/list")
    String list(Model model) {

        List<Item> result = itemService.findAllItems();
//        System.out.println(result.get(0).price);
//        System.out.println(result.get(0).title);

//        List<Object> a = new ArrayList<>();
//        a.add(30);
//        a.add(40);
//        System.out.println(a.get(0));
//        System.out.println(a.get(1));

        model.addAttribute("items", result);

        return "list.html";
    }

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(String title, String price, Model model) {
//    String addPost(@RequestParam Map formData) {
//
//        HashMap<String, Object> test = new HashMap<>();
//        test.put("name", "kim");
//        test.put("age", 20);
        try {
            itemService.saveItem(title, price);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "write.html";
        }
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) throws Exception {

        try {
            Item result = itemService.findItemById(id);
            model.addAttribute("data", result);
            return "detail.html";
        } catch (Exception e) {
            return "redirect:/list";
        }
    }

    @GetMapping("/update/{id}")
    String update(@PathVariable Long id, Model model) {

        try {
            Item result = itemService.findItemById(id);
            model.addAttribute("data", result);
            return "update.html";
        } catch (Exception e) {
            return "redirect:/list";
        }
    }

    @PostMapping("/update/{id}")
    String updatePost(@PathVariable Long id, String title, Integer price, Model model) {
        try {
            itemService.updateItem(id, title, price);
            return "redirect:/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "update.html";
        }

    }

    @PostMapping("/test1")
    String test1(@RequestBody Map<String, Object> body){
        System.out.println(body);
        return "redirect:/list";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    String deleteItem(@PathVariable Long id){
        try{
            itemService.deleteItem(id);
            return "ok";
        } catch (Exception e) {
            return "fail";
        }
    }

}
