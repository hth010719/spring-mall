package com.smu88.shop.Service;

import com.smu88.shop.Entity.Notice;
import com.smu88.shop.Repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;
    public List<Notice> findAllNotice(){
        return noticeRepository.findAll();
    }
}
