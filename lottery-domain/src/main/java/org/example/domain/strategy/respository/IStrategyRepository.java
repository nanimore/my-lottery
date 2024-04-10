package org.example.domain.strategy.respository;

import org.example.domain.strategy.model.aggregates.StrategyRich;
import org.example.infrastructure.po.Award;

import java.util.List;

public interface IStrategyRepository {
    StrategyRich queryStrategyRich(Long strategyId);

    Award queryAwardInfo(String awardId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);

    boolean deductStock(Long strategyId, String awardId);
}