package com.zzy.service.impl;

import com.zzy.entity.UserInfo;
import com.zzy.mapper.UserInfoMapper;
import com.zzy.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author zzy
 * @since 2024-09-06
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
