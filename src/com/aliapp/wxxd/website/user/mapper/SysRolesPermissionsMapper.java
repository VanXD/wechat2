package com.aliapp.wxxd.website.user.mapper;

import com.aliapp.wxxd.website.user.entity.db.SysRolesPermissionsExample;
import com.aliapp.wxxd.website.user.entity.db.SysRolesPermissionsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRolesPermissionsMapper {
    int countByExample(SysRolesPermissionsExample example);

    int deleteByExample(SysRolesPermissionsExample example);

    int deleteByPrimaryKey(SysRolesPermissionsKey key);

    int insert(SysRolesPermissionsKey record);

    int insertSelective(SysRolesPermissionsKey record);

    List<SysRolesPermissionsKey> selectByExample(SysRolesPermissionsExample example);

    int updateByExampleSelective(@Param("record") SysRolesPermissionsKey record, @Param("example") SysRolesPermissionsExample example);

    int updateByExample(@Param("record") SysRolesPermissionsKey record, @Param("example") SysRolesPermissionsExample example);
}