package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    /**
     * 查询所有角色（条件）
     *
     * @param role
     * @return
     */
    @RequestMapping("/findAllRole")
    public ResponseResult findAllUserByPage(@RequestBody Role role) {
        List<Role> allRole = roleService.findAllRole(role);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", allRole);
        return responseResult;
    }

    /**
     * 修改或保存角色信息
     *
     * @param role
     * @return
     */
    @RequestMapping("/saveOrUpdateRole")
    public ResponseResult saveOrUpdateRole(@RequestBody Role role) {

        if (role.getId() != null) {
            //修改
            roleService.updateRole(role);
            ResponseResult responseResult = new ResponseResult(true, 200, "修改角色信息成功", null);
            return responseResult;
        } else {
            //新增
            roleService.saveRole(role);
            ResponseResult responseResult = new ResponseResult(true, 200, "添加角色信息成功", null);
            return responseResult;
        }
    }


    /**
     * 查询所有父子菜单信息
     */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu() {
        //-1 表示查询所有菜单数据
        List<Menu> menuList = menuService.findSubMenuListByPid(-1);
        Map<String, Object> map = new HashMap<>();
        map.put("parentMenuList", menuList);
        ResponseResult result = new ResponseResult(true, 200, "响应成功", map);
        return result;
    }

    /**
     * 查询角色关联菜单列表ID
     */
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId) {
        List<String> menuList = roleService.findMenuByRoleId(roleId);
        ResponseResult result = new ResponseResult(true, 200, "响应成功", menuList);
        return result;
    }


    /* 用户关联菜单 {roleId: 4, menuIdList: [19, 20, 7, 8, 9, 15, 16, 17, 18]} */
    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu(@RequestBody RoleMenuVo roleMenuVo) {
        roleService.roleContextMenu(roleMenuVo);
        ResponseResult result = new ResponseResult(true, 200, "响应成功", null);
        return result;
    }

    /**
     * 删除角色 *
     */
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id) {
        roleService.deleteRole(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "删除角色成功", null);
        return responseResult;
    }


}
