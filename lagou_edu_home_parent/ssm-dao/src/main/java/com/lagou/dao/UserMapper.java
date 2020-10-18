package com.lagou.dao;

import com.lagou.domain.User;
import com.lagou.domain.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 查询所有用户
     */
    public List<User> findAllUserByPage(UserVo userVo);

    /*** 修改用户状态 * */
    public void updateUserStatus(@Param("id") Integer id, @Param("status") String status);


}
