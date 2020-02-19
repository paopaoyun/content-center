package com.color.contentcenter.service;

import com.color.contentcenter.dao.content.ShareMapper;
import com.color.contentcenter.domain.dto.ShareDto;
import com.color.contentcenter.domain.dto.UserDto;
import com.color.contentcenter.domain.entity.Share;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ShareService {

    @Autowired
    private ShareMapper shareMapper;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    public ShareDto findById(Integer id){
        Share share = this.shareMapper.selectByPrimaryKey(id);
        //获取用户信息
        Integer userId = share.getUserId();
        List<ServiceInstance> instances = discoveryClient.getInstances("user-center-service");
        String url = instances.stream()
                .map(instance -> instance.getUri().toString() + "/users/{id}")
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("没有查到该实例"));

        //String url = "http://user-center/users/{id}";
        UserDto userDto = restTemplate.getForObject(
                url, UserDto.class, userId
        );

        ShareDto shareDto = new ShareDto();
        BeanUtils.copyProperties(share, shareDto);
        shareDto.setWxNickname(userDto.getWxNickname());
        return shareDto;
    }
}
