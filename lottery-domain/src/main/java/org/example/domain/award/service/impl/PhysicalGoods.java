package org.example.domain.award.service.impl;


import org.example.common.Constants;
import org.example.domain.award.model.req.GoodsReq;
import org.example.domain.award.model.res.DistributionRes;
import org.example.domain.award.service.DistributionBase;
import org.example.domain.award.service.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * @description: 实物发货类商品
*/
@Component
public class PhysicalGoods extends DistributionBase implements IDistributionGoods {

    @Override
    public DistributionRes doDistribution(GoodsReq req) {

        // 模拟调用实物发奖
        logger.info("模拟调用实物发奖 uId：{} awardContent：{}", req.getUId(), req.getAwardContent());

        // 更新用户领奖结果
        super.updateUserAwardState(req.getUId(), req.getOrderId(), req.getAwardId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());

        return new DistributionRes(req.getUId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }

}
