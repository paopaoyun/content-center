package com.color.contentcenter.controller;

import com.color.contentcenter.dao.content.ShareMapper;
import com.color.contentcenter.domain.entity.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ContentController {

    @Autowired
    private ShareMapper shareMapper;

    @GetMapping("/addShare")
    public Share addShare(){
        Share share = new Share();
        share.setAuthor("xxx");
        share.setBuyCount(10);
        share.setCreateTime(new Date());
        share.setUpdateTime(new Date());
        share.setCover("xxx");
        this.shareMapper.insertSelective(share);

        return share;
    }

}
