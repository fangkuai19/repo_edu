package com.lagou.service;

import com.lagou.domain.Menu;

import java.util.List;

public interface MenuService {

    /** * 查询全部的父子菜单信息 * */
    public List<Menu> findSubMenuListByPid(Integer pid);

    /*** 查询菜单列表 * */
    public List<Menu> findAllMenu();


    Menu findMenuById(Integer id);
}
