package org.example.test;

import org.example.infrastructure.dao.IActivityDao;
import org.example.infrastructure.dao.IStrategyDao;
import org.example.infrastructure.po.Activity;
import org.example.infrastructure.po.Strategy;
import org.example.rpc.dto.ActivityDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class DaoTest {

    @Resource
    private IStrategyDao strategyDao;
    @Resource
    private IActivityDao activityDao;

    @Test
    public void teststrategyDao(){
        Strategy strategy = strategyDao.selectById(1L);
        System.out.println(strategy);

    }

    @Test
    public void testactivityDao(){
        Activity activity = activityDao.queryActivityById(100001L);
        System.out.println(activity);

    }


    @Test
    public void testStrategyRepository() {

    }
}
