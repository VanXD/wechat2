package mapper;

import entity.db.MaterialCount;
import entity.db.MaterialCountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialCountMapper {
    int countByExample(MaterialCountExample example);

    int deleteByExample(MaterialCountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MaterialCount record);

    int insertSelective(MaterialCount record);

    List<MaterialCount> selectByExample(MaterialCountExample example);

    MaterialCount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MaterialCount record, @Param("example") MaterialCountExample example);

    int updateByExample(@Param("record") MaterialCount record, @Param("example") MaterialCountExample example);

    int updateByPrimaryKeySelective(MaterialCount record);

    int updateByPrimaryKey(MaterialCount record);
    
    int increaseByPrimaryKeySelective(MaterialCount record);
}