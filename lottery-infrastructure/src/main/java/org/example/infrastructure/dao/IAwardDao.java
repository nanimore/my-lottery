package org.example.infrastructure.dao;

import org.example.infrastructure.po.Award;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author nanimo
* @description 针对表【award(奖品配置)】的数据库操作Mapper
* @createDate 2024-04-09 18:22:54
* @Entity generator.domain.Award
*/
public interface IAwardDao extends BaseMapper<Award> {

    /**
     * 插入奖品配置
     *
     * @param list 奖品配置
     */
    void insertList(List<Award> list);
}




