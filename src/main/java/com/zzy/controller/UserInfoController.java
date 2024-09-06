package com.zzy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.dto.UserQuery;
import com.zzy.entity.UserInfo;
import com.zzy.entity.resp.Resp;
import com.zzy.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author zzy
 * @since 2024-09-06
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    
    private final UserInfoService userInfoService;
    
    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
    
    @PostMapping("/page")
    public Resp<?> page(@RequestBody UserQuery userQuery) {
        
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(UserInfo::getUserId);
        
        if(!"".equals(userQuery.getUserName()) && (userQuery.getUserName() != null)){
            queryWrapper.like(UserInfo::getUserName, userQuery.getUserName());
        }
        
        Page<UserInfo> page = userInfoService.page(
                new Page<>(
                        userQuery.getPageNum(),
                        userQuery.getPageSize()
                ),
                queryWrapper
        );
        return Resp.success(page);
    }
    

}




