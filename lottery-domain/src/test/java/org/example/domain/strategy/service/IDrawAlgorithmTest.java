package org.example.domain.strategy.service;

import org.example.domain.strategy.model.aggregates.StrategyRich;
import org.example.domain.strategy.model.vo.AwardRateInfo;
import org.example.domain.strategy.respository.IStrategyRepository;
import org.example.domain.strategy.service.algorithm.IDrawAlgorithm;
import org.example.domain.strategy.service.algorithm.impl.SingleRateRandomDrawAlgorithm;
import org.example.infrastructure.dao.IStrategyDetailDao;
import org.example.infrastructure.po.StrategyDetail;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IDrawAlgorithmTest {

    IDrawAlgorithm drawAlgorithm = new SingleRateRandomDrawAlgorithm();

    @Resource
    private IStrategyRepository strategyRepository;


    Long strategyId = 10001L;
    @Test
    public void initRateTuple() {
        StrategyRich strategyRich = strategyRepository.queryStrategyRich(strategyId);
        List<AwardRateInfo> awardRateInfoList = new ArrayList<>();

        for (StrategyDetail strategyDetail : strategyRich.getStrategyDetailList()) {
            AwardRateInfo awardRateInfo = new AwardRateInfo();
            awardRateInfo.setAwardId(strategyDetail.getAwardId());
            awardRateInfo.setAwardRate(strategyDetail.getAwardRate());
            awardRateInfoList.add(awardRateInfo);
        }
        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
        System.out.println(drawAlgorithm);
    }

    @Test
    public void isExistRateTuple() {
    }

    @Test
    public void randomDraw() {
    }

    @Test
    public void testIStrategyRepository() {
        List<String> strings = strategyRepository.queryNoStockStrategyAwardList(strategyId);
        System.out.println(strings);

    }
}