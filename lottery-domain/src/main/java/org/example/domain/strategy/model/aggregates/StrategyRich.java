package org.example.domain.strategy.model.aggregates;


import lombok.Data;
import org.example.domain.strategy.model.vo.StrategyBriefVO;
import org.example.domain.strategy.model.vo.StrategyDetailBriefVO;

import java.util.List;

/**
 * @description: 抽奖策略聚合对象
 */
@Data
public class StrategyRich {

    private Long strategyId;
    // 策略配置
    private StrategyBriefVO strategy;
    // 策略明细
    private List<StrategyDetailBriefVO> strategyDetailList;

    public StrategyRich(){

    }
    public StrategyRich(Long strategyId, StrategyBriefVO strategy, List<StrategyDetailBriefVO> strategyDetailList) {
        this.strategyId = strategyId;
        this.strategy = strategy;
        this.strategyDetailList = strategyDetailList;
    }
}
