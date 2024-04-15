package org.example.domain.activity.service.partake;



import org.example.domain.activity.model.req.PartakeReq;
import org.example.domain.activity.model.vo.ActivityBillVO;
import org.example.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @description: 活动领取模操作，一些通用的数据服务
*/
public class ActivityPartakeSupport {

    @Resource
    protected IActivityRepository activityRepository;

    protected ActivityBillVO queryActivityBill(PartakeReq req){
        return activityRepository.queryActivityBill(req);
    }

}
