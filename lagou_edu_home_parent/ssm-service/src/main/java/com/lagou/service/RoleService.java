package com.lagou.service;

import com.lagou.domain.Menu;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;
import com.lagou.domain.Role_menu_relation;

import java.util.List;

public interface RoleService {

    public List<Role> findAllRole(Role role);

    /**
     * 修改角色
     */
    void updateRole(Role role);

    /**
     * 保存角色
     *
     * @param role
     */
    void saveRole(Role role);

    /**
     *  根据ID查询角色关联菜单
     * */
    List<String> findMenuByRoleId(Integer roleId);

    /**
     * 为角色分配菜单信息
     */
    public void roleContextMenu(RoleMenuVo roleMenuVo);

    /**
     *  删除角色
     *  */
    void deleteRole(Integer id);



}
