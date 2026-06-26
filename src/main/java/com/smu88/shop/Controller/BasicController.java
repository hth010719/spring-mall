package com.smu88.shop.Controller;

import com.smu88.shop.Repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class BasicController {

    @GetMapping("/")
    String hello(){
        return "forward:/index.html";
    }

    @GetMapping("/about")
    @ResponseBody//문자 그대로 보여주세요 라는뜻
    String about(){
        return "공부용 사이트에요";
    }

    @GetMapping("/mypage")
    @ResponseBody
    String mypage(){
        return "마이페이지에요";
    }

    @GetMapping("/date")
    @ResponseBody
    String date(){
        return LocalDateTime.now().toString();
    }



}
