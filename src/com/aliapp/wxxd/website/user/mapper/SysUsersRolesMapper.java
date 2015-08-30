package com.aliapp.wxxd.website.user.mapper;

import com.aliapp.wxxd.website.user.entity.db.SysUsersRolesExample;
import com.aliapp.wxxd.website.user.entity.db.SysUsersRolesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUsersRolesMapper {
    int countByExample(SysUsersRolesExample example);

    int deleteByExample(SysUsersRolesExample example);

    int deleteByPrimaryKey(SysUsersRolesKey key);

    int insert(SysUsersRolesKey record);

    int insertSelective(SysUsersRolesKey record);

    List<SysUsersRolesKey> selectByExample(SysUsersRolesExample example);

    int updateByExampleSelective(@Param("record") SysUsersRolesKey record, @Param("example") SysUsersRolesExample example);

    int updateByExample(@Param("record") SysUsersRolesKey record, @Param("example") SysUsersRolesExample example);
}