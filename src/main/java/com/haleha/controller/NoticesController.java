package com.haleha.controller;

import com.haleha.model.Notice;
import com.haleha.repository.NoticeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoticesController {

    public static final String URL = "/notices";

    private final NoticeRepository noticeRepository;

    public NoticesController(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @GetMapping(URL)
    public List<Notice> getNotices() {
        return noticeRepository.findAllActiveNotices();
    }
}
