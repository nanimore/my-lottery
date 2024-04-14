package org.example.domain.strategy.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import org.example.domain.strategy.model.aggregates.StrategyRich;
import org.example.domain.strategy.model.vo.AwardRateInfo;
import org.example.domain.strategy.model.vo.StrategyDetailBriefVO;
import org.example.domain.strategy.respository.IStrategyRepository;
import org.example.domain.strategy.service.algorithm.IDrawAlgorithm;
import org.example.domain.strategy.service.algorithm.impl.SingleRateRandomDrawAlgorithm;

import org.example.domain.support.ids.IIdGenerator;
import org.example.domain.support.ids.IdContext;
import org.example.domain.support.ids.policy.SnowFlake;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class IDrawAlgorithmTest {

    IDrawAlgorithm drawAlgorithm = new SingleRateRandomDrawAlgorithm();

    @Resource
    private IStrategyRepository strategyRepository;


    Long strategyId = 10001L;
    @Test
    public void initRateTuple() {
        StrategyRich strategyRich = strategyRepository.queryStrategyRich(strategyId);
        List<AwardRateInfo> awardRateInfoList = new ArrayList<>();

        for (StrategyDetailBriefVO strategyDetail : strategyRich.getStrategyDetailList()) {
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

    private IIdGenerator idGenerator = new SnowFlake();
    @Test
    public void test_snowflake() {
        long l = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        System.out.println(l);
        int i = NetUtil.getLocalhostStr().hashCode();
        System.out.println(i);
        System.out.println(NetUtil.getLocalhostStr());

        System.out.println(idGenerator.nextId());
    }

    @Test
    public void test_snowflak() {
        //参数1：workerId 终端ID
        //参数2：dataCenterId 数据中心id
        Snowflake snowflake = IdUtil.createSnowflake(1,1);
        long id = snowflake.nextId();
        System.out.println("雪花算法1（每次生成一个新对象）实现："+id);

        Snowflake secondSnow = IdUtil.getSnowflake(1,1);
        String secondId = secondSnow.nextIdStr();
        System.out.println("单例雪花算法2实现："+secondId);


        //注：该方法只能在最新版本5.8.16版本
//        long threeSnow = IdUtil.getSnowflakeNextId();
//        System.out.println("单例雪花算法3实现(5.8.16版本)："+threeSnow);
    }
}