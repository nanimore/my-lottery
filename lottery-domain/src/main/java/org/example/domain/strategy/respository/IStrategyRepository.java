package org.example.domain.strategy.respository;

import org.example.domain.strategy.model.aggregates.StrategyRich;
import org.example.domain.strategy.model.vo.AwardBriefVO;


import java.util.List;

public interface IStrategyRepository {
    StrategyRich queryStrategyRich(Long strategyId);

    AwardBriefVO queryAwardInfo(String awardId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);

    boolean deductStock(Long strategyId, String awardId);
}