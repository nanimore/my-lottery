package org.example.test;

import org.example.infrastructure.dao.IActivityDao;
import org.example.infrastructure.po.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ActivityBoothTest {
    @Resource
    private IActivityDao activityDao;

    @Test
    public void test() {

        Activity activity = activityDao.queryActivityById(100001L);
        System.out.println(activity.toString());
    }

}
