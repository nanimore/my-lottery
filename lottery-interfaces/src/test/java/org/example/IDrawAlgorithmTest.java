package org.example;


import org.example.domain.strategy.model.aggregates.StrategyRich;
import org.example.domain.strategy.model.req.DrawReq;
import org.example.domain.strategy.model.vo.AwardRateInfo;
import org.example.domain.strategy.respository.IStrategyRepository;
import org.example.domain.strategy.service.algorithm.IDrawAlgorithm;
import org.example.domain.strategy.service.draw.IDrawExec;
import org.example.infrastructure.dao.IStrategyDetailDao;
import org.example.infrastructure.po.StrategyDetail;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IDrawAlgorithmTest {

    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    @Resource
    private IDrawExec drawExec;

    @Resource
    private IStrategyRepository strategyRepository;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    Long strategyId = 10001L;
    @Before
    public void initRateTuple() {
        StrategyRich strategyRich = strategyRepository.queryStrategyRich(strategyId);
        List<AwardRateInfo> awardRateInfoList = new ArrayList<>();

        for (StrategyDetail strategyDetail : strategyRich.getStrategyDetailList()) {
            AwardRateInfo awardRateInfo = new AwardRateInfo();
            awardRateInfo.setAwardId(strategyDetail.getAwardId());
            awardRateInfo.setAwardRate(strategyDetail.getAwardRate());
            awardRateInfoList.add(awardRateInfo);
        }
        singleRateRandomDrawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
        System.out.println("before");
    }

    @Test
    public void isExistRateTuple() {
        boolean existRateTuple = singleRateRandomDrawAlgorithm.isExistRateTuple(strategyId);
        System.out.println(existRateTuple);
    }

    @Test
    public void randomDraw() {
    }

    @Test
    public void testIStrategyRepository() {
        List<String> strings = strategyRepository.queryNoStockStrategyAwardList(strategyId);
        System.out.println(strings);

    }

    @Test
    public void testDeduct() {

        StrategyDetail strategyDetail = new StrategyDetail();
        strategyDetail.setStrategyId(strategyId);
        strategyDetail.setAwardId("2");

        int count = strategyDetailDao.deductStock(strategyDetail);
        System.out.println(count);
    }
    @Test
    public void test_randomDrawAlgorithm() {

        for (int i = 0; i < 20; i++) {
            DrawReq drawReq = new DrawReq();
            drawReq.setStrategyId(strategyId);
            drawReq.setUId("001");
            System.out.println("中奖结果：" + drawExec.doDrawExec(drawReq).toString());
        }
    }

    @Test
    public void test_drawExec() {
        drawExec.doDrawExec(new DrawReq("小傅哥", 10001L));
        drawExec.doDrawExec(new DrawReq("小佳佳", 10001L));
        drawExec.doDrawExec(new DrawReq("小蜗牛", 10001L));
        drawExec.doDrawExec(new DrawReq("八杯水", 10001L));
    }

}