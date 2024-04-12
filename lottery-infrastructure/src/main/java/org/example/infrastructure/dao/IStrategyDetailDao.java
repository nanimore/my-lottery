package org.example.infrastructure.dao;

import org.example.infrastructure.po.StrategyDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author nanimo
* @description 针对表【strategy_detail(策略明细)】的数据库操作Mapper
* @createDate 2024-04-09 18:32:41
* @Entity generator.domain.StrategyDetail
*/
public interface IStrategyDetailDao extends BaseMapper<StrategyDetail> {

    int deductStock(StrategyDetail strategyDetail);

    void insertList(List<StrategyDetail> list);

}




