package com.color.contentcenter.controller;

import com.color.contentcenter.domain.dto.ShareDto;
import com.color.contentcenter.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shares")
public class ShareController {

    @Autowired
    private ShareService shareService;

    @GetMapping("/{id}")
    public ShareDto findById(@PathVariable Integer id){
        return this.shareService.findById(id);
    }
}
