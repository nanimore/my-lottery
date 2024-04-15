package org.example.domain.activity.service.partake;


import org.example.domain.activity.model.req.PartakeReq;
import org.example.domain.activity.model.res.PartakeResult;

/**
 * @description: 抽奖活动参与接口
*/
public interface IActivityPartake {

    /**
     * 参与活动
     * @param req 入参
     * @return    领取结果
     */
    PartakeResult doPartake(PartakeReq req);

}
