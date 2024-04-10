package org.example.domain.strategy.service.algorithm.impl;


import org.example.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

/**
 * 单项随机概率抽奖，抽到一个已经排掉的奖品则未中奖
 */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds){

        String[] awards = rateTupleMap.get(strategyId);

        if (awards == null) return "奖品为空";

        int randomVal = new SecureRandom().nextInt(100) + 1;

        String award = awards[super.hashIdx(randomVal)];
        if (excludeAwardIds.contains(award)) return "未中奖";

        return award;
    }

}
