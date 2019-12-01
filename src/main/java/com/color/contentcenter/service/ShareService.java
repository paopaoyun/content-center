package com.color.contentcenter.service;

import com.color.contentcenter.dao.content.ShareMapper;
import com.color.contentcenter.domain.dto.ShareDto;
import com.color.contentcenter.domain.dto.UserDto;
import com.color.contentcenter.domain.entity.Share;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShareService {

    @Autowired
    private ShareMapper shareMapper;

    @Autowired
    private RestTemplate restTemplate;

    public ShareDto findById(Integer id){
        Share share = this.shareMapper.selectByPrimaryKey(id);
        
        //获取用户信息

        Integer userId = share.getUserId();
        String url = "http://localhost:8080/users/{id}";
        UserDto userDto = restTemplate.getForObject(
                url, UserDto.class, userId
        );

        ShareDto shareDto = new ShareDto();
        BeanUtils.copyProperties(share, shareDto);
        shareDto.setWxNickname(userDto.getWxNickname());
        return shareDto;
    }
}
