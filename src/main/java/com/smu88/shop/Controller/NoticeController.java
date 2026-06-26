package com.smu88.shop.Controller;

import com.smu88.shop.Entity.Notice;
import com.smu88.shop.Repository.NoticeRepository;
import com.smu88.shop.Service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {
    
    private final NoticeService noticeService;

    @GetMapping("/notice")
        String noticelist(Model model){
        List<Notice> result= noticeService.findAllNotice();
        model.addAttribute("notices",result);
        return "notice.html";
        }
}
