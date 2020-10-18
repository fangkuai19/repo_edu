package com.lagou.dao;

import com.lagou.domain.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {

    /**
     * 查询全部的父子菜单信息
     */
    public List<Menu> findSubMenuListByPid(Integer pid);

    /*** 查询菜单列表 * */
    public List<Menu> findAllMenu();


    Menu findMenuById(Integer id);
}
