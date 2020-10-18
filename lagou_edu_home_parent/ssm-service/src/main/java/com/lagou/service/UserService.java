package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.UserVo;

public interface UserService {

    /**
     * 查询所有用户
     */
    public PageInfo findAllUserByPage(UserVo userVo);

    /**
     * 修改用户状态 *
     */
    public void updateUserStatus(Integer id, String status);

}
