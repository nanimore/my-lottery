package org.example.domain.strategy.model.aggregates;

import javafx.beans.binding.LongExpression;
import lombok.Data;
import org.example.infrastructure.po.Strategy;
import org.example.infrastructure.po.StrategyDetail;

import java.util.List;

@Data
public class StrategyRich {

    private Long strategyId;
    // 策略配置
    private Strategy strategy;
    // 策略明细
    private List<StrategyDetail> strategyDetailList;

    public StrategyRich(){

    }
    public StrategyRich(Long strategyId, Strategy strategy, List<StrategyDetail> strategyDetailList) {
        this.strategyId = strategyId;
        this.strategy = strategy;
        this.strategyDetailList = strategyDetailList;
    }
}
