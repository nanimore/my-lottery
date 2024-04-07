package org.example.interfaces;


import org.apache.dubbo.config.annotation.Service;
import org.example.common.Constants;
import org.example.common.Result;
import org.example.infrastructure.dao.IActivityDao;
import org.example.infrastructure.po.Activity;
import org.example.rpc.IActivityBooth;
import org.example.rpc.dto.ActivityDto;
import org.example.rpc.req.ActivityReq;
import org.example.rpc.res.ActivityRes;

import javax.annotation.Resource;

/**

 * <p>
 * 活动展台
 */
@Service
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq req) {

        Activity activity = activityDao.queryActivityById(req.getActivityId());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo()), activityDto);
    }

}
