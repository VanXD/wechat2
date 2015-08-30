package com.aliapp.wxxd.website.user.mapper;

import com.aliapp.wxxd.website.user.entity.db.SysPermissions;
import com.aliapp.wxxd.website.user.entity.db.SysPermissionsExample;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface SysPermissionsMapper {
    int countByExample(SysPermissionsExample example);

    int deleteByExample(SysPermissionsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysPermissions record);

    int insertSelective(SysPermissions record);

    List<SysPermissions> selectByExample(SysPermissionsExample example);

    SysPermissions selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysPermissions record, @Param("example") SysPermissionsExample example);

    int updateByExample(@Param("record") SysPermissions record, @Param("example") SysPermissionsExample example);

    int updateByPrimaryKeySelective(SysPermissions record);

    int updateByPrimaryKey(SysPermissions record);
    
    Set<String> selectPermissionsByUsername(String username);
}