package com.aliapp.wxxd.website.user.mapper;

import com.aliapp.wxxd.website.user.entity.db.SysRoles;
import com.aliapp.wxxd.website.user.entity.db.SysRolesExample;
import com.aliapp.wxxd.website.user.entity.db.SysUsers;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface SysRolesMapper {
    int countByExample(SysRolesExample example);

    int deleteByExample(SysRolesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRoles record);

    int insertSelective(SysRoles record);

    List<SysRoles> selectByExample(SysRolesExample example);

    SysRoles selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRoles record, @Param("example") SysRolesExample example);

    int updateByExample(@Param("record") SysRoles record, @Param("example") SysRolesExample example);

    int updateByPrimaryKeySelective(SysRoles record);

    int updateByPrimaryKey(SysRoles record);
    
    Set<String> selectRolesByUsername(String username);
}