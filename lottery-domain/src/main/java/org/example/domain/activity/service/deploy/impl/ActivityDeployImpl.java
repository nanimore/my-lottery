package org.example.domain.activity.service.deploy.impl;


import com.alibaba.fastjson.JSON;
import org.example.domain.activity.model.aggregates.ActivityConfigRich;
import org.example.domain.activity.model.aggregates.ActivityInfoLimitPageRich;
import org.example.domain.activity.model.req.ActivityConfigReq;
import org.example.domain.activity.model.req.ActivityInfoLimitPageReq;
import org.example.domain.activity.model.vo.ActivityVO;
import org.example.domain.activity.model.vo.AwardVO;
import org.example.domain.activity.model.vo.StrategyDetailVO;
import org.example.domain.activity.model.vo.StrategyVO;
import org.example.domain.activity.repository.IActivityRepository;
import org.example.domain.activity.service.deploy.IActivityDeploy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;


import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 部署活动配置服务
*/
@Service
public class ActivityDeployImpl implements IActivityDeploy {

    private static final Logger logger = LoggerFactory.getLogger(ActivityDeployImpl.class);

    @Resource
    private IActivityRepository activityRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createActivity(ActivityConfigReq req) {
        logger.info("创建活动配置开始，activityId：{}", req.getActivityId());
        ActivityConfigRich activityConfigRich = req.getActivityConfigRich();
        try {
            // 添加活动配置
            ActivityVO activity = activityConfigRich.getActivity();
            activityRepository.addActivity(activity);

            // 添加奖品配置
            List<AwardVO> awardList = activityConfigRich.getAwardList();
            activityRepository.addAward(awardList);

            // 添加策略配置
            StrategyVO strategy = activityConfigRich.getStrategy();
            activityRepository.addStrategy(strategy);

            // 添加策略明细配置
            List<StrategyDetailVO> strategyDetailList = activityConfigRich.getStrategy().getStrategyDetailList();
            activityRepository.addStrategyDetailList(strategyDetailList);

            logger.info("创建活动配置完成，activityId：{}", req.getActivityId());
        } catch (DuplicateKeyException e) {
            logger.error("创建活动配置失败，唯一索引冲突 activityId：{} reqJson：{}", req.getActivityId(), JSON.toJSONString(req), e);
            throw e;
        }
    }

    @Override
    public void updateActivity(ActivityConfigReq req) {
        // TODO: 非核心功能后续补充
    }

    @Override
    public List<ActivityVO> scanToDoActivityList(Long id) {
        return activityRepository.scanToDoActivityList(id);
    }

    @Override
    public ActivityInfoLimitPageRich queryActivityInfoLimitPage(ActivityInfoLimitPageReq req) {
        return activityRepository.queryActivityInfoLimitPage(req);
    }

}
