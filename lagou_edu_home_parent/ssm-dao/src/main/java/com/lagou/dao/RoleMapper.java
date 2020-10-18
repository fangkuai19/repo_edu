package com.lagou.dao;

import com.lagou.domain.Menu;
import com.lagou.domain.Role;
import com.lagou.domain.Role_menu_relation;

import java.util.List;

public interface RoleMapper {

    /**
     * 查询角色列表(条件)
     */
    public List<Role> findAllRole(Role role);

    /**
     * 修改角色
     *
     * @param role
     */
    public void updateRole(Role role);

    /**
     * 保存角色
     *
     * @param role
     */
    public void saveRole(Role role);

    /**
     * 根据角色ID查询菜单信息
     */
    List<String> findMenuByRoleId(Integer roleId);

    /**
     * 根据roleid清空中间表的关联关系
     */
    public void deleteRoleContextMenu(Integer rid);

    /**
     * 为角色分配菜单信息
     */
    public void roleContextMenu(Role_menu_relation role_menu_relation);

    /**
     * 删除角色
     */
    void deleteRole(Integer id);



}
